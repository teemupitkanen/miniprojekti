package com.ohtu.miniprojektiv2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Citation {

//   private final String[] applicableFields = {"author", "title", "booktitle", "year", // <- mandatory fields
//      "editor", "volumeNumber", "series", "pages", "address",
//      "month", "organization", "publisher", "note", "key"};
   private int id;
   private Map<String, String> fields;
   private String citeId;
   private String citeType;
   private String[] applicableFields;

   public Citation(String citeType, CitationType type) {
      Random r = new Random();
      this.id = r.nextInt(Integer.MAX_VALUE);
      this.applicableFields = type.getApplicableFields();
      fields = new HashMap();
      for (String string : applicableFields) {
         fields.put(string, "");
      }
   }

   public int getId() {
      return id;
   }

   public void setCiteId(String citeId) {
      this.citeId = citeId;
   }

   public String getCiteId() {
      return citeId;
   }

   /**
    *
    * @param field Field name whose value is wanted
    * @return Value for given field, or empty string if field not found
    */
   public String getField(String field) {
      if (fields.containsKey(field)) {
         return fields.get(field);
      } else {
         return "";
      }
   }

   /**
    *
    * @param field Name of field
    * @param value Value to be inserted to field
    */
   public void setField(String field, String value) {
      for (String string : applicableFields) {
         if (string.equals(field)) {
            fields.put(field, value);
         }
      }
   }

   public Map<String, String> getFields() {
      return fields;
   }

   public void setFields(Map<String, String> fields) {
      this.fields = fields;
   }

   public String getBibTexForm() {
      String code = "@"+ citeType+"{" + citeId + ",<br>";
      
      for (int i = 0; i < applicableFields.length; i++) {
         String string = fields.get(applicableFields[i]);
         if (!string.equals("")) {
            code += applicableFields[i] + " = {";
            String added = "";
            for (int j = 0; j < string.length(); j++) {
               if (string.charAt(j) == 'ä') {
                  added += "\"{a}";
               } else if (string.charAt(j) == 'ö') {
                  added += "\"{o}";
               } else {
                  added += string.charAt(j);
               }
               code += added;
            }
            code += " },<br>";
         }

      }
      code += "} <br>";
      return code;

   }

}
