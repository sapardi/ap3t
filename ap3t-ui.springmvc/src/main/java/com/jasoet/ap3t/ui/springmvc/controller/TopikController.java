package com.jasoet.ap3t.ui.springmvc.controller;


import com.jasoet.ap3t.domain.Dosen;
import com.jasoet.ap3t.domain.Mahasiswa;
import com.jasoet.ap3t.domain.Topik;
import com.jasoet.ap3t.service.ActorService;
import com.jasoet.ap3t.service.DocumentService;
import com.jasoet.ap3t.ui.springmvc.util.DosenEditor;
import com.jasoet.ap3t.ui.springmvc.util.MahasiswaEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopikController {

    @Autowired
    @Qualifier("documentService")
    private DocumentService documentService;

    @Autowired
    @Qualifier("actorService")
    private ActorService actorService;


/* -------------------------- Other Methods -------------------------- */

    @RequestMapping(value = "/topik/new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        Topik topik = new Topik();
        modelMap.addAttribute("topik", topik);
        modelMap.addAttribute("listMahasiswa", actorService.findMahasiswas());
        modelMap.addAttribute("listDosen", actorService.findDosens());


        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "topik");


        return "topik/create";
    }

    @RequestMapping(value = "/topik/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        Topik data = documentService.findTopik(id);
        documentService.delete(data);
        return "redirect:/topik";
    }

    @RequestMapping(value = "/topik/{id}/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        Topik topik = documentService.findTopik(id);
        modelMap.addAttribute("topik", topik);
        modelMap.addAttribute("listMahasiswa", actorService.findMahasiswas());
        modelMap.addAttribute("listDosen", actorService.findDosens());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "topik");

        return "topik/edit";
    }

    @RequestMapping(value = "/topik", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {


        modelMap.addAttribute("data", documentService.findTopiks());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "topik");


        return "topik/index";
    }

    @RequestMapping(value = "/topik", method = RequestMethod.POST)
    public String save(@ModelAttribute("topik") Topik topik, BindingResult result, ModelMap modelMap) {
        if (topik == null) throw new IllegalArgumentException("An Object is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("topik", topik);
            modelMap.addAttribute("listMahasiswa", actorService.findMahasiswas());
            modelMap.addAttribute("listDosen", actorService.findDosens());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "topik");

            return "topik/create";
        }


        documentService.save(topik);

        return "redirect:/topik/" + topik.getId();
    }

    @RequestMapping(value = "/topik/{id}", method = RequestMethod.GET)
    public String show(ModelMap modelMap, @PathVariable("id") Long id) {
        Topik data = documentService.findTopik(id);
        modelMap.addAttribute("data", data);

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "topik");


        return "topik/show";
    }

    @RequestMapping(value = "/topik", method = RequestMethod.PUT)
    public String update(@ModelAttribute("topik") Topik topik, BindingResult result, ModelMap modelMap) {
        if (topik == null) throw new IllegalArgumentException("A Product is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("topik", topik);
            modelMap.addAttribute("listMahasiswa", actorService.findMahasiswas());
            modelMap.addAttribute("listDosen", actorService.findDosens());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "topik");

            return "topik/edit";
        }

        documentService.save(topik);


        return "redirect:/topik/" + topik.getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Mahasiswa.class, new MahasiswaEditor(actorService));
        binder.registerCustomEditor(Dosen.class, new DosenEditor(actorService));
    }

}
