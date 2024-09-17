package com.rainbowsea.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

//@TableName(value = "rainbowsea_user")  // 指明该实体类映射的是那张数据表
//@TableName(value = "user")
public class User {

    private Long id;
    @TableField(value = "username")
    private String name;

    @TableField(select = false)  // 查询时，不对age 字段进行查询
    private Integer age;
    private String email;

    @TableField(value = "`desc`") // 注意：有两层，但最里面的哪个不是引号
    private String desc;


    @TableField(exist = false)  // 表示，不让该 online 属性，作为 SQL语句当中的查询字段
    private Integer online;
}
