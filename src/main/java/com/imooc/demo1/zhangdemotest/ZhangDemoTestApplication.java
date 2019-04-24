package com.imooc.demo1.zhangdemotest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.imooc.demo1.zhangdemotest.dao")
public class ZhangDemoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhangDemoTestApplication.class, args);
    }

}
