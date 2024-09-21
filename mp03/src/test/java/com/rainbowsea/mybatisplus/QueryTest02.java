package com.rainbowsea.mybatisplus;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class QueryTest02 {
    @Resource
    private UserMapper userMapper;


    // RE (age NOT IN (select age from rainbowsea_user where age > 20))
    @Test
    void notInSql2() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notInSql(User::getAge, "select age from rainbowsea_user where age > 20");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    // age NOT IN (18,20,22))
    @Test
    void notInsql() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notInSql(User::getAge, "18,20,22");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    // er WHERE (age IN (18,20,22))
    @Test
    void inSql() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(User::getAge, "18,20,22");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    // 字段！=值 and 字段！=值 ->not in
    //  WHERE (age NOT IN (?,?,?))
    @Test
    void notIn() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 18, 20, 22);
        lambdaQueryWrapper.notIn(User::getAge, arrayList);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }



    // 字段 = 值 or 字段 = 值 ->in
    // r WHERE (age IN (?,?,?))
    @Test
    void in() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 18, 20, 22);
        lambdaQueryWrapper.in(User::getAge, arrayList);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);

    }


    //  WHERE (name IS NULL)
    @Test
    void isNotNull() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.isNotNull(User::getName);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    // 判断是否为 null  WHERE (name IS NULL)
    @Test
    void isNUll3() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.isNull(User::getName);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }










    @Test
    void inSql2() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(User::getAge, "select age from rainbowsea_user where age > 20");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }







}
