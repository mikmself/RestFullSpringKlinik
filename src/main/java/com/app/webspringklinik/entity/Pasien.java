package com.app.webspringklinik.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pasien")
public class Pasien {
    @Id
    @GeneratedValue
    private int id;
    private String nama_pasien;
    private String gejala;
    private String alamat;
    private String telephone;
}
