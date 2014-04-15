package com.ohtu.miniprojektiv2.domain;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The main class for citations. Works together with CitationType
 * class.
 * @author santerim
 */
public class Citation {

    /**
     * An id number that is used for singling out a citation.
     */
    private int id;
    
    /**
     * A map for storing the field names.
     */
    private Map<String, String> fields;
    
    /**
     * A citation id, that is used in the BibTeX output, and defined by
     * the user.
     */
    private String citeId;
    
    /**
     * The type a citation has = article, inproceedings or book.
     */
    private CitationType citeType;
    
    /**
     * An array of the string names that are applicable with a given citation
     * type.
     */
    private String[] applicableFields = new String[10];

    /**
     * Constructs a new Citation object.
     */
    public Citation() {
        this.id = IntegerFactory.next();
        fields = new LinkedHashMap();
    }

    /**
     * @return returns the id number that singles out a citation within the
     * code (vs. citeId numbers, that are given by the user).
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the citeId number for a citation, and is given by the user.
     * @param citeId an identifying id string that has been received from
     * citation creation form.
     */
    public void setCiteId(String citeId) {
        this.citeId = citeId;
    }

    /**
     * @return returns the citeId.
     */
    public String getCiteId() {
        return citeId;
    }

    /**
     * Sets the citation type, which defines the required fields for
     * creating a new citation.
     * @param citeType 
     */
    public void setCiteType(CitationType citeType) {
        this.citeType = citeType;
        this.setApplicableFields(citeType);
    }

    /**
     * Changes the citeType of a citation.
     * @param citeType is the new citeType wanted.
     */
    public void changeCiteType(CitationType citeType) {
        this.citeType = citeType;
    }
    
    /**
     * @return returns the citation's citeType.
     */
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
        fields = new LinkedHashMap();
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

    /**
     * @return returns the fields of the citation.
     */
    public Map<String, String> getFields() {
        return fields;
    }

    /**
     * Sets the fields for the citation.
     * @param fields is the field map.
     */
    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    /**
     * Returns the citation in BibTeX format
     *
     * @return
     */
    public String getBibTexForm() {
        String code = "@" + citeType.getName() + "{" + citeId + ",<br>";
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            if (!entry.getValue().equals("")) {
                code += entry.getKey() + "= {" + replaceNordics(entry.getValue()) + "},<br>";
            }
        }
        code += "} <br>";
        return code;
    }

    /**
     * Replaces ascii incompatible characters in the input string with
     * BibTeX format
     * @param string
     * @return
     */
    private String replaceNordics(String string) {
        string = string.replaceAll("å", "{\\\\aa}");
        string = string.replaceAll("ä", "\\\\\"{a}");
        string = string.replaceAll("ö", "\\\\\"{o}");
        string = string.replaceAll("Å", "{\\\\AA}");
        string = string.replaceAll("Ä", "\\\\\"{A}");
        string = string.replaceAll("Ö", "\\\\\"{O}");
        return string;
    }
}
