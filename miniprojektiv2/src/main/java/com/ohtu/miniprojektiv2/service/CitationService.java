
package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Inproceeding;
import java.util.List;

public interface CitationService {
   /**
    *
    */
   public List<Inproceeding> listAll();
   public void insert(Inproceeding cite);
   public Inproceeding getById(Integer id);
}
