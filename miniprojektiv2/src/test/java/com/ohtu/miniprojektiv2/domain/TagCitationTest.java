/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ohtu.miniprojektiv2.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class TagCitationTest {

    Citation c = new Citation();
    Tag t = new Tag("b");
    TagCitation tc = new TagCitation(c, t);

    @Test
    public void intConstructorDoesntSuck() {
        int[] expecteds = {5, 10};
        TagCitation tc = new TagCitation(expecteds[0], expecteds[1]);
        int[] actuals = {tc.getCitationId(), tc.getTagId()};
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void objectConstructorDoesntBlow() {
        int[] expecteds = {c.getId(), t.getId()};
        int[] actuals = {tc.getCitationId(), tc.getTagId()};
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void equals() {
        assertFalse(tc.equals(null));
        assertFalse(tc.equals(new Integer(1)));
    }
}
