package com.baizhi.Test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BannerTest extends BaseTest{
    @Autowired
    private BannerService bannerService;
    @Test
    public void test1(){
        List<Banner> all = bannerService.findAll();
        System.out.println(all);
    }
    @Test
    public void test2(){
        Banner banner = new Banner();
        banner.setDate(new Date());
        banner.setId("string");
        banner.setImgPath("asd.jsp");
        banner.setTitle("123213");
        banner.setStatus("asd");
        bannerService.add(banner);
    }
    @Test
    public void test3(){
        Banner banner = new Banner();

        banner.setId("d0e80ab4-93a0-4127-885d-da53d424af17");
        banner.setDate(new Date());
        banner.setImgPath("12434");
        banner.setTitle("14342");
        banner.setStatus("14342");
        bannerService.motifyBanner(banner);
    }
}
