/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ohtu.miniprojektiv2.controller;

import com.ohtu.miniprojektiv2.domain.Inproceedings;
import java.util.List;

public interface CitationService {
   /**
    *
    */
   public List<Inproceedings> listAll();
   public void insert(Inproceedings cite);
}
