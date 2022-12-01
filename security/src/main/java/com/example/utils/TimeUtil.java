package com.example.utils;

import java.time.LocalDateTime;

/**
 * @ClassName TimeUtil
 * @description: 获取当前时间
 * @author: WormFlesh
 * @create: 2022-10-31 22:30
 **/
public class TimeUtil {

    public static LocalDateTime getCurrentTime(){
        return LocalDateTime.now();
    }
}