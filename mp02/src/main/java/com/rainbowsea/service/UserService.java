package com.rainbowsea.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rainbowsea.bean.User;

import java.util.List;

public interface UserService extends IService<User> {

    // 当 IService 当中提供的方法，不能满足我们的业务需要的时候，
    // 我们可以自定义方法。
    // 自定义的方法
    List<User> selectAll();
}
