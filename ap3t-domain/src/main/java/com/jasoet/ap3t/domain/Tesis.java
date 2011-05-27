package com.jasoet.ap3t.domain;

import com.jasoet.ap3t.domain.enums.NilaiTesisEnum;
import com.jasoet.ap3t.domain.enums.StatusTesisEnum;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
@Entity
@Table(name = "tesis")
public class Tesis implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tesis_id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
     @JoinColumn(name = "topik_id", nullable = true,unique = true)
    private Topik topik;

    @Column(name = "dokumen", length = 250)
    private String dokumen;

    @Column(name = "disetujui")
    private boolean disetujui;

    @Column(name = "nilai")
    private NilaiTesisEnum nilai;

    @Column(name = "status")
    private StatusTesisEnum status;

    @Column(name = "revisi_disetujui")
    private boolean revisiDisetujui;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "jadwal_ujian")
    private Date jadwalUjian;

    public NilaiTesisEnum getNilai() {
        return nilai;
    }

    public void setNilai(NilaiTesisEnum nilai) {
        this.nilai = nilai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Topik getTopik() {
        return topik;
    }

    public void setTopik(Topik topik) {
        this.topik = topik;
    }

    public String getDokumen() {
        return dokumen;
    }

    public void setDokumen(String dokumen) {
        this.dokumen = dokumen;
    }

    public boolean isDisetujui() {
        return disetujui;
    }

    public void setDisetujui(boolean disetujui) {
        this.disetujui = disetujui;
    }

    public StatusTesisEnum getStatus() {
        return status;
    }

    public void setStatus(StatusTesisEnum status) {
        this.status = status;
    }

    public boolean isRevisiDisetujui() {
        return revisiDisetujui;
    }

    public void setRevisiDisetujui(boolean revisiDisetujui) {
        this.revisiDisetujui = revisiDisetujui;
    }

    public Date getJadwalUjian() {
        return jadwalUjian;
    }

    public void setJadwalUjian(Date jadwalUjian) {
        this.jadwalUjian = jadwalUjian;
    }
}
