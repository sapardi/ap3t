package com.jasoet.ap3t.domain;

import com.jasoet.ap3t.domain.enums.MinatEnum;

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
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
@Entity
@Table(name = "mahasiswa", uniqueConstraints = {@UniqueConstraint(columnNames = {"nim"})})
public class Mahasiswa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mahasiswa_id")
    private Long id;

    @Column(name = "nim", length = 12, unique = true)
    private String nim;
    @Column(name = "nama", length = 100)
    private String nama;
    private MinatEnum minat;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public MinatEnum getMinat() {
        return minat;
    }

    public void setMinat(MinatEnum minat) {
        this.minat = minat;
    }

    public String[] getDataInArray() {
        String[] result = new String[4];
        result[0] = this.getNim();
        result[1] = this.getNama();
        result[2] = this.getMinat().toString();
        result[3] = Long.toString(this.id);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mahasiswa mahasiswa = (Mahasiswa) o;

        if (id != null ? !id.equals(mahasiswa.id) : mahasiswa.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
