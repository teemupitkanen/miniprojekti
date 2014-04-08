package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Tag;
import java.util.List;

/**
 *
 * @author lauri
 */
public interface TagService {

    Tag createTag(String name);

    List<Tag> getTagsByListOfIDs(List<Integer> tagIDs);
    
    List<Tag> getMissingTagsByTagIDs(List<Integer> tagIDs);

    void remove(int tagId);
    
}
