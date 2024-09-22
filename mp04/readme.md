# 主键策略
AUTO


# 分页插件:
https://baomidou.com/plugins/ 官网地址

```
yaml

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mybatisplus?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false
    username: root
    password: MySQL123
  main:
    banner-mode: off  #\u5173\u95ED spring boot  \u5728\u547D\u4EE4\u884C\u5F53\u4E2D\u7684\u56FE\u6807\u663E\u793A


mybatis-plus:
  global-config:
    banner: false  # \u5173\u95ED mybatis-plus \u5728\u547D\u4EE4\u884C\u5F53\u4E2D\u7684\u56FE\u6807\u663E\u793A
    db-config:
      table-prefix: rainbowsea_ # \u8FD8\u53EF\u4EE5\u901A\u8FC7\u7EDF\u4E00\u6DFB\u52A0\u524D\u7F00\u7684\u65B9\u5F0F\uFF1A

      # \u6CE8\u610F\u8FD9\u4E2A none \u8981\u5F00\u542F\uFF0C\u6570\u636E\u8868\u7684\u81EA\u589E\u7B56\u7565\uFF0C\u624D\u6709\u6548
#      id-type: none # \u8BE5\u7C7B\u578B\u4E3A\u672A\u8BBE\u7F6E\u4E3B\u952E\u7C7B\u578B(\u6CE8\u89E3\u91CC\u7B49\u4E8E\u8DDF\u968F\u5168\u5C40,\u5168\u5C40\u91CC\u7EA6\u7B49\u4E8E INPUT),\u7B80\u5355\u672C\u8D28\uFF0C\u9ED8\u8BA4\u503C\u8FD8\u662F\u96EA\u82B1\u7B97\u6CD5\u7684

  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl  # \u5F00\u542F Log \u65E5\u5FD7\u4FE1\u606F\u6253\u5370
    map-underscore-to-camel-case: true # \u5F00\u542F\u9A7C\u5CF0\uFF0C\u4E0B\u5212\u7EBF\u6620\u5C04\u89C4\u5219
  mapper-locations:  classpath:mapper/*.xml
#logging:
#  level:
#    org:
#      springframework:
#        boot:
#          autoconfigure: error  ###可以是info或者error
```


```
java

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.rainbowsea.mapper.UserMapper">

    <select id="selectByName" resultType="com.rainbowsea.bean.User">
        select * from powershop_user where name = #{name}
    </select>

</mapper>
```

set GLOBAL time_zone = "+8:00";


    url: jdbc:mysql://localhost:3306/mybatisplus?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true
    &useSSL=false