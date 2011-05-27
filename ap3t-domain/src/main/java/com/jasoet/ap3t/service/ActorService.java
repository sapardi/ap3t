package com.jasoet.ap3t.service;

import com.jasoet.ap3t.domain.Dosen;
import com.jasoet.ap3t.domain.Mahasiswa;

import java.util.List;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public interface ActorService {
    public void save(Mahasiswa mahasiswa);

    public void delete(Mahasiswa mahasiswa);

    public Mahasiswa findMahasiswa(Long id);

    public List<Mahasiswa> findMahasiswas();

    public List<Mahasiswa> findMahasiswas(int start, int max);

    public Long countMahasiswas();

    public Mahasiswa findMahasiswaByNim(String nim);


    public void save(Dosen dosen);

    public void delete(Dosen dosen);

    public Dosen findDosen(Long id);

    public List<Dosen> findDosens();

    public List<Dosen> findDosens(int start, int max);

    public Long countDosens();

    public Dosen findDosenByNip(String nip);
}
