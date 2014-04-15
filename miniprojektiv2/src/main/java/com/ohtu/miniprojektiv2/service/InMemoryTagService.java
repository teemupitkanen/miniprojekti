package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Tag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author lauri
 */
@Service
public class InMemoryTagService implements TagService {

    private Map<Integer, Tag> tags;

    public InMemoryTagService() {
        tags = new HashMap();
    }

    @Override
    public Tag createTag(String name) {
        for (Tag tag : tags.values()) {
            if (tag.getName().equals(name)) {
                return null;
            }
        }
        
        Tag tag = new Tag(name);
        tags.put(tag.getId(), tag);
        return tag;
    }

    @Override
    public List<Tag> getTagsByListOfIDs(List<Integer> tagIDs) {
        List<Tag> tagList = new ArrayList();
        for (int id : tagIDs) {
            tagList.add(tags.get(id));
        }
        return tagList;
    }

    @Override
    public List<Tag> getMissingTagsByTagIDs(List<Integer> tagIDs) {
        List<Tag> tagList = new ArrayList(tags.values());
        for (int i : tagIDs) {
            tagList.remove(tags.get(i));
        }
        return tagList;
    }

    @Override
    public void remove(int tagId) {
        tags.remove(tagId);
    }

    @Override
    public Tag getById(Integer tagId) {
        return tags.get(tagId);
    }
}
