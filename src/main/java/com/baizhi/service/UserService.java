package com.baizhi.service;


import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void removeById(String id);
    void motify(User user);
    User findOne(String id);
}
