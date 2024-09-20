package com.rainbowsea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbowsea.bean.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper  // 包扫描路径
public interface UserMapper extends BaseMapper<User> {


}
