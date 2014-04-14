import com.ohtu.miniprojektiv2.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'user can list all citations in bibtex format'

scenario "user can list inproceedings citation in bibtex format", {
    given 'inproceedings citation is added', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();

        element = driver.findElement(By.name("citeId"));
        element.sendKeys("ESIM123");
        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("erkki esimerkki");
        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foo");
        element = driver.findElement(By.name("fields['booktitle']"));
        element.sendKeys("bar");
        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");
        element.submit();
    }
    when 'user chooses to list citation in bibtex format', {
        element = driver.findElement(By.name("View citations in BibTeX format"));
        element.submit();
    }
    then 'user can see page containing citation in bibtex format', {
        driver.getPageSource().contains("@inproceedings{ESIM123,").shouldBe true
    }
}

scenario "user can list book citation in bibtex format", {
    given 'book citation is added', {
        
    }
    when 'user chooses to list citation in bibtex format', {
        
    }
    then 'user can see page containing citation in bibtex format', {
        
    }
}

scenario "user can list article citation in bibtex format", {
    given 'article citation is added', {
        
    }
    when 'user chooses to list citation in bibtex format', {
        
    }
    then 'user can see page containing citation in bibtex format', {
        
    }
}

scenario "user can list citation with special characters in bibtex format", {
    given 'citation with special characters is added', {
        
    }
    when 'user chooses to list citation in bibtex format', {
        
    }
    then 'user can see page containing citation in bibtex format', {
        
    }
}

scenario "user can list all citations in bibtex format", {
    given 'citations have been added', {
        
    }
    when 'user chooses to list citations in bibtex format', {
        
    }
    then 'user can see page containing citations in bibtex format', {
        
    }
}