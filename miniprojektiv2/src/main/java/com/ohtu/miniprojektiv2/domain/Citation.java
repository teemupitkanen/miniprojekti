package com.ohtu.miniprojektiv2.domain;

import java.util.HashMap;
import java.util.Map;

public class Citation {

    private int id;
    private Map<String, String> fields;
    private String citeId;
    private CitationType citeType;
    private String[] applicableFields = new String[10];

    public Citation() {
        this.id = IntegerFactory.next();
        fields = new HashMap();
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

    public void setCiteType(CitationType citeType) {
        this.citeType = citeType;
        this.setApplicableFields(citeType);
    }

    public CitationType getCiteType() {
        return citeType;
    }

    /**
     * Sets which fields can be set for this citation, as specified by its
     * citation type.
     * 
     * @param type 
     */
    private void setApplicableFields(CitationType type) {
        fields = new HashMap();
        this.applicableFields = type.getApplicableFields();
        for (String string : applicableFields) {
            fields.put(string, "");
        }
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
        String code = "@" + citeType + "{" + citeId + ",<br>";
        for (int i = 0; i < applicableFields.length; i++) {
            if (!fields.get(applicableFields[i]).equals("")) {
                code += applicableFields[i] + " = {" + replaceNordics(fields.get(applicableFields[i])) + "},<br>";
            }
        }
        code += "} <br>";
        return code;
    }

    private String replaceNordics(String string) {
        string = string.replaceAll("å", "{\\\\aa}");
        string = string.replaceAll("ä", "{\\\\\"a}");
        string = string.replaceAll("ö", "{\\\\\"o}");
        string = string.replaceAll("Å", "{\\\\AA}");
        string = string.replaceAll("Ä", "{\\\\\"A}");
        string = string.replaceAll("Ö", "{\\\\\"O}");
        return string;
    }
}
