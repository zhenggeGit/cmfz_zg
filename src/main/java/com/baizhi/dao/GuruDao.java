package com.baizhi.dao;


import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruDao {
     List<Guru> queryAll();
     Guru queryoneById(String id);
     void insert(Guru guru);
     void deleteById(String id);
     void update(Guru guruuru);

}
