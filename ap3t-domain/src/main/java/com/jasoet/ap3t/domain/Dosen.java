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
@Table(name = "dosen", uniqueConstraints = {@UniqueConstraint(columnNames = {"nip"})})
public class Dosen implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dosen_id")
    private Long id;

    @Column(name = "nip", length = 18, unique = true)
    private String nip;
    @Column(name = "nama", length = 100)
    private String nama;
    private MinatEnum minat;


    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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
        result[0] = this.getNip();
        result[1] = this.getNama();
        result[2] = this.getMinat().toString();
        result[3] = Long.toString(this.id);
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dosen dosen = (Dosen) o;

        if (id != null ? !id.equals(dosen.id) : dosen.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
