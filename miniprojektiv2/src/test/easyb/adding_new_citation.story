import com.ohtu.miniprojektiv2.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'user can add inproceedings citation'

scenario "user can add inproceedings citation with correct entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
    }
    when 'valid citation entries are given', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("erkki esimerkki");

        element = driver.findElement(By.name("title"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("year"));
        element.sendKeys("2014");

        element.submit();
    }
    then 'user can add new citation', {
        driver.getPageSource().contains("foo").shouldBe true
    }
}

scenario "user can add inproceedings citation with correct extra entries", {
    given 'add new citation selected';
    when 'valid citation entries with correct extra entries are given';
    then 'user can add new citation';
}

scenario "user can not add inproceedins citation with incorrect year", {
    given 'add new citation selected';
    when 'incorrect year and other correct entries are given';
    then 'user can not add citation';
}

scenario "user can not add inproceedins citation with empty entries", {
    given 'add new citation selected';
    when 'no entries are given';
    then 'user can not add citation';
}