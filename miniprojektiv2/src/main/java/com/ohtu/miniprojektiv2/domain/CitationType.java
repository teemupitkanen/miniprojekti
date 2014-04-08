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
public enum CitationType {
    INPROCEEDINGS(new String[] {"author", "title", "booktitle", "year", // <- mandatory fields
                "editor", "volumeNumber", "series", "pages", "address",
                "month", "organization", "publisher", "note", "key"}),
    BOOK(new String[] {"jotain"}); //JNE

    private final String[] applicableFields;
//    private final String citeType;
    private CitationType(String[] applicableFields){
//       this.citeType = citeType;
        this. applicableFields = applicableFields;
    }

   public String[] getApplicableFields() {
      return applicableFields;
   }
    
}
