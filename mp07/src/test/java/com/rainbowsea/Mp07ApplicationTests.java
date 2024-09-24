package com.rainbowsea;

import com.rainbowsea.bean.User;
import com.rainbowsea.service.Impl.UserServiceImpl;
import com.rainbowsea.service.Impl.UserServiceImpl2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Mp07ApplicationTests {

    @Resource
    private UserServiceImpl2 userService2;

    @Test
    public void select2() {
        User user = userService2.getById(1L);
        System.out.println(user);

    }




    @Resource
    private UserServiceImpl userService;

    @Test
    public void select1() {
        User user = userService.getById(1L);
        System.out.println(user);
    }





}
