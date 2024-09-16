package com.rainbowsea.controller;


import com.rainbowsea.bean.User;
import com.rainbowsea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
//
//@Controller
//@ResponseBody

@RestController
public class UserController {


    //@Autowired
    @Resource
    private UserService userService;


    @GetMapping("/selectAll")
    public List<User> selectAll() {
        List<User> users = userService.selectAll();

        return users;
    }

}
