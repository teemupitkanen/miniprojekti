import com.ohtu.miniprojektiv2.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'user can tag citations'

scenario 'user can create a new tag with valid tagname for a citation',{
    given 'user is viewing a citation',{
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
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
        element.submit();
    }
    then 'a new tag is created and associated with the citation',{
        driver.getPageSource().contains("newtag").shouldBe true
    }
}
scenario 'user cannot create a tag with an empty name',{
    given 'user is viewing a citation',{
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
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
    when 'user tries to submit a new tag with no name',{
        element = driver.findElement(By.name("tagName"));;
        element.submit();
    }
    then 'no new tag is created',{
        driver.getPageSource().contains("viewtag").shouldBe true
    }
}
scenario 'user cannot create two tags with identical names',{
    given 'user is viewing a citation associated with a tag',{
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
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
        element = driver.findElement(By.name("tagName"));
        element.sendKeys("newtag");
        element.submit();
    }
    when 'user tries to create a new tag with the same name',{
        element = driver.findElement(By.name("tagName"));
        element.sendKeys("newtag");
        element.submit();
    }
    then 'no new tag is created',{
    driver.getPageSource().contains("").shouldBe true
    }
}
scenario 'user can tag citations with previously created tags',{
    given 'user has previously created a tag to a citation and is now viewing another citation',{
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
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

        element = driver.findElement(By.name("tagName"));
        element.sendKeys("newtag");
        element.submit();

        driver.get("http://localhost:8090/new");
	select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("jaakko esimerkki");

        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foofoo");

        element = driver.findElement(By.name("fields['publisher']"));
        element.sendKeys("barbar");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2013");

        element.submit();
        
        element = driver.findElements(By.linkText("view")).get(1);
        element.click();
    }
    when 'user selects the tag in the drop-down menu',{
	Select select = new Select(driver.findElement(By.name("tagId")));
	select.selectByVisibleText("newtag");
	element = driver.findElement(By.id("tagwithexisting"));
	element.submit();
    }
    then 'the citation is tagged',{
    driver.getPageSource().contains("newtag</a>").shouldBe true
    }
}
