package com.cat.photography;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cat.photography.mapper")
public class PhotographyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotographyApplication.class , args);
    }

}
