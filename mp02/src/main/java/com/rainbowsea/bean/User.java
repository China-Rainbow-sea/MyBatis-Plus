package com.rainbowsea.bean;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("rainbowsea_user")  // 指定映射的数据表名是哪一个
//@TableName("user")  // 指定映射的数据表名是哪一个
public class User {

    private Long id;

    @TableField("username")  // 表示使用别名的方式了 as 查询时（数据表与Java bean 对象当中的属性不一致时使用）
    private String name;

    @TableField(select = false) // 表示查询时，不查该属性名/该字段
    private Integer age;
    private String email;

    @TableField("`desc`")   // 表示区别别名，关键字
    private String desc;


    @TableField(exist = false)  // Unknown column 'online' in 'field list' 表示该属性不存在，于数据表中，不要查询，赋值
    private Integer online;

}
