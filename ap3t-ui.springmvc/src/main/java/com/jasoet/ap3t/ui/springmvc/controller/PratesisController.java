package com.jasoet.ap3t.ui.springmvc.controller;


import com.jasoet.ap3t.domain.Pratesis;
import com.jasoet.ap3t.domain.Topik;
import com.jasoet.ap3t.domain.enums.NilaiPratesisEnum;
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
public class PratesisController {

    @Autowired
    @Qualifier("documentService")
    private DocumentService documentService;


/* -------------------------- Other Methods -------------------------- */

    @RequestMapping(value = "/pratesis/new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        Pratesis pratesis = new Pratesis();
        modelMap.addAttribute("pratesis", pratesis);
        modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
        modelMap.addAttribute("nilaiData", NilaiPratesisEnum.values());


        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "pratesis");


        return "pratesis/create";
    }

    @RequestMapping(value = "/pratesis/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        Pratesis data = documentService.findPratesis(id);
        documentService.delete(data);
        return "redirect:/pratesis";
    }

    @RequestMapping(value = "/pratesis/{id}/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        Pratesis pratesis = documentService.findPratesis(id);
        modelMap.addAttribute("pratesis", pratesis);
        modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
        modelMap.addAttribute("nilaiData", NilaiPratesisEnum.values());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "pratesis");

        return "pratesis/edit";
    }

    @RequestMapping(value = "/pratesis", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {


        modelMap.addAttribute("data", documentService.findPratesises());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "pratesis");


        return "pratesis/index";
    }

    @RequestMapping(value = "/pratesis", method = RequestMethod.POST)
    public String save(@ModelAttribute("pratesis") Pratesis pratesis, BindingResult result, ModelMap modelMap) {
        if (pratesis == null) throw new IllegalArgumentException("An Object is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("pratesis", pratesis);
            modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
            modelMap.addAttribute("nilaiData", NilaiPratesisEnum.values());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "pratesis");

            return "pratesis/create";
        }


        documentService.save(pratesis);

        return "redirect:/pratesis/" + pratesis.getId();
    }

    @RequestMapping(value = "/pratesis/{id}", method = RequestMethod.GET)
    public String show(ModelMap modelMap, @PathVariable("id") Long id) {
        Pratesis data = documentService.findPratesis(id);
        modelMap.addAttribute("data", data);

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "pratesis");


        return "pratesis/show";
    }

    @RequestMapping(value = "/pratesis", method = RequestMethod.PUT)
    public String update(@ModelAttribute("pratesis") Pratesis pratesis, BindingResult result, ModelMap modelMap) {
        if (pratesis == null) throw new IllegalArgumentException("A Product is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("pratesis", pratesis);
            modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
            modelMap.addAttribute("nilaiData", NilaiPratesisEnum.values());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "pratesis");

            return "pratesis/edit";
        }

        documentService.save(pratesis);


        return "redirect:/pratesis/" + pratesis.getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Topik.class, new TopikEditor(documentService));

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
