package com.rainbowsea;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class PageTest {

    @Resource
    private UserMapper userMapper;


    //@Resource
    //private UserMapper2 userMapper2;


    @Test
    void selectPage() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 指定分页对象，分页对象包含分页信息 IPage
        IPage<User> userPage = new Page<>(1,3);
        //Page<User> userPage = new Page<>(2, 3);

        // 执行查询
        userMapper.selectPage(userPage, lambdaQueryWrapper);

        // 获取分页查询的信息
        System.out.println("当前页:" + userPage.getCurrent());
        System.out.println("每页显示条数: " + userPage.getSize());
        System.out.println("总页数: " + userPage.getPages());
        System.out.println("总条数: " + userPage.getTotal());
        System.out.println("分页数据: " + userPage.getRecords());
    }



    @Test
    void selectPage2() {

        IPage<User> userPage = new Page<>(1,3);
        userMapper.selectByName(userPage,"Mary");

        // 获取分页查询的信息
        System.out.println("当前页:" + userPage.getCurrent());
        System.out.println("每页显示条数: " + userPage.getSize());
        System.out.println("总页数: " + userPage.getPages());
        System.out.println("总条数: " + userPage.getTotal());
        System.out.println("分页数据: " + userPage.getRecords());
    }

}
