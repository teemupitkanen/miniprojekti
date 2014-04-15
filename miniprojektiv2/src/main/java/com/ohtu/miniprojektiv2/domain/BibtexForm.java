/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ohtu.miniprojektiv2.domain;

import java.util.Map;

/**
 *
 * @author 41407
 */
public abstract class BibtexForm {
    
    /**
     * Returns the citation in BibTeX format
     *
     * @param citation citation whose BibTex form is to be returned
     * @return Bibtex representation of Citation's fields
     */
    public static String getBibTexForm(Citation citation) {
        String code = "@" + citation.getCiteType().getName() + "{" + citation.getCiteId() + ",<br>";
        for (Map.Entry<String, String> entry : citation.getFields().entrySet()) {
            if (!entry.getValue().equals("")) {
                code += entry.getKey() + "= {" + replaceNordics(entry.getValue()) + "},<br>";
            }
        }
        code += "} <br>";
        System.out.println(code);
        return code;
    }

    /**
     * Replaces ascii incompatible characters in the input string with
     * BibTeX format
     *
     * @param string
     * @return
     */
    private static String replaceNordics(String string) {
        string = string.replaceAll("å", "{\\\\aa}");
        string = string.replaceAll("ä", "\\\\\"{a}");
        string = string.replaceAll("ö", "\\\\\"{o}");
        string = string.replaceAll("Å", "{\\\\AA}");
        string = string.replaceAll("Ä", "\\\\\"{A}");
        string = string.replaceAll("Ö", "\\\\\"{O}");
        return string;
    }
}
