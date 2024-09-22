package com.rainbowsea;


import com.rainbowsea.bean.User;
import com.rainbowsea.enums.GenderEnum;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FillTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    void testFillInsert() {
        User user = new User();
        user.setName("LiHu");
        user.setAge(18);
        user.setEmail("lihua@rainbowsea.com");
        user.setStatus(1);

        userMapper.insert(user);
    }


    @Test
    void testFillUpdate() {
        //1837826196875464706
        User user = new User();
        user.setName("wangwu");
        user.setId("1837826196875464706");
        user.setAge(18);
        user.setEmail("lihua@rainbowsea.com");
        user.setStatus(1);

        userMapper.updateById(user);

    }
}
