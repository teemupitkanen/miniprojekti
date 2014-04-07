package com.ohtu.miniprojektiv2.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InproceedingTest {

    public InproceedingTest() {
    }
    private Inproceeding inp;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        inp = new Inproceeding();
    }

    @Test
    public void inproceedingsHaveUniqueId() {
        Inproceeding first = new Inproceeding();
        Inproceeding another = new Inproceeding();
        assertFalse(another.getId() == first.getId());
    }

    @Test
    public void setSetsFieldCorrectly() {
        inp.setField("title", "test");
        assertEquals("test", inp.getField("title"));
    }

    @Test
    public void getEmptyFieldReturnsEmptyString() {
        assertEquals("", inp.getField("title"));
    }

    @Test
    public void getNonexistentFieldReturnsEmptyString() {
        assertEquals("", inp.getField("Foobar"));
    }
    
    @Test
    public void setNonexistentFieldDoesntAddSaidField() {
        inp.setField("mike", "newfield");
        assertEquals("", inp.getField("mike"));
    }
}
