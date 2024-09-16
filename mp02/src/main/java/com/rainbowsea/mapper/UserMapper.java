package com.rainbowsea.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowsea.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper // 被Spring Boot 扫描到
public interface UserMapper extends BaseMapper<User> {

    // 自定义方法
  User selectByName(String name);

}
