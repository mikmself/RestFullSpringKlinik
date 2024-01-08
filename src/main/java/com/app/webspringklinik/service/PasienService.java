package com.app.webspringklinik.service;

import com.app.webspringklinik.entity.Pasien;
import com.app.webspringklinik.repository.PasienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasienService {
    @Autowired
    private PasienRepository repository;
    public void save(Pasien data) {
        repository.save(data);
    }
    public List<Pasien> get() {
        return repository.findAll();
    }
    public Pasien getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
