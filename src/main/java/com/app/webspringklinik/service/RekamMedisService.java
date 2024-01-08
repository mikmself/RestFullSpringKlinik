package com.app.webspringklinik.service;

import com.app.webspringklinik.entity.RekamMedis;
import com.app.webspringklinik.repository.RekamMedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RekamMedisService {
    @Autowired
    private RekamMedisRepository repository;
    public void save(RekamMedis data) {
        repository.save(data);
    }
    public List<RekamMedis> get() {
        return repository.findAll();
    }
    public RekamMedis getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
