package com.rainbowsea.service.Impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import com.rainbowsea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper,User>
        implements UserService  {

}
