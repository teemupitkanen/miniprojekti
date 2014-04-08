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
public class TagCitation {

    private final int citationId;
    private final int tagId;

    public TagCitation(int citationId, int tagId) {
        this.tagId = tagId;
        this.citationId = citationId;
    }

    public TagCitation(Citation c, Tag t) {
        this.citationId = c.getId();
        this.tagId = t.getId();
    }

    public int getCitationId() {
        return citationId;
    }

    public int getTagId() {
        return tagId;
    }

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
