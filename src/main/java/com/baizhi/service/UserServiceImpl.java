package com.baizhi.service;


import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAll(){
        List<User> users = userDao.queryAll();
        return users;
    }

    @Override
    public void removeById(String id) {
        userDao.deleteById(id);
    }
    @Override
    public void motify(User user){
        user.setDate(new Date());
        userDao.updateUser(user);
    }
    @Override
    public User findOne(String id){
        User user = userDao.queryOne(id);
        return user;
    }
}
