package com.jasoet.ap3t.ui.springmvc.util;

import com.jasoet.ap3t.domain.Topik;
import com.jasoet.ap3t.service.DocumentService;

import java.beans.PropertyEditorSupport;

/**
 * Author : Deny Prasetyo
 * jasoet87@gmail.com
 *
 * @jasoet
 */
public class TopikEditor extends PropertyEditorSupport {

    private DocumentService documentService;

    public TopikEditor(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Override
    public String getAsText() {
        Topik topik = (Topik) getValue();
        if (topik != null) {
            return topik.getId() + "";
        } else {
            return "";
        }
    }

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        try {
            Long id = Long.parseLong(s);
            setValue(documentService.findTopik(id));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
