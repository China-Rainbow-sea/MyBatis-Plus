package com.rainbowsea;

import com.rainbowsea.bean.User;
import com.rainbowsea.service.Impl.UserSericeImp2;
import com.rainbowsea.service.Impl.UserServiceImpl;
import com.rainbowsea.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Mp06ApplicationTests {

    @Test
    void contextLoads() {
    }


    @Resource
    private UserServiceImpl userService;

    @Resource
    private UserSericeImp2 userService2;

    @Test
    public void select1() {
        User user = userService.getById(1L);
        System.out.println(user);
    }

    @Test
    public void select2() {
        User user = userService2.getById(1L);
        System.out.println(user);

    }

}
