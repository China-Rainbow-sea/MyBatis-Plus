package com.rainbowsea.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowsea.bean.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> selectAll();
}
