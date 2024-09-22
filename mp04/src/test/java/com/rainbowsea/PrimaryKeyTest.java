package com.rainbowsea;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
//import com.rainbowsea.mapper.UserMapper2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class PrimaryKeyTest {


    @Autowired
    //@Resource
    private UserMapper userMapper;


    @Test
    void select() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }


    @Test
    void primary() {
        User user = new User();
        user.setName("Mary");
        user.setAge(29);
        user.setEmail("mary@rainbowsea.com");

        userMapper.insert(user);
    }

}








