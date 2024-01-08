package com.app.webspringklinik.repository;

import com.app.webspringklinik.entity.Dokter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DokterRepository extends JpaRepository<Dokter, Integer> {
}
