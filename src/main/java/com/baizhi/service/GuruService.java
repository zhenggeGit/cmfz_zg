package com.baizhi.service;


import com.baizhi.entity.Guru;

import java.util.List;

public interface GuruService {
    List<Guru> findAll();
    Guru findoneById(String id);
    void add(Guru guru);
    void removeById(String id);
    void motifyGuru(Guru guru);
}
