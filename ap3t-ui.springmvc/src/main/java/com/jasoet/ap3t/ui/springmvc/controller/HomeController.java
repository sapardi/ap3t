package com.jasoet.ap3t.ui.springmvc.controller;

import com.jasoet.ap3t.domain.Proposal;
import com.jasoet.ap3t.domain.Topik;
import com.jasoet.ap3t.domain.enums.NilaiProposalEnum;
import com.jasoet.ap3t.service.ActorService;
import com.jasoet.ap3t.service.DocumentService;
import com.jasoet.ap3t.service.SpringSecurityService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
@Controller
public class HomeController {

    @Autowired
    @Qualifier("springSecurityService")
    private SpringSecurityService securityService;

    @Autowired
    @Qualifier("actorService")
    private ActorService actorService;

    @Autowired
    @Qualifier("documentService")
    private DocumentService documentService;


    @RequestMapping(value = "/homes", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {

        List<Topik> listTopik;


        Proposal proposal = new Proposal();
        proposal.setJadwalUjian(new Date());
        proposal.setDokumen("disana disini");
        proposal.setNilai(NilaiProposalEnum.DITERIMA);
        proposal.setRevisiDisetujui(true);
        proposal.setDisetujui(true);

        documentService.save(proposal);

        listTopik = documentService.findTopiks();
        ObjectMapper objectMapper = new ObjectMapper();

        StringWriter stringWriter = new StringWriter();
        try {
            objectMapper.writeValue(stringWriter, listTopik);
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute("data", stringWriter.toString());
        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "topik");


        return "home";
    }

}
