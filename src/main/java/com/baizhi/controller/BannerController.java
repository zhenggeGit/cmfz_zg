package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("/showAll")
    public @ResponseBody List<Banner> findAll(){
        List<Banner> all = bannerService.findAll();
        return all;
    }
    @RequestMapping("/addBanner")
    public @ResponseBody Map<String,Object> addBanner(MultipartFile file, HttpServletRequest request, Banner banner){
        System.out.println("原始文件名---------------: "+file.getOriginalFilename());
        System.out.println("----insert----------banner-------"+banner);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //获取上传路径  相对路径 files    获取绝对路径
            //String realPath = request.getRealPath("/files");
            String realPath = request.getSession().getServletContext().getRealPath("/back/banner/img_banner");
            //上传
            System.out.println("-----realPath--------------"+realPath);
            file.transferTo(new File(realPath,file.getOriginalFilename()));
            banner.setImgPath("/back/banner/img_banner/"+file.getOriginalFilename());
            bannerService.add(banner);
            System.out.println("----insert----------banner-------"+banner);
            map.put("addSuccess",true);
        }catch (Exception e){
            map.put("addFile",false);
        }
        return map;

    }
    @RequestMapping("/findOne")
    public @ResponseBody Banner findOne(String id){
        Banner banner = bannerService.findoneById(id);
        return banner;
    }
    @RequestMapping("/removeById")
    public @ResponseBody void removeById(String id){
        bannerService.removeById(id);
    }
    @RequestMapping("/motifyBanner")
    public  @ResponseBody Map<String,Object>  motifyBanner(Banner banner){
        System.out.println(banner+"------motifyBanner-------");
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            bannerService.motifyBanner(banner);
            map.put("motifySuccess",true);
        }catch (Exception e){
            map.put("motifySuccess",false);
            map.put("motifyFail",e.getMessage());
        }
        return map;

    }
    @RequestMapping("/batchDelete")
    public @ResponseBody void batchDelete(String[] ids){
        for (String s: ids){
           bannerService.removeById(s);
        }
    }

}
