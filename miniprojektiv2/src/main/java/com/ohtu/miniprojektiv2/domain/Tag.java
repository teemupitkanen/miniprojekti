
package com.ohtu.miniprojektiv2.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class for the Tag object.
 * @author jee
 */
public class Tag {

    /**
     * Identification variable.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    /**
     * Name variable.
     */
    private String name;

    /**
     * Constructor for the class.
     * @param name is the name given to the tag by user.
     */
    public Tag(String name) {
        this.id = IntegerFactory.next();
        this.name = name;
    }

    /**
     * @return returns the id of the tag.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return returns the name of the tag.
     */
    public String getName() {
        return name;
    }
}
