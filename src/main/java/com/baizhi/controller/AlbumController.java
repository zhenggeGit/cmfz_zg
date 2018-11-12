package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/findAll")
    public @ResponseBody List<Album> findAll(){
        List<Album> all = albumService.findAll();
        return all;
    }
    @RequestMapping("/findOne")
    public @ResponseBody Album findOne(String id){
        Album one = albumService.findOne(id);
        return one;
    }
    @RequestMapping("/addAlbum")
    public @ResponseBody Map<String,Object> addAlbum(MultipartFile file, HttpServletRequest request,  Album album){
        System.out.println("原始文件名---------------: "+file.getOriginalFilename());

        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //获取上传路径  相对路径 files    获取绝对路径
            //String realPath = request.getRealPath("/files");
            String realPath = request.getSession().getServletContext().getRealPath("/back/album/img_album");
            //上传
            System.out.println("-----realPath--------------"+realPath);
            file.transferTo(new File(realPath,file.getOriginalFilename()));

            album.setCoverImg("/back/album/img_album/"+file.getOriginalFilename());
            albumService.addAlbum(album);
            System.out.println("----insert----------album-------"+album);
            System.out.println("----insert----------album-------"+album);
            map.put("addSuccess",true);
        }catch (Exception e){
            map.put("addFile",false);
        }
        return map;

    }
    @RequestMapping("/addChapter")
    public @ResponseBody Map<String,Object> addChapter(MultipartFile chapFile,HttpServletRequest request,  Chapter chapter){
        System.out.println("原始文件名---------------: "+chapFile.getOriginalFilename());
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //获取上传路径  相对路径 files    获取绝对路径
            //String realPath = request.getRealPath("/files");

            String realPath = request.getSession().getServletContext().getRealPath("/back/album/a_chapter");
            //上传
            System.out.println("-----realPath--------------"+realPath);
            chapFile.transferTo(new File(realPath,chapFile.getOriginalFilename()));
            chapter.setDownPath("/back/album/a_chapter/"+chapFile.getOriginalFilename());
            System.out.println("----insert----------chapter-------"+chapter);
            chapterService.addChapter(chapter);
            System.out.println("----after----------chapter-------"+chapter);
            map.put("addCSuccess",true);
        }catch (Exception e){
            map.put("addCFile",false);
        }
        return map;

    }
    @RequestMapping("/downLoad")
    public @ResponseBody Map<String,Object> downLoad(String openStyle, HttpServletRequest request, HttpServletResponse response, String downPath) {
        Map<String, Object> map = new HashMap<String,Object>();
        try {
            //1.根据接收的文件名去服务中指定目录读取文件
            String realPath = request.getSession().getServletContext().getRealPath("");
            //2.以文件输入流读取文件
            FileInputStream is = new FileInputStream(new File(realPath,downPath));
            //2.1 设置响应头
            response.setHeader("content-disposition", openStyle+";fileName="+URLEncoder.encode(downPath, "UTF-8"));
            //3.获取响应输出流
            ServletOutputStream os = response.getOutputStream();
            //4.使用IOUtils工具类
            IOUtils.copy(is, os);
            //5.关流
            IOUtils.closeQuietly(is);//安静关流
            IOUtils.closeQuietly(os);
            map.put("success","下载成功");
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("message",e.getMessage());
            map.put("error","下载失败");
        }
        return map;
    }


}
