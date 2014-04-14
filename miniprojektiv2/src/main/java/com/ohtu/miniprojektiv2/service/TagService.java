package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Tag;
import java.util.List;

/**
 * Interface class for dealing with tags.
 * @author lauri
 */
public interface TagService {

    /**
     * For getting a tag by id number.
     * @param tagId id that is looked for in the tag collection.
     * @return returns a Tag object.
     */
    Tag getById(Integer tagId);
    
    /**
     * For creating a new tag.
     * @param name is the name the new tag will get.
     * @return returns the created Tag object.
     */
    Tag createTag(String name);

    /**
     * For getting a list of Tag objects that are searched for with a
     * list of id numbers.
     * @param tagIDs is a list of id numbers (integers).
     * @return returns a list of Tag objects.
     */
    List<Tag> getTagsByListOfIDs(List<Integer> tagIDs);
    
    /**
     * For finding tags that are not attached to a citation, but could
     * be given to it.
     * @param tagIDs is a list of Tag object id numbers.
     * @return returns a list of Tag objects.
     */
    List<Tag> getMissingTagsByTagIDs(List<Integer> tagIDs);

    /**
     * For removing a tag.
     * @param tagId is the id of a tag to be removed.
     */
    void remove(int tagId);
    
}
