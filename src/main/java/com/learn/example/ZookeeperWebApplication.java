package com.learn.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jingjing.zhang
 */
@SpringBootApplication
@MapperScan("com.learn.example.dao")
public class ZookeeperWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperWebApplication.class, args);
    }

}
