package com.rainbowsea;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

@SpringBootTest
class Mp03ApplicationTests {

    @Test
    void contextLoads() {
    }




    @Resource
    //@Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void getDataSourceTest() {
        System.out.println(jdbcTemplate.getDataSource().getClass());
    }

}
