package com.woniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.woniu.dao")
public class SpringsecurityHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityHomeworkApplication.class, args);
    }

}
