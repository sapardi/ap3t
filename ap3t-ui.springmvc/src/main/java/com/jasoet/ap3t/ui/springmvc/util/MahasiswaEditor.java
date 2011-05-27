package com.jasoet.ap3t.ui.springmvc.util;

import com.jasoet.ap3t.domain.Mahasiswa;
import com.jasoet.ap3t.service.ActorService;

import java.beans.PropertyEditorSupport;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public class MahasiswaEditor extends PropertyEditorSupport {

    private ActorService actorService;

    public MahasiswaEditor(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    public String getAsText() {
        Mahasiswa mahasiswa = (Mahasiswa) getValue();
        if (mahasiswa != null) {
            return mahasiswa.getId() + "";
        } else {
            return "";
        }
    }

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        try {
            Long id = Long.parseLong(s);
            setValue(actorService.findMahasiswa(id));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
