package com.rainbowsea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainbowsea.bean.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper  // 包路径扫描
public interface UserMapper extends BaseMapper<User> {
    IPage<User> selectByName(IPage<User> page, String name);
}
