package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName JWTApplication
 * @description:
 * @author: WormFlesh
 * @create: 2022-12-01 19:48
 **/
@SpringBootApplication
@MapperScan("com.example.mapper")
public class JWTApplication {
    public static void main(String[] args) {
        SpringApplication.run(JWTApplication.class, args);
    }
}
