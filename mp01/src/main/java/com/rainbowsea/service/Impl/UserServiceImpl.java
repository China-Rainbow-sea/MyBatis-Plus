package com.rainbowsea.service.Impl;

import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import com.rainbowsea.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
