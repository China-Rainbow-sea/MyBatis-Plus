package com.rainbowsea;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@MapperScan({"com.rainbowsea.mapper"})

@SpringBootApplication
public class Mp04Application {

    public static void main(String[] args) {
        SpringApplication.run(Mp04Application.class, args);
    }

}
