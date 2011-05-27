package com.jasoet.ap3t.ui.springmvc.controller;


import com.jasoet.ap3t.domain.Mahasiswa;
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
public class MahasiswaController {

    @Autowired
    @Qualifier("actorService")
    private ActorService actorService;

    @Autowired
    @Qualifier("springSecurityService")
    private SpringSecurityService securityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

/* -------------------------- Other Methods -------------------------- */

    @RequestMapping(value = "/mahasiswa/new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        Mahasiswa mahasiswa = new Mahasiswa();
        modelMap.addAttribute("mahasiswa", mahasiswa);
        modelMap.addAttribute("minatData", MinatEnum.values());


        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "mahasiswa");


        return "mahasiswa/create";
    }

    @RequestMapping(value = "/mahasiswa/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        Mahasiswa data = actorService.findMahasiswa(id);
        actorService.delete(data);
        return "redirect:/mahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/{id}/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        Mahasiswa mahasiswa = actorService.findMahasiswa(id);
        modelMap.addAttribute("mahasiswa", mahasiswa);
        modelMap.addAttribute("minatData", MinatEnum.values());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "mahasiswa");

        return "mahasiswa/edit";
    }

    @RequestMapping(value = "/mahasiswa", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {


        modelMap.addAttribute("data", actorService.findMahasiswas());

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "mahasiswa");


        return "mahasiswa/index";
    }

    @RequestMapping(value = "/mahasiswa", method = RequestMethod.POST)
    public String save(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa, BindingResult result, ModelMap modelMap) {
        if (mahasiswa == null) throw new IllegalArgumentException("A Product is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("mahasiswa", mahasiswa);

            modelMap.addAttribute("minatData", MinatEnum.values());
            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "mahasiswa");

            return "mahasiswa/create";
        }
        User user = new User();
        user.setUsername(mahasiswa.getNim());
        String salt = new String(Hex.encode(mahasiswa.getNim().getBytes()));
        user.setSalt(salt);
        user.setPassword(passwordEncoder.encodePassword(mahasiswa.getNim(), salt));
        user.setEnabled(true);
        user.setType(UserTypeEnum.MAHASISWA);

        mahasiswa.setUser(user);

        actorService.save(mahasiswa);

        return "redirect:/mahasiswa/" + mahasiswa.getId();
    }

    @RequestMapping(value = "/mahasiswa/{id}", method = RequestMethod.GET)
    public String show(ModelMap modelMap, @PathVariable("id") Long id) {
        Mahasiswa data = actorService.findMahasiswa(id);
        modelMap.addAttribute("data", data);

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "mahasiswa");


        return "mahasiswa/show";
    }

    @RequestMapping(value = "/mahasiswa", method = RequestMethod.PUT)
    public String update(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa, BindingResult result, ModelMap modelMap) {
        if (mahasiswa == null) throw new IllegalArgumentException("A Product is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("mahasiswa", mahasiswa);

            modelMap.addAttribute("minatData", MinatEnum.values());
            modelMap.addAttribute("mainNav", "master");
            modelMap.addAttribute("tab", "mahasiswa");

            return "mahasiswa/edit";
        }

        actorService.save(mahasiswa);


        return "redirect:/mahasiswa/" + mahasiswa.getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(User.class, new UserEditor(securityService));
    }


}
