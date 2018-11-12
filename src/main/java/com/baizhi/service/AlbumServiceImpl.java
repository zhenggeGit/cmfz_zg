package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findAll() {
        List<Album> all = albumDao.queryAll();
        return all;
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Album findOne(String id){
        Album album = albumDao.queryOne(id);
        return album;
    }
    @Override
    public void addAlbum(Album album){
        album.setId(UUID.randomUUID().toString());
        album.setPublishDate(new Date());
        albumDao.insertAlbum(album);
    }
}
