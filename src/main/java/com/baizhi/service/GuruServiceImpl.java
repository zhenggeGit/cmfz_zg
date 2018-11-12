package com.baizhi.service;


import com.baizhi.dao.GuruDao;

import com.baizhi.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GuruServiceImpl implements GuruService{
    @Autowired
    private GuruDao guruDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Guru> findAll(){
        List<Guru> Gurus = guruDao.queryAll();
        return Gurus;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Guru findoneById(String id){
        Guru guru = guruDao.queryoneById(id);
        return guru;
    }

    @Override
    public void add(Guru guru) {
        guru.setId(UUID.randomUUID().toString());
        guruDao.insert(guru);
    }
    @Override
    public void removeById(String id){

        guruDao.deleteById(id);
    }
    @Override
    public void motifyGuru(Guru guru){
        guruDao.update(guru);
    }

}
