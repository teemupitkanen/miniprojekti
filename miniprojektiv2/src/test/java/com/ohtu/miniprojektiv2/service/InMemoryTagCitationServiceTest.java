/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Citation;
import com.ohtu.miniprojektiv2.domain.Tag;
import com.ohtu.miniprojektiv2.domain.TagCitation;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class InMemoryTagCitationServiceTest {

    InMemoryTagCitationService ts = new InMemoryTagCitationService();
    Citation c = new Citation();
    Tag t = new Tag("Koira");

    public InMemoryTagCitationServiceTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void canAddTagsToCitations() {
        ts.addTagToCitation(c.getId(), t.getId());
        TagCitation tc = ts.getAll().get(0);
        assertEquals(c.getId(), tc.getCitationId());
        assertEquals((int) t.getId(), tc.getTagId());
    }

    @Test
    public void canRemoveTagsFromCitations() {
        ts.addTagToCitation(c.getId(), t.getId());
        ts.removeTagFromCitation(c.getId(), t.getId());
        assertTrue(ts.getAll().isEmpty());
    }

    @Test
    public void correctTagIsRemoved() {
        for (int i = 0; i < 10; i++) {
            ts.addTagToCitation(i, i);
        }
        ts.removeTagFromCitation(3, 3);
        List tagCitations = ts.getAll();
        assertTrue(tagCitations.contains(new TagCitation(2, 2)));
        assertFalse(tagCitations.contains(new TagCitation(3, 3)));
    }
    
    @Test
    public void correctTagIsRemovedWhenMultipleTagsOnSameCitation() {
        for (int i = 0; i < 10; i++) {
            ts.addTagToCitation(3, i);
        }
        ts.removeTagFromCitation(3, 3);
        List tagCitations = ts.getAll();
        assertTrue(tagCitations.contains(new TagCitation(3, 2)));
        assertFalse(tagCitations.contains(new TagCitation(3, 3)));
    }

    @Test
    public void getCitationsByTagSingleEntry() {
        int expected = 5;
        int tagId = 2;
        ts.addTagToCitation(expected, tagId);
        int actual = ts.getCitationsByTagId(tagId).get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void getCitationsByTagMultipleEntries() {
        List<Integer> expecteds = new ArrayList();
        expecteds.add(4);
        expecteds.add(5);
        expecteds.add(6);
        ts.addTagToCitation(3, 1);
        ts.addTagToCitation(4, 2);
        ts.addTagToCitation(5, 2);
        ts.addTagToCitation(6, 2);
        ts.addTagToCitation(7, 1);
        List<Integer> actuals = ts.getCitationsByTagId(2);
        assertEquals(expecteds, actuals);
        expecteds = new ArrayList();
        expecteds.add(3);
        expecteds.add(7);
        actuals = ts.getCitationsByTagId(1);
        assertEquals(expecteds, actuals);
    }

    @Test
    public void getTagsByCitationSingleEntry() {
        int tagId = 5;
        int citationId = 2;
        ts.addTagToCitation(citationId, tagId);
        int actual = ts.getTagsByCitationId(citationId).get(0);
        assertEquals(tagId, actual);
    }

    @Test
    public void getTagsByCitationMultipleEntries() {
        List<Integer> expecteds = new ArrayList();
        expecteds.add(4);
        expecteds.add(5);
        expecteds.add(6);
        ts.addTagToCitation(1, 3);
        ts.addTagToCitation(2, 4);
        ts.addTagToCitation(2, 5);
        ts.addTagToCitation(2, 6);
        ts.addTagToCitation(1, 7);
        List<Integer> actuals = ts.getTagsByCitationId(2);
        assertEquals(expecteds, actuals);
        expecteds = new ArrayList();
        expecteds.add(3);
        expecteds.add(7);
        actuals = ts.getTagsByCitationId(1);
        assertEquals(expecteds, actuals);
    }
    
    @Test
    public void removeTagRemovesAllAppropriateTagCitations() {
        ts.addTagToCitation(4, 3);
        ts.addTagToCitation(5, 3);
        ts.addTagToCitation(6, 3);
        ts.addTagToCitation(7, 4);
        ts.removeTag(3);
        int expected = 7;
        assertEquals(expected, ts.getAll().get(0).getCitationId());
    }
    
    @Test
    public void removeCitationRemovesAllAppropriateTagCitations() {
        ts.addTagToCitation(3, 5);
        ts.addTagToCitation(3, 6);
        ts.addTagToCitation(4, 7);
        ts.addTagToCitation(3, 8);
        ts.removeCitation(3);
        int expected = 7;
        assertEquals(expected, ts.getAll().get(0).getTagId());
    }
}