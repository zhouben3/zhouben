package com.zb.spider9002;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
        //(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.zb.base.mapper")
public class Spider9002Application {

    public static void main(String[] args) {

        //System.out.println(positionEntityMapper);
        SpringApplication.run(Spider9002Application.class, args);
    }

}
