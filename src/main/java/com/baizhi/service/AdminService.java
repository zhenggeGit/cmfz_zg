package com.baizhi.service;


import com.baizhi.entity.Admin;

public interface AdminService {
    Admin login(String name, String password);
    Admin findoneById(String id);
    void motifyPWD(Admin admin);
}
