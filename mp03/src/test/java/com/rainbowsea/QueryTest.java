package com.rainbowsea;

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


    // 使用: LambdaQueryWrapper 进行引用查询，防止报错
    @Test
    void eq2() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> queryWrapper = lambdaQueryWrapper.eq(User::getName, "Jone");

        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }


    // 字段值为null的
    @Test
    void isNull() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> queryWrapper = lambdaQueryWrapper.eq(User::getName, null);

        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }


    // 字段名为 不null的
    @Test
    void isNull2() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = null;
        //String name = "Jone";

        //  public Children eq(boolean condition, R column, Object val) {
        lambdaQueryWrapper.eq(name != null, User::getName, name);
        //User user = userMapper.selectOne(lambdaQueryWrapper);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);

    }


    // and 满足多个条件
    @Test
    void allEql() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName, "Tom");
        lambdaQueryWrapper.eq(User::getAge, 18);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println(user);
    }


    // 属性值为 null 的查询，属性值不为 Null的不查询该字段
    @Test
    void allEq2() {

        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("name", "Tom");
        //hashMap.put("age",18);
        hashMap.put("age", null);  // 为null 的属性值，则会不查询

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //userQueryWrapper.allEq(hashMap,false); //  // 为null 的属性值，则会不查询
        userQueryWrapper.allEq(hashMap, true);  // 为null,(name = ? AND age IS NULL) 查询

        User user = userMapper.selectOne(userQueryWrapper);
        System.out.println(user);
    }


    // 不等于数值的
    @Test
    void ne() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.ne(User::getName, "Tom");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);

    }


    // > 查询
    @Test
    void gt() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Integer age = 18;
        lambdaQueryWrapper.gt(User::getAge, age);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }

    // >=查询
    @Test
    void ge() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Integer age = 18;
        lambdaQueryWrapper.ge(User::getAge, age);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    // <
    @Test
    void lt() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Integer age = 20;
        lambdaQueryWrapper.lt(User::getAge, age);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    // <=
    @Test
    void le() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        Integer age = 20;
        LambdaQueryWrapper<User> lambdaQueryWrapper1 = lambdaQueryWrapper.le(User::getAge, age);

        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }


    // 范围之间
    @Test
    void between() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.between(User::getAge, 10, 20);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);

    }



    // 不在范围的：  (age NOT BETWEEN ? AND ?)
    @Test
    void notBetween() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notBetween(User::getAge,10,18);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }



    // 模糊查询: %J%(String)
    @Test
    void like() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,"J");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }



    // 不包含该:  %J%(String) 模糊查询信息
    @Test
    void notLike() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.notLike(User::getName,"J");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }




    // 模糊查询:  %e(String) 左边
    @Test
    void likeft() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.likeLeft(User::getName,"e");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);

    }



    // 模糊查询: e%(String)
    @Test
    void likeRight() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.likeRight(User::getName,"e");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
    }





}
