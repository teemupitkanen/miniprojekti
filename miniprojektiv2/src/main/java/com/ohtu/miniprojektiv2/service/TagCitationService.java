package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Tag;
import com.ohtu.miniprojektiv2.domain.TagCitation;
import java.util.List;

/**
 * This interface defines the functionality for handling issues between
 * tags and citations.
 * @author lauri
 */
public interface TagCitationService {

    /**
     * Adds a tag to citation.
     * @param citationId id of the citation to which the tag is added to.
     * @param tagId id of the tag being added.
     */
    void addTagToCitation(Integer citationId, Integer tagId);

    /**
     * @return Gives a list of TagCitation objects.
     */
    List<TagCitation> getAll();
    
    /**
     * Removes tag from citation.
     * @param citationId id of the citation.
     * @param tagId id of the tag.
     */
    void removeTagFromCitation(Integer citationId, Integer tagId);

    /**
     * For finding citations by the id of a given tag.
     * @param tagId the id used in the search.
     * @return gives a list of citation id numbers.
     */
    List<Integer> getCitationsByTagId(int tagId);

    /**
     * For finding tags by the id of given citation.
     * @param citationId the id used in search.
     * @return gives a list of tag id numbers.
     */
    List<Integer> getTagsByCitationId(int citationId);

    /**
     * Removes a citation
     * @param citationId the id of the citation to be deleted.
     */
    void removeCitation(int citationId);

    /**
     * Removes a tag.
     * @param tagId the id of the tag being removed.
     */
    void removeTag(int tagId);
    
}
