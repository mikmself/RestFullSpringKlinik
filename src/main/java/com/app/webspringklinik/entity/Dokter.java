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
@Table(name = "dokter")
public class Dokter {
    @Id
    @GeneratedValue
    private int id;
    private String nama_dokter;
    private String spesialis;
    private String telephone;
    private int harga;
    private String status;
}
