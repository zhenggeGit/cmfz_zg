package com.baizhi.controller;

import com.baizhi.entity.Admin;

import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class
AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/login")
   public  String  login(String name,String password,HttpSession session,String code){
        System.out.println("登录:"+name+","+password+",---code---"+code);
        String yzm = (String) session.getAttribute("validationCode");
        System.out.println("----yzm---------"+yzm);
        if(yzm.equals(code)){
           Admin login = adminService.login(name, password);
           if(login!=null){
               session.setAttribute("login",login);
               return "redirect:/back/main/main.jsp";
           }
       }
        return "redirect:/back/login.jsp";
    }
    @RequestMapping("/updatePWD")
    public @ResponseBody Map<String,Object> motifyPWD(Admin admin, String pwd, String newpwd1, String newpwd2){
        Map<String,Object> map = new HashMap<String,Object>();
        System.out.println("--"+admin+"----admin-----pwd---"+pwd);
        System.out.println(newpwd1+"---pwd----npwd---"+newpwd2);
        Admin byId = adminService.findoneById(admin.getId());
        System.out.println(byId+"---");
        if(pwd.equals(byId.getPassword())){

            if(newpwd1.equals(newpwd2)){
                admin.setPassword(newpwd1);
                adminService.motifyPWD(admin);
                map.put("updateSuccess",true);
            }else {
                map.put("updateSuccess", false);
            }
        }
        return map;
    }
    @RequestMapping("/exit")
    public String execute(HttpSession session){
       session.setAttribute("login",null);
        return "redirect:/back/login.jsp";
    }

}