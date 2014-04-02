import com.ohtu.miniprojektiv2.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'user can list citations in human readable form'

scenario "user can list added citations", {
    given 'add new citation selected with correct entries', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
    }
    when 'citation adding has succeeded', {
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
    then 'user can see added citation', {
        driver.getPageSource().contains("foo").shouldBe true
    }
}
scenario "user can list empty list of citation", {
    given 'front page selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
    }
    when 'no citations are added', {
        
    }
    then 'user can not see any citations listed', {
        driver.getPageSource().contains("view").shouldBe false
    }
}