package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDao {
     List<User> queryAll();
     User queryOne(String id);
     void deleteById(String id);
     void updateUser(User user);

}
