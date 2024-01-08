package com.app.webspringklinik.repository;

import com.app.webspringklinik.entity.Pasien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasienRepository extends JpaRepository<Pasien, Integer> {
}
