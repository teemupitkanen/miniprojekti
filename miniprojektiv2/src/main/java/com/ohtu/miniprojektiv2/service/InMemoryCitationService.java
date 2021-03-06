package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Citation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Controls adding, listing and searching inproceedings-cites. The
 * methods are described in the interface class.
 * @see com.ohtu.miniprojektiv2.service.CitationService
 */
@Service
public class InMemoryCitationService implements CitationService {

    /**
     * Class list object for keeping track of Citations.
     */
    private List<Citation> list;

    public InMemoryCitationService() {
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
    public Citation getById(Integer id) {
        for (Citation inproceeding : list) {
            if (inproceeding.getId() == id) {
                return inproceeding;
            }
        }
        return null;
    }

    @Override
    public List<Citation> getCitationsByListOfIds(List<Integer> citationIDs) {
        List<Citation> returnList = new ArrayList();
        for (Integer citationID : citationIDs) {
            returnList.add(getById(citationID));
        }
        return returnList;
    }
}
