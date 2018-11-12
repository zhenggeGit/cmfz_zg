package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/showAll")
    public @ResponseBody
    List<User> findAll() {
        List<User> all = userService.findAll();
        return all;
    }



    @RequestMapping("/motifyUser")
    public  @ResponseBody Map<String,Object> motifyUser(User user){
        System.out.println(user+"------user-------");
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            userService.motify(user);
            map.put("motifyUserSuccess",true);
        }catch (Exception e){
            map.put("motifyUserSuccess",false);
            map.put("motifyUserFail",e.getMessage());
        }
        return map;

    }
    @RequestMapping("/findOne")
    public @ResponseBody
    User findOne(String id){
        User user = userService.findOne(id);
        System.out.println(user+"-----------findOne--------");
        return user;
    }
    @RequestMapping("/removeById")
    public @ResponseBody void removeById(String id){
        userService.removeById(id);
    }

}