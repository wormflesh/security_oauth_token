package com.example.vo;

import lombok.Data;

/**
 * @ClassName UserVO
 * @description:
 * @author: WormFlesh
 * @create: 2022-11-03 01:31
 **/
@Data
public class UserVO {

    private String userLogin;
    private String userNickname;
    private String userEmail;
    private String userProfileUrl;
}