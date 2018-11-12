package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> findAll();
    Album findOne(String id);
    void addAlbum(Album album);
}
