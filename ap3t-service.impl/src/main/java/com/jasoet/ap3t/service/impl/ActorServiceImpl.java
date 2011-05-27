package com.jasoet.ap3t.service.impl;

import com.jasoet.ap3t.domain.Dosen;
import com.jasoet.ap3t.domain.Mahasiswa;
import com.jasoet.ap3t.service.ActorService;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
@Service("actorService")
@Transactional
public class ActorServiceImpl implements ActorService {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Mahasiswa mahasiswa) {
        sessionFactory.getCurrentSession().saveOrUpdate(mahasiswa);
    }

    @Override
    public void delete(Mahasiswa mahasiswa) {
        if (mahasiswa != null) {
            sessionFactory.getCurrentSession().delete(mahasiswa);
        }

    }

    @Override
    public Mahasiswa findMahasiswa(Long id) {
        return (Mahasiswa) sessionFactory.getCurrentSession().get(Mahasiswa.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Mahasiswa> findMahasiswas() {
        return sessionFactory.getCurrentSession().createQuery("from Mahasiswa o order by o.id").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Mahasiswa> findMahasiswas(int start, int max) {
        return sessionFactory.getCurrentSession().createQuery("from Mahasiswa o order by o.id").setFirstResult(start).setMaxResults(max).list();
    }

    @Override
    public Long countMahasiswas() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Mahasiswa o").uniqueResult();
    }

    @Override
    public Mahasiswa findMahasiswaByNim(String nim) {
        return (Mahasiswa) sessionFactory.getCurrentSession().createQuery("from Mahasiswa o WHERE o.nim=:nim ORDER BY o.nim").setParameter("nim", nim).uniqueResult();
    }


    @Override
    public void save(Dosen dosen) {
        sessionFactory.getCurrentSession().saveOrUpdate(dosen);
    }

    @Override
    public void delete(Dosen dosen) {
        if (dosen != null) {
            sessionFactory.getCurrentSession().delete(dosen);
        }

    }

    @Override
    public Dosen findDosen(Long id) {
        return (Dosen) sessionFactory.getCurrentSession().get(Dosen.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Dosen> findDosens() {
        return sessionFactory.getCurrentSession().createQuery("from Dosen o order by o.id").list();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Dosen> findDosens(int start, int max) {
        return sessionFactory.getCurrentSession().createQuery("from Dosen o order by o.id").setFirstResult(start).setMaxResults(max).list();
    }

    @Override
    public Long countDosens() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Dosen o").uniqueResult();
    }

    @Override
    public Dosen findDosenByNip(String nip) {
        return (Dosen) sessionFactory.getCurrentSession().createQuery("from Dosen o WHERE o.nip=:nip ORDER BY o.nip").setParameter("nip", nip).uniqueResult();
    }


}
