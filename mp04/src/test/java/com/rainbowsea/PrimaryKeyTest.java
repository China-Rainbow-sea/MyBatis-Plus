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
    void primary() {
        User user = new User();
        user.setName("张三4");
        user.setAge(19);
        user.setEmail("mary@rainbowsea.com");

        userMapper.insert(user);
    }



    @Test
    void primaryKey(){
        User user = new User();
        user.setId("4");
        user.setName("Jerry");
        user.setAge(38);
        user.setEmail("test8@powernode.com");
        userMapper.insert(user);
    }






    @Test
    void select() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }




}








