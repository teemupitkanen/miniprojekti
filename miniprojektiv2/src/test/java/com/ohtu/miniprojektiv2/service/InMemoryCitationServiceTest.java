package com.ohtu.miniprojektiv2.service;

import com.ohtu.miniprojektiv2.domain.Citation;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class InMemoryCitationServiceTest {

    private InMemoryCitationService serv;
    private Citation stubCitation;

    private class CitationStub extends Citation {

    }

    @Before
    public void setUp() {
        serv = new InMemoryCitationService();
        stubCitation = new CitationStub();
    }

    @Test
    public void constructorInitializesFields() {
        try {
            serv.listAll();
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    public void canAddSingleCitation() {
        serv.insert(stubCitation);
        List<Citation> expected = new ArrayList();
        expected.add(stubCitation);
        assertEquals(expected, serv.listAll());
    }

    @Test
    public void canAddMultipleCitations() {
        List<Citation> expected = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Citation stub = new CitationStub();
            serv.insert(stub);
            expected.add(stub);
        }
        assertEquals(expected, serv.listAll());
    }

    @Test
    public void getByIdReturnsCorrectly() {
        serv.insert(stubCitation);
        assertEquals(stubCitation, serv.getById(stubCitation.getId()));
    }

    @Test
    public void getByListOfIDsReturnsCorrectCitations() {
        List<Integer> IDs = new ArrayList();
        List<Citation> expecteds = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Citation stub = new CitationStub();
            IDs.add(stub.getId());
            expecteds.add(stub);
            serv.insert(stub);
        }
        assertEquals(expecteds, serv.getCitationsByListOfIds(IDs));
    }

    @Test
    public void getByListOfIDsDoesntReturnExtraCitations() {
        List<Integer> IDs = new ArrayList();
        List<Citation> expecteds = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Citation stub = new CitationStub();
            IDs.add(stub.getId());
            expecteds.add(stub);
            serv.insert(stub);
        }
        for (int i = 0; i < 10; i++) {
            Citation stub = new CitationStub();
            serv.insert(stub);
        }
        assertEquals(expecteds, serv.getCitationsByListOfIds(IDs));
    }
}
