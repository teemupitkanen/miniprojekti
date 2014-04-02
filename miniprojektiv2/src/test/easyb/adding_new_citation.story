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
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
    }
    when 'valid citation entries with correct extra entries are given', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("erkki esimerkki");

        element = driver.findElement(By.name("title"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("year"));
        element.sendKeys("2014");

        element = driver.findElement(By.name("editor"));
        element.sendKeys("buzz");

        element = driver.findElement(By.name("volumeNumber"));
        element.sendKeys("buzz");

        element = driver.findElement(By.name("series"));
        element.sendKeys("buzz");

        element = driver.findElement(By.name("pages"));
        element.sendKeys("buzz");

        element = driver.findElement(By.name("month"));
        element.sendKeys("buzz");

        element = driver.findElement(By.name("organization"));
        element.sendKeys("buzz");

        element = driver.findElement(By.name("publisher"));
        element.sendKeys("buzz");

        element = driver.findElement(By.name("note"));
        element.sendKeys("buzz");

        element = driver.findElement(By.name("key"));
        element.sendKeys("buzz");

        element.submit();
    }
    then 'user can add new citation', {
        driver.getPageSource().contains("foo").shouldBe true
    }
}

scenario "user can not add inproceedins citation with incorrect year", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
    }
    when 'incorrect year and other correct entries are given', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("erkki esimerkki");

        element = driver.findElement(By.name("title"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("year"));
        element.sendKeys("karambola");

        element.submit();
    }
    then 'user can not add citation', {
        driver.getPageSource().contains("must be between").shouldBe true
    }
}

scenario "user can not add inproceedins citation with empty entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
    }
    when 'no entries are given', {
        element = driver.findElement(By.name("author"));
        element.submit();
    }
    then 'user can not add citation', {
        driver.getPageSource().contains("may not be empty").shouldBe true
    }
}