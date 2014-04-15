/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.IntegerFactory;
import com.ohtu.miniprojektiv2.domain.Tag;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 41407
 */
public class InMemoryTagServiceTest {

    private InMemoryTagService ts;

    private class TagStub extends Tag {

        private int id;

        public TagStub(String name, int id) {
            super(name);
            this.id = id;
        }

    }

    @Before
    public void setUp() {
        ts = new InMemoryTagService();
    }

    @Test
    public void constructorInitializesFields() {
        try {
            ts.getById(0);
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    public void createTagAddsTag() {
        IntegerFactory.reset();
        ts.createTag("Test");
        assertEquals("Test", ts.getById(0).getName());
    }
    
    @Test
    public void cannotCreateDuplicate() {
        ts.createTag("Test");
        ts.createTag("Test");
        assertTrue(ts.getMissingTagsByTagIDs(new ArrayList()).size() == 1);
    }

    @Test
    public void getByIdReturnsTagWhenTagExists() {
        IntegerFactory.reset();
        ts.createTag("Test");
        assertEquals("Test", ts.getById(0).getName());
    }

    @Test
    public void getByIdReturnsNullWhenTagDoesntExist() {
        IntegerFactory.reset();
        ts.createTag("Test");
        assertNull(ts.getById(200));
    }

    @Test
    public void getTagsByListOfIDsReturnsCorrectTags() {
        IntegerFactory.reset();
        List<Tag> actualTags;
        String[] expecteds = new String[10];
        String[] actuals = new String[10];
        List<Integer> ids = new ArrayList();
        for (int i = 0; i < 10; i++) {
            ts.createTag("Tag" + i);
            expecteds[i] = "Tag" + i;
            ids.add(i);
        }
        actualTags = ts.getTagsByListOfIDs(ids);
        int i = 0;
        for (Tag tag : actualTags) {
            actuals[i] = tag.getName();
            i++;
        }
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void getMissingTagsByListOfIDsReturnsCorrectTags() {
        IntegerFactory.reset();
        String[] expecteds = new String[10];
        String[] actuals = new String[10];
        List<Integer> ids = new ArrayList();
        // Add missing tags
        for (int i = 0; i < 10; i++) {
            ts.createTag("Tag" + i);
            expecteds[i] = "Tag" + i;
        }
        // Add non-missing tags; ie those that should not be returned by class
        for (int i = 10; i < 20; i++) {
            ts.createTag("Tag" + i);
            ids.add(i);
        }
        List<Tag> missingTags = ts.getMissingTagsByTagIDs(ids);
        int i = 0;
        for (Tag tag : missingTags) {
            actuals[i] = tag.getName();
            i++;
        }
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void removeRemovesCorrectTag() {
        IntegerFactory.reset();
        ts.createTag("Test1");
        ts.createTag("Test2");
        ts.remove(0);
        assertNull(ts.getById(0));
        assertEquals("Test2", ts.getById(1).getName());
    }
}
