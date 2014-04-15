
package com.ohtu.miniprojektiv2.domain;

/**
 * This class works as a joint table between classes Tag and Citation.
 * @see com.ohtu.miniprojektiv2.domain.Citation
 * @see com.ohtu.miniprojektiv2.domain.Tag
 * @author 41407
 */
public class TagCitation {

    /**
     * Variable for keeping track of citation id numbers.
     */
    private final int citationId;
    /**
     * Variable for keeping track of tag id numbers.
     */
    private final int tagId;

    /**
     * Constructor that accepts integer values as parameters.
     * @param citationId id of citation.
     * @param tagId id of tag.
     */
    public TagCitation(int citationId, int tagId) {
        this.tagId = tagId;
        this.citationId = citationId;
    }

    /**
     * Constructor that accepts objects as parameters.
     * @param c citation object.
     * @param t tag object.
     */
    public TagCitation(Citation c, Tag t) {
        this.citationId = c.getId();
        this.tagId = t.getId();
    }

    /**
     * @return returns citation id number.
     */
    public int getCitationId() {
        return citationId;
    }

    /**
     * @return returns tag id number.
     */
    public int getTagId() {
        return tagId;
    }

    /**
     * For checking if two objects are the same within this program's
     * context.
     * @param obj is the object that is compared to the instance of this class.
     * @return returns a boolean value, which is true if the objects are
     * deemed equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TagCitation other = (TagCitation) obj;
        if (this.citationId != other.citationId) {
            return false;
        }
        if (this.tagId != other.tagId) {
            return false;
        }
        return true;
    }
}
