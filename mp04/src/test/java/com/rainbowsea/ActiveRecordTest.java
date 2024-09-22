package com.rainbowsea;


import com.rainbowsea.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class ActiveRecordTest {

    //public class User extends Model<User>, 需要继承 extends Model<User>
    // 添加操作
    @Test
    void activeRecordAdd() {
        User user = new User();
        user.setName("zhang");
        user.setAge(28);
        user.setEmail("zhang@rainbowsea.com");
        user.insert();
    }


    // 删除操作
    @Test
    void activeRecordDelete() {
        User user = new User();
        user.setId("1837781440184680449");
        user.deleteById();
    }

    // 修改操作
    @Test
    void activeRecordUpdate() {
        User user = new User();
        user.setId("3");
        user.setAge(1);
        user.updateById();
    }

    // 查询操作
    @Test
    void activeRecordSelect() {
        User user = new User();
        user.setId("7");
        User result = user.selectById();
        System.out.println(result);

    }

}
