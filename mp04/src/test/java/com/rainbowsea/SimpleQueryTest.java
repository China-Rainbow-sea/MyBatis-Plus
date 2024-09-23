package com.rainbowsea;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.rainbowsea.bean.User;
import com.rainbowsea.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

@SpringBootTest
public class SimpleQueryTest {

    @Resource
    private UserMapper userMapper;


    @Test
    void testGroup() {
        Map<String, List<User>> map = SimpleQuery.group(new LambdaQueryWrapper<User>(), User::getName);
        System.out.println(map);
    }




    @Test
    void testMap3() {
        Map<String, String> map = SimpleQuery.map(new LambdaQueryWrapper<User>(), User::getId, User::getName);
        System.out.println(map);
    }




    @Test
    void testMap2() {
        Map<String, User> map = SimpleQuery.keyMap(new LambdaQueryWrapper<User>().eq(User::getId, 1L), User::getId);
        System.out.println(map);
    }





    @Test
    void testMap() {
        Map<String, User> map = SimpleQuery.keyMap(new LambdaQueryWrapper<User>(), User::getId);
        System.out.println(map);

    }



    // 使用lab表达式
    @Test
    void testList3() {
        List<String> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Mary"), User::getName,
                user -> Optional.of(user.getName()).map(String::toLowerCase).ifPresent(user::setName));
        System.out.println(list);

    }




    @Test
    void testList2() {
        List<String> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Mary"), User::getName,
                new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        Optional.of(user.getName()).map(String::toLowerCase).ifPresent(user::setName);
                    }
                });
        System.out.println(list);

    }


    @Test
    void testList() {
        List<String> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getName, "Mary"), User::getId);
        System.out.println(list);
    }













}
