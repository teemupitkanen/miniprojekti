
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
        inp = new Inproceeding("someauthor","sometitle","somebooktitle","1999","","","","","","","","","","");
    }
    
    @Test
    public void inproceedingsHaveUniqueId(){
        Inproceeding first = new Inproceeding();
        Inproceeding another = new Inproceeding();
        assertFalse(another.getId() == first.getId());
    }
    @Test
    public void equalsRecognizesEqualInproceedings(){
        Inproceeding sameasfirst = new Inproceeding("someauthor","sometitle","somebooktitle","1999","","","","","","","","","","");
        assertEquals(sameasfirst.equals(inp),true);
    }
    
    @Test
    public void equalsRecognizesIfInproceedingsArentEqual(){
        Inproceeding another = new Inproceeding("someotherauthor","someothertitle","someotherbooktitle","2000","","","","","","","","","","");
        assertEquals(another.equals(inp),false);
    }
    @Test
    public void bibTexPrintingWithEmptyValues(){
       String bibtex = "@inproceedings{" + ",\n";
      bibtex += "author = ,\n" + "title = ,\n" + "booktitle = ,\n" + "year = ,\n";
      bibtex += "} \n";
      assertEquals(bibtex, inp.bibTexForm());
    }
}