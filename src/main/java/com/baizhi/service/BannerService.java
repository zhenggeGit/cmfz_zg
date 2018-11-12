package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> findAll();
    Banner findoneById(String id);
    void add(Banner banner);
    void removeById(String id);
    void motifyBanner(Banner banner);
}
