package com.rainbowsea.controller;


import com.rainbowsea.bean.User;
import com.rainbowsea.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping(value = {"/selectList"})
    public List<User> selectList() {
        return userService.selectAll();
    }
}
