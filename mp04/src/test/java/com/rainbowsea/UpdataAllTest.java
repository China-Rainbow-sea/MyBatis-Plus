package com.rainbowsea;


import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdataAllTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    void updateAll() {
        User user = new User();
        user.setTest(1);

        userMapper.update(user,null);

    }
}
