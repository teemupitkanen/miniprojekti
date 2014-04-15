package com.ohtu.miniprojektiv2.domain;

/**
 * An enum class for defining the type of citation being created
 * @author 41407, Santeri
 */
public enum CitationType {

    INPROCEEDINGS("inproceedings", new String[]{"author", "title", "booktitle", "year", // <- mandatory fields
        "editor", "volumeNumber", "series", "pages", "address",
        "month", "organization", "publisher", "note", "key"}),
    BOOK("book", new String[]{"author", "title", "publisher", "year", // <- mandatory fields
        "volume", "series", "address", "edition", "month", "note", "key"}),
    ARTICLE("article", new String[]{"author", "title", "journal", "year", // <- mandatory fields
        "volume", "number", "pages", "month", "note", "key"});

    private final String name;
    private final String[] applicableFields;

    /**
     * Constructor for the class.
     * @param name is the name of the type.
     * @param applicableFields defines the fields that are applicable with a
     * given citation type.
     */
    private CitationType(String name, String[] applicableFields) {
        this.name = name;
        this.applicableFields = applicableFields;
    }

    /**
     * @return returns the name of citation type.
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return returns a string array of citation's applicable fields.
     */
    public String[] getApplicableFields() {
        return applicableFields;
    }
}
