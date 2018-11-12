package com.baizhi.controller;
import com.baizhi.entity.Guru;


import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    @RequestMapping("/showAll")
    public
    @ResponseBody List<Guru> findAll(){
       List<Guru> all = guruService.findAll();
        return all;
    }
    @RequestMapping("/addGuru")
    public @ResponseBody Map<String,Object> addGuru(MultipartFile Gurufile, HttpServletRequest request, Guru guru){
        System.out.println("原始文件名---------------: "+Gurufile.getOriginalFilename());
        System.out.println("----insert----------guru-------"+guru);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //获取上传路径  相对路径 files    获取绝对路径
            //String realPath = request.getRealPath("/files");
            String realPath = request.getSession().getServletContext().getRealPath("/back/guru/img_guru");
            //上传
            System.out.println("-----realPath--------------"+realPath);
            Gurufile.transferTo(new File(realPath,Gurufile.getOriginalFilename()));
            guru.setHeadPic("/back/guru/img_guru/"+Gurufile.getOriginalFilename());

            guruService.add(guru);
            System.out.println("----insert----------guru-------"+guru);
            map.put("addGuruSuccess",true);
        }catch (Exception e){
            map.put("addGuruFail",e.getMessage());
        }
        return map;

    }
    @RequestMapping("/findOne")
    public @ResponseBody Guru findOne(String id){
        Guru guru = guruService.findoneById(id);
        System.out.println(guru+"-----------findOne--------");
        return guru;
    }
    @RequestMapping("/removeById")
    public @ResponseBody void removeById(String id){

        guruService.removeById(id);
    }

    @RequestMapping("/motifyGuru")
    public  @ResponseBody Map<String,Object>  motifyGuru(Guru guru){
        System.out.println(guru+"------motifyGuru-------");
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            guruService.motifyGuru(guru);
            map.put("motifyGuruSuccess",true);
        }catch (Exception e){
            map.put("motifyGuruSuccess",false);
            map.put("motifyGuruFail",e.getMessage());
        }
        return map;

    }
    @RequestMapping("/batchDelete")
    public @ResponseBody void batchDelete(String[] ids){
        for (String s: ids){
           guruService.removeById(s);
        }
    }

}
