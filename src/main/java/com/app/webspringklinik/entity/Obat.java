package com.app.webspringklinik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "obat")
public class Obat {
    @Id
    @GeneratedValue
    private int id;
    private String kode_obat;
    @ManyToOne
    @JoinColumn(name = "id_dokter")
    private Dokter id_dokter;
    @ManyToOne
    @JoinColumn(name = "id_pasien")
    private Pasien id_pasien;
    private int jumlah;
    private int harga;
}
