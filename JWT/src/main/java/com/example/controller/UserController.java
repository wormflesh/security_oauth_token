package com.example.controller;


import com.example.common.request.RequestParams;
import com.example.common.result.Result;
import com.example.service.IUserService;
import com.example.vo.AuthVO;
import com.example.vo.UserVO;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wormflesh
 * @since 2022-12-01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    /**
     * @description: 用户登录
     * @param: [params]
     * @return: com.wormflesh.blog.result.Result<AuthVO>
     **/
    @PostMapping("/login")
    public Result<AuthVO> login(@RequestBody RequestParams params) {
        String userLogin = params.getStringValue("userLogin");
        String userPass = params.getStringValue("userPass");
        return iUserService.login(userLogin, userPass);
    }

    /**
     * @description: 获取已经登陆的用户信息
     * @param: [request, response, handler]
     * @return: com.wormflesh.blog.result.Result<com.wormflesh.blog.vo.UserVO>
     **/
    @PostMapping("/login/getInfo")
    public Result<UserVO> getInfo(HttpServletRequest request, HttpServletResponse response, Object handler) {
        var token = request.getHeader("token");
        return iUserService.getInfo(token);
    }
}
