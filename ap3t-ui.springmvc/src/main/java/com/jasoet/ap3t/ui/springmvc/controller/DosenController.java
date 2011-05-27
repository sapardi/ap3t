package com.jasoet.ap3t.ui.springmvc.controller;


import com.jasoet.ap3t.domain.Dosen;
import com.jasoet.ap3t.domain.User;
import com.jasoet.ap3t.domain.enums.MinatEnum;
import com.jasoet.ap3t.domain.enums.UserTypeEnum;
import com.jasoet.ap3t.service.ActorService;
import com.jasoet.ap3t.service.SpringSecurityService;
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
public class DosenController {

    @Autowired
    @Qualifier("actorService")
    private ActorService actorService;

    @Autowired
    @Qualifier("springSecurityService")
    private SpringSecurityService securityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

/* -------------------------- Other Methods -------------------------- */

    @RequestMapping(value = "/dosen/new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        Dosen dosen = new Dosen();
        modelMap.addAttribute("dosen", dosen);
        modelMap.addAttribute("minatData", MinatEnum.values());


        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "dosen");


        return "dosen/create";
    }

    @RequestMapping(value = "/dosen/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        Dosen data = actorService.findDosen(id);
        actorService.delete(data);
        return "redirect:/dosen";
    }

    @RequestMapping(value = "/dosen/{id}/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        Dosen dosen = actorService.findDosen(id);
        modelMap.addAttribute("dosen", dosen);
        modelMap.addAttribute("minatData", MinatEnum.values());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "dosen");

        return "dosen/edit";
    }

    @RequestMapping(value = "/dosen", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {


        modelMap.addAttribute("data", actorService.findDosens());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "dosen");


        return "dosen/index";
    }

    @RequestMapping(value = "/dosen", method = RequestMethod.POST)
    public String save(@ModelAttribute("dosen") Dosen dosen, BindingResult result, ModelMap modelMap) {
        if (dosen == null) throw new IllegalArgumentException("An Object is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("dosen", dosen);
            modelMap.addAttribute("minatData", MinatEnum.values());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "dosen");

            return "dosen/create";
        }
        User user = new User();
        user.setUsername(dosen.getNip());
        String salt = new String(Hex.encode(dosen.getNip().getBytes()));
        user.setSalt(salt);
        user.setPassword(passwordEncoder.encodePassword(dosen.getNip(), salt));
        user.setEnabled(true);
        user.setType(UserTypeEnum.DOSEN);

        dosen.setUser(user);

        actorService.save(dosen);

        return "redirect:/dosen/" + dosen.getId();
    }

    @RequestMapping(value = "/dosen/{id}", method = RequestMethod.GET)
    public String show(ModelMap modelMap, @PathVariable("id") Long id) {
        Dosen data = actorService.findDosen(id);
        modelMap.addAttribute("data", data);

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "dosen");


        return "dosen/show";
    }

    @RequestMapping(value = "/dosen", method = RequestMethod.PUT)
    public String update(@ModelAttribute("dosen") Dosen dosen, BindingResult result, ModelMap modelMap) {
        if (dosen == null) throw new IllegalArgumentException("A Product is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("dosen", dosen);
            modelMap.addAttribute("minatData", MinatEnum.values());

            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "dosen");

            return "dosen/edit";
        }

        actorService.save(dosen);


        return "redirect:/dosen/" + dosen.getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(User.class, new UserEditor(securityService));
    }

}
