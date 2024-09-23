package com.rainbowsea;


import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class TypeHandLerTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void typeHandlerSelect() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void typeHandler() {
        User user = new User();
        user.setName("zhang3");
        user.setAge(28);
        user.setEmail("zhang@powernode.com");
        user.setStatus(1);
        HashMap<String, String> contact = new HashMap<>();
        contact.put("phone","010-1234567");
        contact.put("tel","13388889999");
        user.setContact(contact);

        userMapper.insert(user);
    }



}
