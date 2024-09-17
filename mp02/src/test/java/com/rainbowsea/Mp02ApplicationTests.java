package com.rainbowsea;


import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import com.rainbowsea.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = Mp02Application.class)  // Spring Boot 当中的测试，必须要有 项目的启动场景，不然无法测试报错
class Mp02ApplicationTests {

    @Resource
    private UserMapper userMapper;


    // 测试自定义方法
    @Test
    void myMethod() {
        User tom = userMapper.selectByName("Lihua");
        System.out.println(tom);
    }



    @Autowired
    private UserService userService;



    // UserService 查询
    @Test
    void selectService() {
        List<User> users = userService.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }



    // userService 修改
    @Test
    void updateService() {
        User user = new User();
        user.setId(3L);
        user.setAge(22);

        userService.updateById(user);
    }




    // UserService 删除
    @Test
    void deleteServie() {
        userService.removeById(2L);
    }


    //  UserService 添加
    @Test
    void insertService() {
        User user = new User();
        user.setId(7L);
        user.setAge(18);
        user.setName("Tom");
        user.setEmail("Tom@baomidou.com");

        userService.save(user);

    }














    // 简单查询
    @Test
    void selectById() {
        User user = userMapper.selectById(6L);
        System.out.println(user);
    }



    // 简单更新
    @Test
    void updateById() {
        User user = new User();
        user.setId(2L);
        user.setAge(18);
        user.setName("李华");
        user.setEmail("lihua@baomidou.com");

        userMapper.updateById(user);
    }


    // 简单删除
    @Test
    void deleteOne() {
        userMapper.deleteById(4L);

    }




    // 简单添加
    @Test
    void insert() {

        User user = new User();
        user.setId(6L);
        user.setAge(18);
        user.setName("Lihua");
        user.setEmail("test6@baomidou.com");
        userMapper.insert(user);
    }



    // 查询所有
    @Test
    void selectList() {
        List<User> users = userMapper.selectList(null);

        for (User user : users) {
            System.out.println(user);
        }
    }








    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////






    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        System.out.println(jdbcTemplate.getDataSource().getClass());

    }

}
