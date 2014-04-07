package com.ohtu.miniprojektiv2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Inproceeding implements Citation {

    private static final String[] applicableFields
            = {"author", "title", "booktitle", "year", // <- mandatory fields
                "editor", "volumeNumber", "series", "pages", "address",
                "month", "organization", "publisher", "note", "key"};

    private final int id;
    private final Map<String, String> fields;


    public Inproceeding() {
        Random r = new Random();
        this.id = r.nextInt(Integer.MAX_VALUE);
        fields = new HashMap();
    }

    @Override
    public int getId() {
        return id;
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

    @Override
    public String getTitle() {
        return getField("title");
    }

    @Override
    public void setTitle(String title) {
        setField("title", title);
    }
}
