package com.baizhi.Test;

import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChapterTest extends BaseTest {
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private AlbumService albumService;
    @Test
    public void test1(){
        Chapter chapter = new Chapter();
        chapter.setTitle("test1");
        chapter.setDownPath("test_xz");
        chapter.setSize("daxiao");
        chapter.setDuration("shijianchangdu");
        chapter.setAlbum_id("123");
        chapterService.addChapter(chapter);
    }
}
