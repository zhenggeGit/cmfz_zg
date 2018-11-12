package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

public interface AdminDao<Admin>{
    public Admin queryone(@Param("name") String name, @Param("password") String password);
    public Admin queryoneById(String id);
    public void updatePassword(Admin admin);
}
