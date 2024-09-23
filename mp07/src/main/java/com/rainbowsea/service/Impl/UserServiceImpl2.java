package com.rainbowsea.service.Impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import com.rainbowsea.service.UserService;
import org.springframework.stereotype.Service;


@Service
@DS("slave_1")
public class UserServiceImpl2 extends ServiceImpl<UserMapper, User>
    implements UserService {
}
