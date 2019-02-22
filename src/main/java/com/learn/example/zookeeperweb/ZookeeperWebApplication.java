package com.learn.example.zookeeperweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jingjing.zhang
 */
@SpringBootApplication
@MapperScan("com.learn.example.zookeeperweb.dao")
public class ZookeeperWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperWebApplication.class, args);
    }

}
