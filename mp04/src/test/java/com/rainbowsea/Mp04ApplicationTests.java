package com.rainbowsea;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@SpringBootTest  // 必须要有项目的场景启动器
class Mp04ApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {

        System.out.println(jdbcTemplate.getDataSource().getClass());

    }



}
