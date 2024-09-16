# 留意事项 特别说明

1. MyBatis-plus 将数据表当中的查询到的信息赋值到 对应Java bean 对象当中是，通过 反射机制当中，使用 setName->Name->name
进行赋值操作的。并不是通过，bean 对象当中的属性名执行赋值的 .



```
xml
    map-underscore-to-camel-case: true # 开启驼峰，下划线映射规则
```


```
java

@TableName("rainbowsea_user")  // 指定映射的数据表名是哪一个
```


还可以通过，统一添加前缀的方式：
```
yaml

mybatis-plus:
    db-config:
      table-prefix: rainbowsea_ # 还可以通过统一添加前缀的方式：
```

//@TableName("user")  // 指定映射的数据表名是哪一个
public class User {



3. 当数据表当中的字段与Java当中的属性名不一致的时候，可以使用：    @TableField("username") 进行注明
   public class User {

   private Long id;

   @TableField("username")
   private String name;
   private Integer age;
   private String email;

}


4. 当Java属性当中的属性名是SQL语句当中的关键字时：
   SQL: SELECT  id,username AS name,age,email,desc  FROM rainbowsea_user
使用 ``,注意不是单引号。而是另外一个相似的。.使用： @TableField("`desc`") 注解区分开来，注意是双层的，最后是一个双引号
```
java
public class User {

    private Long id;

    @TableField("username")
    private String name;
    private Integer age;
    private String email;

    @TableField("`desc`")
    private String desc;

}

```

SELECT id,username AS name,age,email,`desc` FROM rainbowsea_user



    @TableField(select = false) # 表示忽略该属性，不查询该属性 
    private Integer age;