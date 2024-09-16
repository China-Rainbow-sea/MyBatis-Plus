package com.rainbowsea.mapper;

import com.rainbowsea.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



@Mapper // 让其被 Spring boot 扫描到
public interface UserMapper {
    public List<User> selectAll();

}
