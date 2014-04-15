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
public class IntegerFactoryTest {

    public IntegerFactoryTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void next() {
        int a = IntegerFactory.next();
        int b = IntegerFactory.next();
        assertTrue(b - a == 1);
    }

    @Test
    public void reset() {
        IntegerFactory.reset();
        int a = IntegerFactory.next();
        int b = IntegerFactory.reset();
        int c = IntegerFactory.next();
        assertTrue(a == 0 && c == 0 && b == 0);
    }
}
