package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Citation;
import com.ohtu.miniprojektiv2.domain.Tag;
import com.ohtu.miniprojektiv2.domain.TagCitation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author 41407
 */
@Service
public class TagService {

    private List<TagCitation> tagCitations;

    public TagService() {
        tagCitations = new ArrayList();
    }

    public void addTagToCitation(Integer citationId, Integer tagId) {
        tagCitations.add(new TagCitation(citationId, tagId));
    }

    public List<TagCitation> getAll() {
        return tagCitations;
    }

    void removeTagFromCitation(Integer citationId, Integer tagId) {
        TagCitation toBeRemoved = null;
        for (TagCitation tagCitation : tagCitations) {
            if (tagCitation.getCitationId() == citationId) {
                if (tagCitation.getTagId() == tagId) {
                    toBeRemoved = tagCitation;
                }
            }
        }
        tagCitations.remove(toBeRemoved);
    }

    public List<Integer> getCitationsByTagId(int tagId) {
        List<Integer> listOfCitationIDs = new ArrayList();
        for (TagCitation tagCitation : tagCitations) {
            if (tagCitation.getTagId() == tagId) {
                listOfCitationIDs.add(tagCitation.getCitationId());
            }
        }
        return listOfCitationIDs;
    }

    public List<Integer> getTagsByCitationId(int citationId) {
        List<Integer> listOfTagIDs = new ArrayList();
        for (TagCitation tagCitation : tagCitations) {
            if (tagCitation.getCitationId() == citationId) {
                listOfTagIDs.add(tagCitation.getTagId());
            }
        }
        return listOfTagIDs;
    }

    public void removeTag(int tagId) {
        List<TagCitation> toBeRemoved = new ArrayList();
        for (TagCitation tagCitation : tagCitations) {
            if (tagCitation.getTagId() == tagId) {
                toBeRemoved.add(tagCitation);
            }
        }
        for (TagCitation tagCitation : toBeRemoved) {
            tagCitations.remove(tagCitation);
        }
    }

    public void removeCitation(int citationId) {
        List<TagCitation> toBeRemoved = new ArrayList();
        for (TagCitation tagCitation : tagCitations) {
            if (tagCitation.getCitationId() == citationId) {
                toBeRemoved.add(tagCitation);
            }
        }
        for (TagCitation tagCitation : toBeRemoved) {
            tagCitations.remove(tagCitation);

        }
    }
}
