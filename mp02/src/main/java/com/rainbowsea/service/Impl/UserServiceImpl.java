package com.rainbowsea.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import com.rainbowsea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User>
        implements UserService  {

    //@Resource
    @Autowired  // 自动装配
    private UserMapper userMapper;


    // 对自定义方法的，重写实现
    @Override
    public List<User> selectAll() {
        return userMapper.selectList(null);
    }
}
