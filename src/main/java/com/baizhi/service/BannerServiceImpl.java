package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerDao bannerDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findAll(){
        List<Banner> banners = bannerDao.queryAll();
        return banners;
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Banner findoneById(String id){
        Banner banner = bannerDao.queryoneById(id);
        return banner;
    }

    @Override
    public void add(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        banner.setDate(new Date());
        bannerDao.insert(banner);
    }
    @Override
    public void removeById(String id){
        bannerDao.deleteById(id);
    }
    @Override
    public void motifyBanner(Banner banner){
        banner.setDate(new Date());
        bannerDao.update(banner);
    }

}
