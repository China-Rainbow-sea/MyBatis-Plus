package com.rainbowsea;


import com.rainbowsea.enums.GenderEnum;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import com.rainbowsea.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class enumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void enumTest() {
        User user = new User();
        user.setName("LiHu");
        user.setAge(18);
        user.setEmail("lihua@rainbowsea.com");
        user.setStatus(1);
        user.setGender(GenderEnum.WOMAN);
        System.out.println(GenderEnum.WOMAN);

        userMapper.insert(user);



    }
}
