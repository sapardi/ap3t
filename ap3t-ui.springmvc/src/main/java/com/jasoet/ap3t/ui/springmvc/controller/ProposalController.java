package com.jasoet.ap3t.ui.springmvc.controller;


import com.jasoet.ap3t.domain.Proposal;
import com.jasoet.ap3t.domain.Topik;
import com.jasoet.ap3t.domain.enums.NilaiProposalEnum;
import com.jasoet.ap3t.service.DocumentService;
import com.jasoet.ap3t.ui.springmvc.util.TopikEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ProposalController {

    @Autowired
    @Qualifier("documentService")
    private DocumentService documentService;


/* -------------------------- Other Methods -------------------------- */

    @RequestMapping(value = "/proposal/new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        Proposal proposal = new Proposal();
        modelMap.addAttribute("proposal", proposal);
        modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
        modelMap.addAttribute("nilaiData", NilaiProposalEnum.values());


        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "proposal");


        return "proposal/create";
    }

    @RequestMapping(value = "/proposal/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        Proposal data = documentService.findProposal(id);
        documentService.delete(data);
        return "redirect:/proposal";
    }

    @RequestMapping(value = "/proposal/{id}/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        Proposal proposal = documentService.findProposal(id);
        modelMap.addAttribute("proposal", proposal);
        modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
        modelMap.addAttribute("nilaiData", NilaiProposalEnum.values());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "proposal");

        return "proposal/edit";
    }

    @RequestMapping(value = "/proposal", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {


        modelMap.addAttribute("data", documentService.findProposals());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "proposal");


        return "proposal/index";
    }

    @RequestMapping(value = "/proposal", method = RequestMethod.POST)
    public String save(@ModelAttribute("proposal") Proposal proposal, BindingResult result, ModelMap modelMap) {
        if (proposal == null) throw new IllegalArgumentException("An Object is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("proposal", proposal);
            modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
            modelMap.addAttribute("nilaiData", NilaiProposalEnum.values());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "proposal");

            return "proposal/create";
        }


        documentService.save(proposal);

        return "redirect:/proposal/" + proposal.getId();
    }

    @RequestMapping(value = "/proposal/{id}", method = RequestMethod.GET)
    public String show(ModelMap modelMap, @PathVariable("id") Long id) {
        Proposal data = documentService.findProposal(id);
        modelMap.addAttribute("data", data);

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "proposal");


        return "proposal/show";
    }

    @RequestMapping(value = "/proposal", method = RequestMethod.PUT)
    public String update(@ModelAttribute("proposal") Proposal proposal, BindingResult result, ModelMap modelMap) {
        if (proposal == null) throw new IllegalArgumentException("A Product is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("proposal", proposal);
            modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
            modelMap.addAttribute("nilaiData", NilaiProposalEnum.values());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "proposal");

            return "proposal/edit";
        }

        documentService.save(proposal);


        return "redirect:/proposal/" + proposal.getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Topik.class, new TopikEditor(documentService));

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
