package com.rainbowsea.mybatisplus;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@SpringBootTest
public class QueryTest03 {

    @Autowired
    private UserMapper userMapper;


    // select age,count(*) as field_count from rainbowsea_user group by age;
    // 分组查询
    @Test
    void groupBy() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 分组字段
        queryWrapper.groupBy("age");
        // 查询字段
        queryWrapper.select("age,count(*) as field_count");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);

        System.out.println(maps);

    }


    // select age,count(*) as field_count from rainbowsea_user group by age HAVING field_count >=2;
    // 聚合查询
    @Test
    void having() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 查询字段
        userQueryWrapper.select("age,count(*) as field_count");
        // 聚合条件筛选
        userQueryWrapper.having("field_count = 1");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        System.out.println(maps);
    }


    // 降序
    @Test
    void orderByAsc() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByAsc(User::getAge, User::getId);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    // 升序
    @Test
    void orderByDesc() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(User::getAge, User::getId);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    @Test
    void orderBy() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 设置排序字段和排序的方式
        // 参数1：如果排序字段的值为null的时候，是否还要作为排序字段参与排序
        // 参数2：是否升序排序，
        // 参数3: 排序字段
        //lambdaQueryWrapper.orderBy(true, true, User::getAge);
        lambdaQueryWrapper.orderBy(false, true, User::getAge);
        lambdaQueryWrapper.orderBy(true, false, User::getId);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    //   // 可能会根据不同的请情况选择拼接不同的查询条件
    @Test
    void func() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        // 可能会根据不同的请情况选择拼接不同的查询条件
      /*  lambdaQueryWrapper.func(new Consumer<LambdaQueryWrapper<User>>() {
            @Override
            public void accept(LambdaQueryWrapper<User> userLambdaQueryWrapper) {
                //if (true) {
                if (false) {
                    userLambdaQueryWrapper.eq(User::getId,1);
                } else {
                    userLambdaQueryWrapper.ne(User::getId,1);
                }
            }
        });*/

        // 使用lambad表达式
        lambdaQueryWrapper.func(userLambdaQueryWrapper -> {
            if (false) {
                userLambdaQueryWrapper.eq(User::getId, 1);
            } else {
                userLambdaQueryWrapper.ne(User::getId, 1);
            }
        });
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    //  WHERE (age > ? AND age < ?)
    @Test
    void and() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.gt(User::getAge, 22).lt(User::getAge, 30);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    // WHERE (name = ? AND (age > ? OR age < ?))
    @Test
    void add2() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName, "wang").and(i -> i.gt(User::getAge, 26).or().lt(User::getAge, 22));
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    //  WHERE (age < ? AND age > ?)
    @Test
    void or() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.lt(User::getAge, 20).gt(User::getAge, 23);// age < 20 || age >=23
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    @Test
    void or2() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName,"wang").or(i->i.gt(User::getAge,22).lt(User::getAge,26));
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }



    //  WHERE ((name = ? AND age <> ?))
    @Test
    void nested() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.nested(i->i.eq(User::getName,"Tom").ne(User::getAge,22));
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }



    // 自定义条件查询
    @Test
    void apply() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.apply("id = 1");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    // 最后添加字符拼接
    // SELECT id,name,age,email,`desc` FROM rainbowsea_user limit 0,2
    @Test
    void last() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.last("limit 0,2");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    // SELECT * from rainbowsea_user WHERE EXISTS (select id FROM rainbowsea_user WHERE age = 18);
    // SELECT * from rainbowsea_user WHERE EXISTS (select id FROM rainbowsea_user WHERE age = 10);

    @Test
    void exists() {
        // 1. 创建QueryWrapper对象
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 2. 构建查询条件
        //lambdaQueryWrapper.exists("select id FROM rainbowsea_user WHERE age = 18");
        lambdaQueryWrapper.exists("select id FROM rainbowsea_user WHERE age = 10");
        // 3.查询
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


//  SELECT * from rainbowsea_user WHERE not EXISTS (select id FROM rainbowsea_user WHERE age = 10);
    @Test
    void notExists() {
        // 1. 创建QueryWrapper对象
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 2. 构建查询条件
        //lambdaQueryWrapper.exists("select id FROM rainbowsea_user WHERE age = 18");
        lambdaQueryWrapper.notExists("select id FROM rainbowsea_user WHERE age = 10");
        // 3.查询
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    @Test
    void select() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(User::getId,User::getName);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }
}

