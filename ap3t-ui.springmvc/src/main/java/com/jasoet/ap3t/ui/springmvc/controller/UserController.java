package com.jasoet.ap3t.ui.springmvc.controller;


import com.jasoet.ap3t.domain.Group;
import com.jasoet.ap3t.domain.User;
import com.jasoet.ap3t.domain.enums.UserTypeEnum;
import com.jasoet.ap3t.service.SpringSecurityService;
import com.jasoet.ap3t.ui.springmvc.util.GroupEditor;
import com.jasoet.ap3t.ui.springmvc.util.UserEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.codec.Hex;
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
public class UserController {


    @Autowired
    @Qualifier("springSecurityService")
    private SpringSecurityService securityService;


    @Autowired
    private PasswordEncoder passwordEncoder;

/* -------------------------- Other Methods -------------------------- */

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("groups", securityService.findGroups());
        modelMap.addAttribute("types", UserTypeEnum.values());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "user");


        return "user/create";
    }

    @RequestMapping(value = "/user/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        User data = securityService.findUser(id);
        securityService.delete(data);
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/{id}/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        User user = securityService.findUser(id);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("groups", securityService.findGroups());
        modelMap.addAttribute("types", UserTypeEnum.values());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "user");

        return "user/edit";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {


        modelMap.addAttribute("data", securityService.findUsers());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "user");


        return "user/index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user, BindingResult result, ModelMap modelMap) {
        if (user == null) throw new IllegalArgumentException("An Object is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("groups", securityService.findGroups());
            modelMap.addAttribute("types", UserTypeEnum.values());
            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "user");

            return "user/create";
        }
        String salt = new String(Hex.encode(user.getUsername().getBytes()));
        user.setSalt(salt);
        user.setPassword(passwordEncoder.encodePassword(user.getUsername(), salt));
        securityService.save(user);

        return "redirect:/user/" + user.getId();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String show(ModelMap modelMap, @PathVariable("id") Long id) {
        User data = securityService.findUser(id);
        modelMap.addAttribute("data", data);

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "user");


        return "user/show";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String update(@ModelAttribute("user") User user, BindingResult result, ModelMap modelMap) {
        if (user == null) throw new IllegalArgumentException("A Product is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("groups", securityService.findGroups());
            modelMap.addAttribute("types", UserTypeEnum.values());
            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "user");

            return "user/edit";
        }

        securityService.save(user);


        return "redirect:/user/" + user.getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
         binder.registerCustomEditor(Group.class, new GroupEditor(securityService));
    }

}
