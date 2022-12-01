package com.example.vo;

import lombok.Data;

/**
 * @ClassName AuthVO
 * @description:
 * @author: WormFlesh
 * @create: 2022-11-03 01:36
 **/
@Data
public class AuthVO {

    private String token;
    private UserVO userVO;
}