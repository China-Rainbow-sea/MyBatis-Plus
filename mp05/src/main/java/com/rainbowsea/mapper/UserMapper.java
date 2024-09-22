package com.rainbowsea.mapper;

import com.rainbowsea.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author huo
* @description 针对表【rainbowsea_user】的数据库操作Mapper
* @createDate 2024-09-22 20:22:45
* @Entity com.rainbowsea.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

    int deleteByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    void updateNameByAge(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

}




