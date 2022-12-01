package com.example.service.impl;

import com.example.common.constant.JwtConstant;
import com.example.common.result.Result;
import com.example.common.result.ResultUtil;
import com.example.pojo.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.utils.JwtUtil;
import com.example.utils.PwdUtil;
import com.example.vo.AuthVO;
import com.example.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wormflesh
 * @since 2022-12-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @description: 用户登录
     * @date: 2022/11/3 1:38
     * @param: [userLogin, userPass]
     * @return: com.wormflesh.blog.result.Result<com.wormflesh.blog.vo.AuthVO>
     **/
    @Override
    public Result<AuthVO> login(String userLogin, String userPass) {
        User user = userMapper.selectByUserLogin(userLogin);
        try {
            // 查无账户
            if (null == user) {
                return ResultUtil.notFound().buildMessage("登录失败，用户不存在！");
            }

            // 校验用户密码
            String encryptPwd = PwdUtil.getSalt(userLogin, userPass);
            if (!user.getUserPass().equals(encryptPwd)) {
                return ResultUtil.fail().buildMessage("登陆失败，密码错误, 请输入正确密码");
            }

            //登陆成功，返回用户信息
            AuthVO authVO = new AuthVO();
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            authVO.setToken(JwtUtil.buildJwt(getLoginExpore(), userVO));
            authVO.setUserVO(userVO);
            // 将用户信息加入缓存
            redisTemplate.opsForValue().set(authVO.getToken(), userVO);
            return ResultUtil.success(authVO);
        } catch (Exception e) {
            // LOGGER.error("登录失败了！{}; loginName:{}", ex, loginName);
            return ResultUtil.fail().buildMessage("登录失败，服务器被吃了＝(#>д<)ﾉ ！请重试。 ");
        }
    }

    /**
     * @description: 获取用户信息
     * @param: [token]
     * @return: com.example.common.result.Result<com.example.vo.UserVO>
     **/
    @Override
    public Result<UserVO> getInfo(String token) {
        // 从session获取用户信息
        Object userVO = redisTemplate.opsForValue().get(token);
        return ResultUtil.success(userVO);
    }

    /**
     * @description: 获得登陆时间
     * @return: java.util.Date
     **/
    private Date getLoginExpore() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, JwtConstant.EXPIRE_DAY);
        return calendar.getTime();
    }

}
