package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Tag;
import com.ohtu.miniprojektiv2.domain.TagCitation;
import java.util.List;

/**
 *
 * @author lauri
 */
public interface TagCitationService {

    void addTagToCitation(Integer citationId, Integer tagId);

    List<TagCitation> getAll();
    
    void removeTagFromCitation(Integer citationId, Integer tagId);

    List<Integer> getCitationsByTagId(int tagId);

    List<Integer> getTagsByCitationId(int citationId);

    void removeCitation(int citationId);

    void removeTag(int tagId);
    
}
