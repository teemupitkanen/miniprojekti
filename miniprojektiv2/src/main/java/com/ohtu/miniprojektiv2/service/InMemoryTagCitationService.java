package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.TagCitation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Provides the actual functionality for handling tags and citations.
 * The methods with override tag are described in the interface class.
 * @see com.ohtu.miniprojektiv2.service.TagCitationService
 * @author 41407
 */
@Service
public class InMemoryTagCitationService implements TagCitationService {

    private List<TagCitation> tagCitations;
    
    public InMemoryTagCitationService() {
        tagCitations = new ArrayList();
    }
    
    @Override
    public void addTagToCitation(Integer citationId, Integer tagId) {
        tagCitations.add(new TagCitation(citationId, tagId));
    }

    @Override
    public List<TagCitation> getAll() {
        return tagCitations;
    }

    @Override
    public void removeTagFromCitation(Integer citationId, Integer tagId) {
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

    @Override
    public List<Integer> getCitationsByTagId(int tagId) {
        List<Integer> listOfCitationIDs = new ArrayList();
        for (TagCitation tagCitation : tagCitations) {
            if (tagCitation.getTagId() == tagId) {
                listOfCitationIDs.add(tagCitation.getCitationId());
            }
        }
        return listOfCitationIDs;
    }
    
    @Override
    public List<Integer> getTagsByCitationId(int citationId) {
        List<Integer> listOfTagIDs = new ArrayList();
        for (TagCitation tagCitation : tagCitations) {
            if (tagCitation.getCitationId() == citationId) {
                listOfTagIDs.add(tagCitation.getTagId());
            }
        }
        return listOfTagIDs;
    }

    @Override
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

    @Override
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
