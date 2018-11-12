package com.baizhi.Test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserTest extends BaseTest {
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        List<User> all = userService.findAll();
        System.out.println(all);
    }
    @Test
    public void test2(){
        userService.removeById("001");
    }
    @Test
    public void test3(){
        User user = new User();
        user.setNickName("法名");
        user.setPhoneNum(123);
        user.setUsername("up");
        user.setPassword("123");
        user.setAddress("北京");
        user.setGender("男");
        user.setSign("个签");
        user.setHeadPic("1.jpg");
        user.setStatus("1");
        userService.motify(user);
    }
    @Test
   public void test4(){
        User one = userService.findOne("002");
        System.out.println(one);
    }
}
