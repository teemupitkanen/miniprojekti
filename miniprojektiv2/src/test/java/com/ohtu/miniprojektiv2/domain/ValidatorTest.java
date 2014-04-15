/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ohtu.miniprojektiv2.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class ValidatorTest {

    private Citation testCitation;

    public ValidatorTest() {
    }

    @Before
    public void setUp() {
        testCitation = new Citation();
        testCitation.setCiteType(CitationType.INPROCEEDINGS);
        testCitation.setCiteId("ide");
        testCitation.setField("year", "1999");
        testCitation.setField("author", "Mauri");
        testCitation.setField("title", "Title");
        testCitation.setField("booktitle", "Booktitle");
    }

    @Test
    public void validCitationHasNoErrors() {
        assertFalse(Validator.checkForErrors(testCitation));
    }

    @Test
    public void emptyCiteIDcausesError() {
        testCitation.setCiteId(null);
        assertTrue(Validator.checkForErrors(testCitation));
        testCitation.setCiteId("");
        assertTrue(Validator.checkForErrors(testCitation));
    }

    @Test
    public void badYearCausesError() {
        testCitation.setField("year", "this is not a valid year lol");
        assertTrue(Validator.checkForErrors(testCitation));
        testCitation.setField("year", "-2433");
        assertTrue(Validator.checkForErrors(testCitation));
    }

    @Test
    public void anyEmptyMandatoryFieldCausesError() {
        testCitation.setField("author", "");
        assertTrue(Validator.checkForErrors(testCitation));
    }
}
