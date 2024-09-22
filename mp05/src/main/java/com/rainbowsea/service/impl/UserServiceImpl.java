package com.rainbowsea.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rainbowsea.domain.User;
import com.rainbowsea.service.UserService;
import com.rainbowsea.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author huo
* @description 针对表【rainbowsea_user】的数据库操作Service实现
* @createDate 2024-09-22 20:22:45
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




