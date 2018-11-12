package com.baizhi.Test;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuTest extends BaseTest {
    @Autowired
    private MenuService menuService;
    @Test
    public void test1(){
        List<Menu> all = menuService.findAll();
        for (Menu m : all){
            System.out.println(m);
        }
    }

}
