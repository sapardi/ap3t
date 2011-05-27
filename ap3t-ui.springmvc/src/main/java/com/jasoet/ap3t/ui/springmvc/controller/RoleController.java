package com.jasoet.ap3t.ui.springmvc.controller;


import com.jasoet.ap3t.domain.Role;
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
public class RoleController {

    @Autowired
    @Qualifier("springSecurityService")
    private SpringSecurityService securityService;


    @RequestMapping(value = "/role/new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        Role role = new Role();
        modelMap.addAttribute("role", role);


        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "role");


        return "role/create";
    }

    @RequestMapping(value = "/role/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String authority) {
        Role data = securityService.findRole(authority);
        securityService.delete(data);
        return "redirect:/role";
    }

    @RequestMapping(value = "/role/{id}/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable("id") String authority) {
        Role role = securityService.findRole(authority);
        modelMap.addAttribute("role", role);

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "role");

        return "role/edit";
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {


        modelMap.addAttribute("data", securityService.findRoles());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "role");


        return "role/index";
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public String save(@ModelAttribute("role") Role role, BindingResult result, ModelMap modelMap) {
        if (role == null) throw new IllegalArgumentException("An Object is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("role", role);

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "role");

            return "role/create";
        }


        securityService.save(role);

        return "redirect:/role/" + role.getAuthority();
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public String show(ModelMap modelMap, @PathVariable("id") String authority) {
        Role data = securityService.findRole(authority);
        modelMap.addAttribute("data", data);

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "role");


        return "role/show";
    }

    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    public String update(@ModelAttribute("role") Role role, BindingResult result, ModelMap modelMap) {
        if (role == null) throw new IllegalArgumentException("An Object is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("role", role);

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "role");

            return "role/edit";
        }

        securityService.save(role);


        return "redirect:/role/" + role.getAuthority();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

}
