
package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Citation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InMemoryCitationService implements CitationService{
   
   /**
    *Controls adding, listing and searching inproceedings-cites
    */
   private List<Citation> list;
   
   public InMemoryCitationService(){
      list = new ArrayList<Citation>();
   }

   @Override
   public List<Citation> listAll() {
      return list;
   }

   @Override
   public void insert(Citation cite) {
      list.add(cite);
   }
   
   @Override
   public Citation getById(Integer id){
      for (Citation inproceeding : list) {
        if(inproceeding.getId() == id){
           return inproceeding;
        }
      }
      return null;
   }
   
}
