package com.jasoet.ap3t.ui.springmvc.security;


import com.jasoet.ap3t.service.SpringSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "securityService")
public class SecurityService implements UserDetailsService {
/*------------------------------ Fields ------------------------------*/

    @Autowired
    private SpringSecurityService securityService;

/* --------------------- Interface UserDetailsService --------------------- */


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {
        try {
            UserDetails o = securityService.findUsersByUsername(s);
            if (o != null) {
                return o;
            } else {
                throw new UsernameNotFoundException("User Not Found");
            }
        } catch (Exception x) {
            throw new UsernameNotFoundException(x.getMessage());
        }
    }
}
