package com.october.wiki;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.october.wiki.mapper")
public class OctoberApplication {

    public static void main(String[] args) {
        SpringApplication.run(OctoberApplication.class, args);
    }

}
