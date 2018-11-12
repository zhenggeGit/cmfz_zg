package com.baizhi.service;



import com.baizhi.dao.AdminDao;

import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao admindao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin login(String name, String password) {
        Admin queryone = (Admin)admindao.queryone(name, password);
        return queryone;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findoneById(String id) {
        Admin adminById = (Admin)admindao.queryoneById(id);
        return adminById;
    }

    @Override
    public void motifyPWD(Admin admin) {

        admindao.updatePassword(admin);
    }
}
