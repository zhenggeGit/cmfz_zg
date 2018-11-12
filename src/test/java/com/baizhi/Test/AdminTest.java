package com.baizhi.Test;


import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminTest extends BaseTest {
    @Autowired
    private AdminService adminService;
    @Test
    public void test1(){
        Admin login = adminService.login("002", "123");
        System.out.println(login);
    }
    @Test
    public void test2(){
        Admin admin =  new Admin();
        admin.setId("2");
        admin.setPassword("123");
       adminService.motifyPWD(admin);

    }

}
