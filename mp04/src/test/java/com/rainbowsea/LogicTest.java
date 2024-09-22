package com.rainbowsea;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class LogicTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void logicDelete() {
        userMapper.deleteById("6");
    }



    @Test
    void logicSelect() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
}
