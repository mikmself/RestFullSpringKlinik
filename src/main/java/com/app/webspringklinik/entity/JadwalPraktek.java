package com.app.webspringklinik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jadwal_praktek")
public class JadwalPraktek {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_dokter")
    private Dokter id_dokter;
    private Date hari;
    private String jam;
}
