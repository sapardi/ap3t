package com.jasoet.ap3t.service;

import com.jasoet.ap3t.domain.Pratesis;
import com.jasoet.ap3t.domain.Proposal;
import com.jasoet.ap3t.domain.Tesis;
import com.jasoet.ap3t.domain.Topik;

import java.util.List;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */

public interface DocumentService {


    public void save(Topik topik);

    public void delete(Topik topik);

    public Topik findTopik(Long id);

    public List<Topik> findTopiks();

    public List<Topik> findTopiks(int start, int max);

    public Long countTopiks();

    public List<Topik> findTopiksByActive(boolean active);


    public void save(Proposal proposal);

    public void delete(Proposal proposal);

    public Proposal findProposal(Long id);

    public List<Proposal> findProposals();

    public List<Proposal> findProposals(int start, int max);

    public Long countProposals();

    public Proposal findProposalByTopik(Long topikId);


    public void save(Pratesis pratesis);

    public void delete(Pratesis pratesis);

    public Pratesis findPratesis(Long id);

    public List<Pratesis> findPratesises();

    public List<Pratesis> findPratesises(int start, int max);

    public Long countPratesises();

    public Pratesis findPratesisByTopik(Long topikId);


    public void save(Tesis tesis);

    public void delete(Tesis tesis);

    public Tesis findTesis(Long id);

    public List<Tesis> findTesises();

    public List<Tesis> findTesises(int start, int max);

    public Long countTesises();

    public Tesis findTesisByTopik(Long topikId);

}
