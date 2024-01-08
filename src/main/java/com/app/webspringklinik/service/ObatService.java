package com.app.webspringklinik.service;

import com.app.webspringklinik.entity.Obat;
import com.app.webspringklinik.repository.ObatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObatService {
    @Autowired
    private ObatRepository repository;
    public void save(Obat data) {
        repository.save(data);
    }
    public List<Obat> get() {
        return repository.findAll();
    }
    public Obat getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
