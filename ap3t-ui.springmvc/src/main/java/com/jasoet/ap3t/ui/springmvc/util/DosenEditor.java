package com.jasoet.ap3t.ui.springmvc.util;

import com.jasoet.ap3t.domain.Dosen;
import com.jasoet.ap3t.service.ActorService;

import java.beans.PropertyEditorSupport;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public class DosenEditor extends PropertyEditorSupport {

    private ActorService actorService;

    public DosenEditor(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    public String getAsText() {
        Dosen dosen = (Dosen) getValue();
        if (dosen != null) {
            return dosen.getId() + "";
        } else {
            return "";
        }
    }

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        try {
            Long id = Long.parseLong(s);
            setValue(actorService.findDosen(id));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
