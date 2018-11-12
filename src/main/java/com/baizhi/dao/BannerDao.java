package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerDao{
     List<Banner> queryAll();
     Banner queryoneById(String id);
     void insert(Banner banner);
     void deleteById(String id);
     void update(Banner banner);

}
