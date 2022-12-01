package com.example.service;

import com.example.common.result.Result;
import com.example.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.AuthVO;
import com.example.vo.UserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wormflesh
 * @since 2022-12-01
 */
public interface IUserService extends IService<User> {
    Result<AuthVO> login(String userLogin, String userPass);

    Result<UserVO> getInfo(String token);

}
