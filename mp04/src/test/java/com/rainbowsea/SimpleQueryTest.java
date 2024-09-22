//package com.rainbowsea;
//
//
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
//import com.rainbowsea.bean.User;
//import com.rainbowsea.mapper.UserMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@SpringBootTest
//public class SimpleQueryTest {
//
//    @Resource
//    private UserMapper userMapper;
//
//    @Test
//    void testList() {
//        List<String> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Mary"), User::getId);
//        System.out.println(list);
//    }
//}
