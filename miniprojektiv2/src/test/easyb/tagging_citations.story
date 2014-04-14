import com.ohtu.miniprojektiv2.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'user can tag citations'

scenario 'user can create a new tag with valid tagname for a citation',{
    given 'user is viewing a citation',{
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("erkki esimerkki");

        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("fields['publisher']"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");

        element.submit();
        
        element = driver.findElement(By.linkText("view"));
        element.click();
        
    }
    when 'user fills in an appropriate tagname',{
        element = driver.findElement(By.name("tagName"));
        element.sendKeys("newtag");
        element.submit;
    }
    then 'a new tag is created and associated with the citation',{
        driver.getPageSource().contains("newtag").shouldBe true
    }
}
scenario 'user cannot create a tag with an empty name'
scenario 'user cannot create two tags with idnetical names'
scenario 'user can tag citations with previously created tags'