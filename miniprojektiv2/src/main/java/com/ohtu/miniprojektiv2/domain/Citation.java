package com.ohtu.miniprojektiv2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Citation {

    private final String[] applicableFields
            = {"author", "title", "booktitle", "year", // <- mandatory fields
                "editor", "volumeNumber", "series", "pages", "address",
                "month", "organization", "publisher", "note", "key"};

    private int id;
    private Map<String, String> fields;
    private String citeId;


    public Citation() {
        Random r = new Random();
        this.id = r.nextInt(Integer.MAX_VALUE);
        fields = new HashMap();
        for (String string : applicableFields) {
            fields.put(string, "");
        }
        this.citeId = fields.get("author").substring(0, 2) + fields.get("year").substring(2, 3);
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

    public String bibTexForm() {
        String code = "@inproceedings{" + ",\n";
        code += "author = ,\n" + "title = ,\n" + "booktitle = ,\n" + "year = ,\n";
        code += "} \n";
        return code;

    }
}
