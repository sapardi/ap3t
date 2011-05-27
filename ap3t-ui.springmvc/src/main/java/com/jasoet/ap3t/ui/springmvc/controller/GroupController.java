package com.jasoet.ap3t.ui.springmvc.controller;


import com.jasoet.ap3t.domain.Group;
import com.jasoet.ap3t.service.SpringSecurityService;
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
public class GroupController {

    @Autowired
    @Qualifier("springSecurityService")
    private SpringSecurityService securityService;

/* -------------------------- Other Methods -------------------------- */

    @RequestMapping(value = "/group/new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        Group group = new Group();
        modelMap.addAttribute("group", group);
        modelMap.addAttribute("roles", securityService.findRoles());


        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "group");


        return "group/create";
    }

    @RequestMapping(value = "/group/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        Group data = this.securityService.findGroup(id);
        this.securityService.delete(data);
        return "redirect:/group";
    }

    @RequestMapping(value = "/group/{id}/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        Group group = this.securityService.findGroup(id);
        modelMap.addAttribute("group", group);
        modelMap.addAttribute("roles", securityService.findRoles());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "group");

        return "group/edit";
    }

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {


        modelMap.addAttribute("data", this.securityService.findGroups());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "group");


        return "group/index";
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public String save(@ModelAttribute("group") Group group, BindingResult result, ModelMap modelMap) {
        if (group == null) throw new IllegalArgumentException("An Object is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("group", group);
            modelMap.addAttribute("roles", securityService.findRoles());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "group");

            return "group/create";
        }


        this.securityService.save(group);

        return "redirect:/group/" + group.getId();
    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public String show(ModelMap modelMap, @PathVariable("id") Long id) {
        Group data = this.securityService.findGroup(id);
        modelMap.addAttribute("data", data);

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "group");


        return "group/show";
    }

    @RequestMapping(value = "/group", method = RequestMethod.PUT)
    public String update(@ModelAttribute("group") Group group, BindingResult result, ModelMap modelMap) {
        if (group == null) throw new IllegalArgumentException("A Product is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("group", group);
            modelMap.addAttribute("roles", securityService.findRoles());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "group");

            return "group/edit";
        }

        this.securityService.save(group);


        return "redirect:/group/" + group.getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

}
