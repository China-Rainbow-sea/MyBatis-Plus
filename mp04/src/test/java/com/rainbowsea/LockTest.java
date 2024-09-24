package com.rainbowsea;


import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LockTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void updateTest2() {
        // 模拟操作1的查询操作
        User user1 = userMapper.selectById("5");
        System.out.println("查询结果:" + user1);

        // 模拟操作2的查询操作
        User user2 = userMapper.selectById("5");
        System.out.println("查询结果:" + user2);

        // 模拟操作2的修改操作
        user2.setName("liHua");
        userMapper.updateById(user2);

        // 模拟操作1的修改操作
        user1.setName("zhangsan");
        userMapper.updateById(user1);
    }


    @Test
    void updateTest() {
        User user = userMapper.selectById("5");
        System.out.println("查询结果:" + user);
        user.setName("li");
        userMapper.updateById(user);
    }



}
