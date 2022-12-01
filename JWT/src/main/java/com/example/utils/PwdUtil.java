package com.example.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


/**
 * @ClassName PwdUtil
 * @description: 用户密码加密与解密
 * @author: WormFlesh
 * @create: 2022-11-03 01:20
 **/
public class PwdUtil {

    /**
     * @description: 获取用户盐值，用于加密用户密码
     * @date: 2022/10/9 21:02
     * @param: [user_login]
     * @return: java.lang.String
     **/
    public static String getSalt(String userLogin){
        String[] salt = {"January", "February", "April", "May", "July", "August", "September", "November", "December"};
        int hashCode = userLogin.hashCode() + 159;
        int mod = Math.abs( hashCode % 9);
        return salt[mod];
    }

    /**
     * @description: 获取用户加密密码
     * @date: 2022/10/10 0:33
     * @param: [user_login, password]
     * @return: java.lang.String
     **/
    public static String getSalt(String userLogin, String password){
        String pwdAndSalt = password + getSalt(userLogin);
        try {
            return MD5Util.MD5Encode(pwdAndSalt, "utf8");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}