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
public class TagTest {

    @Before
    public void setUp() {
    }

    @Test
    public void isConstructedWithName() {
        Tag r = new Tag("Science");
        assertEquals("Science", r.getName());
    }
    
}
