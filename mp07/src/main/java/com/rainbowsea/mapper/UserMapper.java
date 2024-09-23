package com.rainbowsea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowsea.bean.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
