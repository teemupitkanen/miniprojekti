package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Citation;
import java.util.List;

/**
 * An interface class for dealing with citations.
 * @author santerim
 */
public interface CitationService {
    
   /**
    * For getting a list of Citation objects.
    * @return return a list of Citation objects.
    */
   public List<Citation> listAll();
   
   /**
    * For inserting a new citation.
    * @param cite is the citation that will be added to the collection for
    * all citations.
    */
   public void insert(Citation cite);
   
   /**
    * For finding a specific Citation by its id number.
    * @param id is the id number of the citation being searched.
    * @return returns a Citation object.
    */
   public Citation getById(Integer id);

   List<Citation> getCitationsByListOfIds(List<Integer> citationIDs);
}
