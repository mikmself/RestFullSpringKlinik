package com.app.webspringklinik.service;

import com.app.webspringklinik.entity.Dokter;
import com.app.webspringklinik.repository.DokterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DokterService {
    @Autowired
    private DokterRepository repository;

    public void save(Dokter data) {
        repository.save(data);
    }
    public List<Dokter> get() {
        return repository.findAll();
    }
    public Dokter getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
