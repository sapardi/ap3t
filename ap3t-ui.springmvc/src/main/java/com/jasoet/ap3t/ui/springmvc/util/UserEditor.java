package com.jasoet.ap3t.ui.springmvc.util;

import com.jasoet.ap3t.domain.User;
import com.jasoet.ap3t.service.SpringSecurityService;

import java.beans.PropertyEditorSupport;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public class UserEditor extends PropertyEditorSupport {

    private SpringSecurityService securityService;

    public UserEditor(SpringSecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public String getAsText() {
        User user = (User) getValue();
        if (user != null) {
            return user.getId() + "";
        } else {
            return "";
        }

    }

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        try {
            Long id = Long.parseLong(s);
            setValue(securityService.findUser(id));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
