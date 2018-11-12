package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumDao {
    List<Album> queryAll();
    Album queryOne(String id);
    void insertAlbum(Album album);
}
