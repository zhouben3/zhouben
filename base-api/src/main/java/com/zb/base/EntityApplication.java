package com.zb.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zb.base.mapper")
public class EntityApplication {
    public static void main(String[] args) {
        SpringApplication.run(EntityApplication.class, args);
    }

}
