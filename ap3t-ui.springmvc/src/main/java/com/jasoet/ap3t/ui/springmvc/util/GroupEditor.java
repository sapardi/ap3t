package com.jasoet.ap3t.ui.springmvc.util;

import com.jasoet.ap3t.domain.Group;
import com.jasoet.ap3t.service.SpringSecurityService;

import java.beans.PropertyEditorSupport;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public class GroupEditor extends PropertyEditorSupport {

    private SpringSecurityService securityService;

    public GroupEditor(SpringSecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public String getAsText() {
        Group group = (Group) getValue();
        if (group != null) {
            return group.getId() + "";
        } else {
            return "";
        }
    }

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        try {
            Long id = Long.parseLong(s);
            setValue(securityService.findGroup(id));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
