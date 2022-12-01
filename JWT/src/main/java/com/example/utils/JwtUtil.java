package com.example.utils;

import com.example.common.constant.JwtConstant;
import com.example.vo.UserVO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName JwtUtil
 * @description: Jwt工具
 * @author: WormFlesh
 * @create: 2022-11-03 01:40
 **/
@Component
public class JwtUtil {


    /**
     * 构建JWT对象
     * @param expire
     * @param userVO
     * @return
     */
    public static String buildJwt(Date expire, UserVO userVO) {
        String jwt = Jwts.builder()
                // 使用HS256加密算法
                .signWith(SignatureAlgorithm.HS256, JwtConstant.SECRET_KEY)
                // 过期时间
                .setExpiration(expire)
                .claim("userLogin",userVO.getUserLogin())
                .claim("userNicename",userVO.getUserNickname())
                .claim("userEmail",userVO.getUserEmail())
                .claim("userProfileUrl",userVO.getUserProfileUrl())
//                .claim("user_id",userVO.getUser_id())
                .compact();
        return jwt;
    }

}
