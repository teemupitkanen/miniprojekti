
package com.ohtu.miniprojektiv2.controller;

import org.springframework.test.web.server.MockMvc;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tests for HomeController.
 * 
 */
public class HomeControllerTest {
    
    MockMvc mockMvc;
    
    @BeforeClass
    public void setUp() {
        // code that will be invoked before this test starts
    }
    
    @Test
    public void aTest() {
        System.out.println("Test");
    }
    
    @AfterClass
    public void cleanUp() {
        // code that will be invoked after this test ends
    }
}
