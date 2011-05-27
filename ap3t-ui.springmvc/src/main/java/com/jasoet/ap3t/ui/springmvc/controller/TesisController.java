package com.jasoet.ap3t.ui.springmvc.controller;


import com.jasoet.ap3t.domain.Tesis;
import com.jasoet.ap3t.domain.Topik;
import com.jasoet.ap3t.domain.enums.NilaiTesisEnum;
import com.jasoet.ap3t.domain.enums.StatusTesisEnum;
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
public class TesisController {

    @Autowired
    @Qualifier("documentService")
    private DocumentService documentService;


/* -------------------------- Other Methods -------------------------- */

    @RequestMapping(value = "/tesis/new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        Tesis tesis = new Tesis();
        modelMap.addAttribute("tesis", tesis);
        modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
        modelMap.addAttribute("nilaiData", NilaiTesisEnum.values());

        modelMap.addAttribute("statusData", StatusTesisEnum.values());


        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "tesis");


        return "tesis/create";
    }

    @RequestMapping(value = "/tesis/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        Tesis data = documentService.findTesis(id);
        documentService.delete(data);
        return "redirect:/tesis";
    }

    @RequestMapping(value = "/tesis/{id}/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        Tesis tesis = documentService.findTesis(id);
        modelMap.addAttribute("tesis", tesis);
        modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
        modelMap.addAttribute("nilaiData", NilaiTesisEnum.values());
        modelMap.addAttribute("statusData", StatusTesisEnum.values());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "tesis");

        return "tesis/edit";
    }

    @RequestMapping(value = "/tesis", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {


        modelMap.addAttribute("data", documentService.findTesises());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "tesis");


        return "tesis/index";
    }

    @RequestMapping(value = "/tesis", method = RequestMethod.POST)
    public String save(@ModelAttribute("tesis") Tesis tesis, BindingResult result, ModelMap modelMap) {
        if (tesis == null) throw new IllegalArgumentException("An Object is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("tesis", tesis);
            modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
            modelMap.addAttribute("nilaiData", NilaiTesisEnum.values());

            modelMap.addAttribute("statusData", StatusTesisEnum.values());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "tesis");

            return "tesis/create";
        }


        documentService.save(tesis);

        return "redirect:/tesis/" + tesis.getId();
    }

    @RequestMapping(value = "/tesis/{id}", method = RequestMethod.GET)
    public String show(ModelMap modelMap, @PathVariable("id") Long id) {
        Tesis data = documentService.findTesis(id);
        modelMap.addAttribute("data", data);

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "tesis");


        return "tesis/show";
    }

    @RequestMapping(value = "/tesis", method = RequestMethod.PUT)
    public String update(@ModelAttribute("tesis") Tesis tesis, BindingResult result, ModelMap modelMap) {
        if (tesis == null) throw new IllegalArgumentException("A Product is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("tesis", tesis);
            modelMap.addAttribute("listTopik", documentService.findTopiksByActive(true));
            modelMap.addAttribute("nilaiData", NilaiTesisEnum.values());

            modelMap.addAttribute("statusData", StatusTesisEnum.values());
            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "tesis");

            return "tesis/edit";
        }

        documentService.save(tesis);


        return "redirect:/tesis/" + tesis.getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Topik.class, new TopikEditor(documentService));

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
