
package com.ohtu.miniprojektiv2.controller;

import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Tests for HomeController.
 * 
 */
public class HomeControllerTest {
    WebDriver driver;
    
    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
    }
    
    @Test
    public void viewNewIsShownWhenLinkIsClicked() throws InterruptedException {
        driver.get("http://localhost:8090/new");
        WebElement element = driver.findElement(By.name("author"));
        element.sendKeys("erkki esimerkki");

        element = driver.findElement(By.name("title"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("year"));
        element.sendKeys("2014");

        element.submit();
        assertTrue(driver.getPageSource().contains("foo"));
    }
   
}
