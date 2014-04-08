package com.ohtu.miniprojektiv2.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CitationTest {

   public CitationTest() {
   }
   private Citation inp;
   private Citation print;

   @BeforeClass
   public static void setUpClass() {
   }

   @AfterClass
   public static void tearDownClass() {
   }

   @Before
   public void setUp() {
      print = new Citation();
      print.setApplicableFields(CitationType.INPROCEEDINGS);
      print.setCiteType("inproceedings");
      print.setCiteId("MAA95");

      inp = new Citation();
      inp.setCiteType("inproceedings");
      inp.setApplicableFields(CitationType.INPROCEEDINGS);
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
   public void creatingAnotherCitationTypeWorks() {
      Citation book = new Citation();
      book.setCiteId("KIRJA123");
      book.setApplicableFields(CitationType.BOOK);

      assertEquals("KIRJA123", book.getCiteId());
   }

   @Test
   public void printingBibTexWorks() {

      print.setField("author", "Mäkkylä");
      print.setField("title", "Coding for Dummies");
      String correct = "@inproceedings{MAA95,<br>";
      correct += "author = {M\"{a}kkyl\"{a} },<br>";
      correct += "title = {Coding for Dummies} },<br>";
      correct += "} <br>";
      assertEquals(correct, inp.getBibTexForm());
   }
}
