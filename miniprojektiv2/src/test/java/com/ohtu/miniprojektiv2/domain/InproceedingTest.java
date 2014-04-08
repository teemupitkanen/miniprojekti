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
    private Citation inp;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
      
        inp = new Citation("inproceedings",CitationType.INPROCEEDINGS);
    }

    @Test
    public void inproceedingsHaveUniqueId() {
        Citation first = new Citation("inproceedings",CitationType.INPROCEEDINGS );
        Citation another = new Citation("inproceedings",CitationType.INPROCEEDINGS);
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
