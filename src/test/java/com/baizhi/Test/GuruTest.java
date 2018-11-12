package com.baizhi.Test;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class GuruTest extends BaseTest{
    @Autowired
    private GuruService guruService;
    @Test
    public void test1(){
        List<Guru> all = guruService.findAll();
        System.out.println(all);
    }

}
