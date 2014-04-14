package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Citation;
import java.util.List;

public interface CitationService {

    /**
     *
     */
    public List<Citation> listAll();

    public void insert(Citation cite);

    public Citation getById(Integer id);

    List<Citation> getCitationsByListOfIds(List<Integer> citationIDs);

}
