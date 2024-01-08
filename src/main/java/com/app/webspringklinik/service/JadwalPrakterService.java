package com.app.webspringklinik.service;

import com.app.webspringklinik.entity.JadwalPraktek;
import com.app.webspringklinik.repository.JadwalPraktekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JadwalPrakterService {
    @Autowired
    private JadwalPraktekRepository repository;
    public void save(JadwalPraktek data) {
        repository.save(data);
    }
    public List<JadwalPraktek> get() {
        return repository.findAll();
    }
    public JadwalPraktek getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
