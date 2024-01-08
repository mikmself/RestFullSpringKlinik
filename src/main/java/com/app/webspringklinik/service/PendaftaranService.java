package com.app.webspringklinik.service;

import com.app.webspringklinik.entity.Pendaftaran;
import com.app.webspringklinik.repository.PendaftaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PendaftaranService {
    @Autowired
    private PendaftaranRepository repository;
    public void save(Pendaftaran data) {
        repository.save(data);
    }
    public List<Pendaftaran> get() {
        return repository.findAll();
    }
    public Pendaftaran getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
