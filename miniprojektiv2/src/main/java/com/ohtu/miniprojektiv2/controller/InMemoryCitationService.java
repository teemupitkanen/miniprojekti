/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ohtu.miniprojektiv2.controller;

import com.ohtu.miniprojektiv2.domain.Inproceedings;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InMemoryCitationService implements CitationService{
   
   /**
    *
    */
   private List<Inproceedings> list;
   
   public InMemoryCitationService(){
      list = new ArrayList<Inproceedings>();
   }

   @Override
   public List<Inproceedings> listAll() {
      return list;
   }

   @Override
   public void insert(Inproceedings cite) {
      list.add(cite);
   }
   
}
