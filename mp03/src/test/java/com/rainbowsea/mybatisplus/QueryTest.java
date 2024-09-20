package com.rainbowsea.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;


@SpringBootTest  // 注意这个测试必须要有一个场景类才行，不然是无法运行的。测试的类不同的话，还需要指明
// 包
public class QueryTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    void eq() {
        // 1.创建条件查询对象
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 2. 设置查询条件，指定查询的字段和匹配的值
        QueryWrapper<User> eq = userQueryWrapper.eq("name", "Jone");

        // 3. 进行条件查询
        User user = userMapper.selectOne(eq);
        System.out.println(user);

    }



    @Test
    void eq2(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> queryWrapper = lambdaQueryWrapper.eq(User::getName, "Jone");

       User user =  userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }



    @Test
    void isNull() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> queryWrapper = lambdaQueryWrapper.eq(User::getName, null);

        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    void isNull2() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = null;
        //String name = "Jone";

        //  public Children eq(boolean condition, R column, Object val) {
        lambdaQueryWrapper.eq(name !=null,User::getName,name);
        //User user = userMapper.selectOne(lambdaQueryWrapper);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);

    }



    @Test
    void allEql() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName,"Tom");
        lambdaQueryWrapper.eq(User::getAge,18);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println(user);
    }


    @Test
    void allEq2() {

        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("name","Tom");
        hashMap.put("age",18);

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.allEq(hashMap,false);

        User user = userMapper.selectOne(userQueryWrapper);
        System.out.println(user);
    }

}
