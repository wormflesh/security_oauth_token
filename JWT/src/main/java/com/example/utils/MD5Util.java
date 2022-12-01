package com.example.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MD5Util
 * @description: MD5工具类
 * @author: WormFlesh
 * @create: 2022-10-09 22:48
 **/
public class MD5Util {
    private static final String HEX_DIGITS[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};   // 十六进制

    /**
     * @description: MD5加密
     * @date: 2022/10/9 22:50
     * @param: [origin, charsetname]
     * @return: java.lang.String
     **/
    public static String MD5Encode(String origin, String charsetname) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String resultString = null;
        resultString = new String(origin);
        MessageDigest md = MessageDigest.getInstance("MD5");
        // charsetname 为空
        if (null == charsetname || "".equals(charsetname)) {
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        }else {
            resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
        }

        return resultString;
    }

    /**
     * @description: 数组到十六进制字符串
     * @date: 2022/10/10 22:41
     * @param: [b]
     * @return: java.lang.String
     **/
    public static String byteArrayToHexString(byte b[]){
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }


    /**
     * @description: 字节到十六进制字符串
     * @date: 2022/10/10 22:49
     * @param: [b]
     * @return: java.lang.String
     **/
    public static String byteToHexString(byte b){
        int n = b;
        if(n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }
}