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

   INPROCEEDINGS(new String[]{"author", "title", "booktitle", "year", // <- mandatory fields
      "editor", "volumeNumber", "series", "pages", "address",
      "month", "organization", "publisher", "note", "key"}),
   BOOK(new String[]{"author", "title", "publisher", "year", // <- mandatory fields
      "volume", "series", "address", "edition", "month", "note", "key"}),
   ARTICLE(new String[]{"author", "title", "journal", "year", // <- mandatory fields
      "volume", "number", "pages", "month", "note", "key"});
      
   private final String[] applicableFields;

   private CitationType(String[] applicableFields) {
      this.applicableFields = applicableFields;
   }

   public String[] getApplicableFields() {
      return applicableFields;
   }
}
