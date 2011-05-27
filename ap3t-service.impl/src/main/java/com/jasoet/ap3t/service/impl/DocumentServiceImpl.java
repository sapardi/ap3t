package com.jasoet.ap3t.service.impl;

import com.jasoet.ap3t.domain.Pratesis;
import com.jasoet.ap3t.domain.Proposal;
import com.jasoet.ap3t.domain.Tesis;
import com.jasoet.ap3t.domain.Topik;
import com.jasoet.ap3t.service.DocumentService;
import org.hibernate.SessionFactory;
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
@Service("documentService")
@Transactional
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Topik topik) {
        sessionFactory.getCurrentSession().saveOrUpdate(topik);
    }

    @Override
    public void delete(Topik topik) {
        if (topik != null) {
            sessionFactory.getCurrentSession().delete(topik);
        }

    }

    @Override
    public Topik findTopik(Long id) {
        return (Topik) sessionFactory.getCurrentSession().get(Topik.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Topik> findTopiks() {
        return sessionFactory.getCurrentSession().createQuery("from Topik o order by o.id").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Topik> findTopiks(int start, int max) {
        return sessionFactory.getCurrentSession().createQuery("from Topik o order by o.id").setFirstResult(start).setMaxResults(max).list();
    }

    @Override
    public Long countTopiks() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Topik o").uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Topik> findTopiksByActive(boolean active) {
        return sessionFactory.getCurrentSession().createQuery("SELECT o FROM Topik o WHERE o.aktif=:aktif").setParameter("aktif", active).list();
    }


    @Override
    public void save(Proposal proposal) {
        sessionFactory.getCurrentSession().saveOrUpdate(proposal);
    }

    @Override
    public void delete(Proposal proposal) {
        if (proposal != null) {
            sessionFactory.getCurrentSession().delete(proposal);
        }

    }

    @Override
    public Proposal findProposal(Long id) {
        return (Proposal) sessionFactory.getCurrentSession().get(Proposal.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Proposal> findProposals() {
        return sessionFactory.getCurrentSession().createQuery("from Proposal o order by o.id").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Proposal> findProposals(int start, int max) {
        return sessionFactory.getCurrentSession().createQuery("from Proposal o order by o.id").setFirstResult(start).setMaxResults(max).list();
    }

    @Override
    public Long countProposals() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Proposal o").uniqueResult();
    }

    @Override
    public Proposal findProposalByTopik(Long topikId) {
        return (Proposal) sessionFactory.getCurrentSession().createQuery("SELECT o FROM Proposal o WHERE o.topik.id=:topikId").setParameter("topikId", topikId).uniqueResult();
    }


    @Override
    public void save(Pratesis pratesis) {
        sessionFactory.getCurrentSession().saveOrUpdate(pratesis);
    }

    @Override
    public void delete(Pratesis pratesis) {
        if (pratesis != null) {
            sessionFactory.getCurrentSession().delete(pratesis);
        }

    }

    @Override
    public Pratesis findPratesis(Long id) {
        return (Pratesis) sessionFactory.getCurrentSession().get(Pratesis.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pratesis> findPratesises() {
        return sessionFactory.getCurrentSession().createQuery("from Pratesis o order by o.id").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pratesis> findPratesises(int start, int max) {
        return sessionFactory.getCurrentSession().createQuery("from Pratesis o order by o.id").setFirstResult(start).setMaxResults(max).list();
    }

    @Override
    public Long countPratesises() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Pratesis o").uniqueResult();
    }

    @Override
    public Pratesis findPratesisByTopik(Long topikId) {
        return (Pratesis) sessionFactory.getCurrentSession().createQuery("SELECT o FROM Pratesis o WHERE o.topik.id=:topikId").setParameter("topikId", topikId).uniqueResult();
    }

    @Override
    public void save(Tesis tesis) {
        sessionFactory.getCurrentSession().saveOrUpdate(tesis);
    }

    @Override
    public void delete(Tesis tesis) {
        if (tesis != null) {
            sessionFactory.getCurrentSession().delete(tesis);
        }

    }

    @Override
    public Tesis findTesis(Long id) {
        return (Tesis) sessionFactory.getCurrentSession().get(Tesis.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Tesis> findTesises() {
        return sessionFactory.getCurrentSession().createQuery("from Tesis o order by o.id").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Tesis> findTesises(int start, int max) {
        return sessionFactory.getCurrentSession().createQuery("from Tesis o order by o.id").setFirstResult(start).setMaxResults(max).list();
    }

    @Override
    public Long countTesises() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Tesis o").uniqueResult();
    }

    @Override
    public Tesis findTesisByTopik(Long topikId) {
        return (Tesis) sessionFactory.getCurrentSession().createQuery("SELECT o FROM Tesis o WHERE o.topik.id=:topikId").setParameter("topikId", topikId).uniqueResult();
    }
}
