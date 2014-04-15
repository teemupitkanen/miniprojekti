package com.ohtu.miniprojektiv2.domain;

import java.util.HashMap;
import java.util.Map;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CitationTest {

    public CitationTest() {
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
      
        inp = new Citation();
        inp.setCiteType(CitationType.INPROCEEDINGS);
    }

    @Test
    public void inproceedingsHaveUniqueId() {
        Citation first = new Citation();
        Citation another = new Citation();
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
    @Test
    public void creatingAnotherCitationTypeWorks(){
       Citation book = new Citation();
       book.setCiteType(CitationType.BOOK);
       
       assertEquals(CitationType.BOOK, book.getCiteType());
    }
    
    @Test
    public void getCiteId() {
        inp.setCiteId("Test");
        assertEquals("Test", inp.getCiteId());
    }

    @Test
    public void setCiteType() {
        inp.changeCiteType(CitationType.BOOK);
        assertTrue(inp.getCiteType() == CitationType.BOOK);
    }
    
    @Test
    public void setFields() {
        Map<String, String> map = new HashMap();
        inp.setFields(map);
        assertEquals(map, inp.getFields());
    }
    
    
}
