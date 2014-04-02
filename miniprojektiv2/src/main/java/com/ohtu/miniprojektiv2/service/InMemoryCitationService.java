/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.service.CitationService;
import com.ohtu.miniprojektiv2.domain.Inproceeding;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InMemoryCitationService implements CitationService{
   
   /**
    *Controls adding, listing and searching inproceedings-cites
    */
   private List<Inproceeding> list;
   
   public InMemoryCitationService(){
      list = new ArrayList<Inproceeding>();
   }

   @Override
   public List<Inproceeding> listAll() {
      return list;
   }

   @Override
   public void insert(Inproceeding cite) {
      list.add(cite);
   }
   
   @Override
   public Inproceeding getById(Integer id){
      for (Inproceeding inproceeding : list) {
        if(inproceeding.getId() == id){
           return inproceeding;
        }
      }
      return null;
   }
   
}
