package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Inproceeding;
import com.ohtu.miniprojektiv2.service.InMemoryCitationService;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class InMemoryCitationServiceTest {

   private InMemoryCitationService serv;
   private Inproceeding in;

   /**
    * Tests for InMemoryCitationService
    */
   public InMemoryCitationServiceTest() {
      this.serv = new InMemoryCitationService();
   }
   
   @Before
   public void Before(){
      this.in = new Inproceeding("Bill", "How to Code", "Coding fo Dummies", "2999","editor", "number", "series", "1000", "address", "January", "organization", "publisher", "note", "key");
   }

   @Test
   public void addingNewInproceedings() {
      serv.insert(in);

      String author = serv.listAll().get(0).getAuthor();

      assertEquals(in.getAuthor(), author);

   }
   
   @Test
   public void searchingInproceedins() {
      serv.insert(in);
      Inproceeding found = serv.getById(in.getId());

      assertEquals(in.getAuthor(), found.getAuthor());

   }
   @Test
   public void searchingUnexistentInproceedins() {
      serv.insert(in);
      Inproceeding found = serv.getById(666);

      assertEquals(null, found);
   }
}