package com.baizhi.Test;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlbumTest extends BaseTest {
    @Autowired
    private AlbumService albumService;
    @Test
    public void test1(){
        List<Album> all = albumService.findAll();
        System.out.println(all);
    }
    @Test
    public void test2(){
        Album one = albumService.findOne("001");
        System.out.println(one);
    }
    @Test
    public void test3(){
        Album album = new Album();
        album.setTitle("123");
        album.setStar("123");
        album.setAuthor("123");
        album.setBrief("123");
        album.setBroadCast("321");
        album.setBrief("123");
        album.setCount("123");
        album.setCoverImg("123");
        albumService.addAlbum(album);
    }
}
