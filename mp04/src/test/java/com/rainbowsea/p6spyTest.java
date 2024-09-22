package com.rainbowsea;


import com.rainbowsea.mapper.UserMapper;
import com.rainbowsea.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class p6spyTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testP6spy() {
        User user = userMapper.selectById("6");
        System.out.println(user);
    }

}
