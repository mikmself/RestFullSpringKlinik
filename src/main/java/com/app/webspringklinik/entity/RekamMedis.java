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
@Table(name = "rekam_medis")
public class RekamMedis {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_pasien")
    private Pasien id_pasien;
    @ManyToOne
    @JoinColumn(name = "id_dokter")
    private Dokter id_dokter;
    private Date tanggal_periksa;
    private String diagnosa;
    private String resep;
}
