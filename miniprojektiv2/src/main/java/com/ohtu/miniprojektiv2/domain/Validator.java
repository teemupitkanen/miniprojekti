/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ohtu.miniprojektiv2.domain;

/**
 *
 * @author 41407
 */
public abstract class Validator {

    /**
     * Checks parameter Citation for errors.
     *
     * @param citation citation to be checked
     * @return true if has errors, false if not
     */
    public static boolean checkForErrors(Citation citation) {
        int i = 0;
        if (citation.getCiteId() != null) {
            if (citation.getCiteId().length() == 0) {
                return true;
            }
        } else {
            return true;
        }
        for (String fieldName : citation.getCiteType().getApplicableFields()) {
            if (citation.getFields().get(fieldName).length() == 0) {
                return true;
            }
            i++;
            if (i > 3) {
                if (citation.getFields().get("year") != null) {
                    if (citation.getFields().get("year").matches("^\\d{4}$")) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
