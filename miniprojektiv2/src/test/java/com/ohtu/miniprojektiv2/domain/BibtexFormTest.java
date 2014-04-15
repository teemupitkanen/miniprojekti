/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ohtu.miniprojektiv2.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author 41407
 */
public class BibtexFormTest {

    @Test
    public void printingBibTexWorks() {
        Citation inp = new Citation();
        inp.setCiteType(CitationType.INPROCEEDINGS);
        inp.setCiteId("MAA95");
        inp.setField("author", "Ä");
        inp.setField("title", "Coding for Dummies");
        String expected = "@inproceedings{MAA95,<br>";
        expected += "author= {\\\"{A}},<br>";
        expected += "title= {Coding for Dummies},<br>";
        expected += "} <br>";
        assertEquals(expected, BibtexForm.getBibTexForm(inp));
    }

}
