package com.rainbowsea.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.rainbowsea.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(autoResultMap = true)//查询时将json字符串封装为Map集合
public class User extends Model<User> {

    @TableId(type = IdType.ASSIGN_UUID)  // 全局唯一标识符，定义为一个字符串主键,注意是字符串，所以数据表的主键要为字符串类型才行
    // 对应的 Java bean 对象当中的属性值，也要为 字符串类型
    private String id;
    private String name;
    private Integer age;
    private String email;







    @TableLogic(value = "1", delval = "0")  // 标注删除状态
    private Integer status;

    private GenderEnum gender;

    private Integer test;


    @TableField(typeHandler = FastjsonTypeHandler.class)//指定字段类型处理器
    private Map<String, String> contact;  // 联系方式


    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    private Integer version;

}







/*
默认：是启用雪花算法的，就算你在数据库当中开启了，自增也是启用雪花算法。
如果你数据库不开启，主键自增的话，是无法启用：这里的主键策略的。
 */

/*


package com.rainbowsea.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.rainbowsea.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(autoResultMap = true)//查询时将json字符串封装为Map集合
public class User extends Model<User> {

    //@TableId(type = IdType.AUTO)   // 主键自增策略
    //@TableId(type = IdType.INPUT)  // 该策略表示，必须由我们手动的插入id,否则无法添加数据，前提是：需要去掉数据表的自增策略
    //@TableId(type = IdType.ASSIGN_ID)  // 雪花算法,就算数据表，没有设置自增策略，也可以成功
    //@TableId(type = IdType.NONE)  // 默认设置（默认就是雪花算法），数据表没有设置自增策略，也可以成功
    //@TableId(type = IdType.ASSIGN_UUID)  // 全局唯一标识符，定义为一个字符串主键,注意是字符串，所以数据表的主键要为字符串类型才行
    // 对应的 Java bean 对象当中的属性值，也要为 字符串类型
    //private String id;
    ////private Long id;
    //private String name;
    //private Integer age;
    //private String email;






    @TableId
    private String id;
    //private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableLogic(value = "1",delval = "0")  // 标注删除状态
    private Integer status;

    private GenderEnum gender;

    private Integer test;



    @TableField(typeHandler = FastjsonTypeHandler.class)//指定字段类型处理器
    private Map<String,String> contact;  // 联系方式



    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    private Integer version;

}


/*
默认：是启用雪花算法的，就算你在数据库当中开启了，自增也是启用雪花算法。
如果你数据库不开启，主键自增的话，是无法启用：这里的主键策略的。
 */



