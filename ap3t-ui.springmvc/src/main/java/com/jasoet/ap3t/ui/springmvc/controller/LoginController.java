package com.jasoet.ap3t.ui.springmvc.controller;

import com.jasoet.ap3t.domain.User;
import com.jasoet.ap3t.service.SpringSecurityService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
/*------------------------------ Fields ------------------------------*/

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    @Qualifier("springSecurityService")
    private SpringSecurityService securityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

/* -------------------------- Other Methods -------------------------- */

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String index(ModelMap modelMap) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("Security Context Contains " + auth);

        modelMap.addAttribute("mainNav", "none");
        return "admin/login";
    }


    @RequestMapping(value = "/admin/password", method = RequestMethod.GET)
    public String changePassword(ModelMap modelMap) {
        Object updated = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (updated instanceof User) {
            modelMap.addAttribute("user", updated);
        } else {
            return "redirect:/loginpage";
        }

        modelMap.addAttribute("mainNav", "none");


        return "admin/cp";
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.PUT)
    public String updatePassword(ModelMap modelMap,
                                 @PathVariable("id") Long id,
                                 @RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("confirmPassword") String confirmPassword) {
        User updated = securityService.findUser(id);
        log.debug(currentPassword);
        log.debug(newPassword);
        log.debug(confirmPassword);

        if (passwordEncoder.isPasswordValid(updated.getPassword(), currentPassword, updated.getSalt())) {
            if (newPassword.equals(confirmPassword)) {
                updated.setPassword(passwordEncoder.encodePassword(newPassword, updated.getSalt()));
                securityService.save(updated);


                return "redirect:/dashboard";
            }
        }
        modelMap.addAttribute("securityService", securityService.findUser(id));
        modelMap.addAttribute("message", "Change Password Failed, Check your Current Password");

        modelMap.addAttribute("mainNav", "master");
        modelMap.addAttribute("tab", "staff");


        return "admin/cp";
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(ModelMap modelMap) {
        Object updated = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (updated instanceof User) {
            modelMap.addAttribute("user", updated);

            User loggedUser = (User) updated;

            loggedUser.getType();

        modelMap.addAttribute("mainNav", "none");
            return "home";
        } else {
            return "redirect:/loginpage";
        }

    }
}


