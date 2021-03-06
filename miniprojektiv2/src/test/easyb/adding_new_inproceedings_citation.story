import com.ohtu.miniprojektiv2.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import System.out.*;

description 'user can add inproceedings citation'

scenario "user can add inproceedings citation with correct entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/listAll");
        lkm = driver.findElements(By.linkText("view")).size();
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'valid citation entries are given', {
        element = driver.findElement(By.name("citeId"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("qwerty");

        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("fields['booktitle']"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");

        element.submit();
    }
    then 'user can add new citation', {
	element = driver.findElements(By.linkText("view")).get(lkm);
	element.click();
	driver.getPageSource().contains("author").shouldBe true
        driver.getPageSource().contains("qwerty").shouldBe true
	driver.getPageSource().contains("title").shouldBe true
	driver.getPageSource().contains("foo").shouldBe true
	driver.getPageSource().contains("booktitle").shouldBe true
	driver.getPageSource().contains("bar").shouldBe true
	driver.getPageSource().contains("year").shouldBe true
        driver.getPageSource().contains("2014").shouldBe true
    }
}

scenario "user can add inproceedings citation with correct extra entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/listAll");
        lkm = driver.findElements(By.linkText("view")).size();
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'valid citation entries with correct extra entries are given', {
        element = driver.findElement(By.name("citeId"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("testaaja");

        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("fields['booktitle']"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2010");

        element = driver.findElement(By.name("fields['editor']"));
        element.sendKeys("buzz");

        element = driver.findElement(By.name("fields['volumeNumber']"));
        element.sendKeys("12");

        element = driver.findElement(By.name("fields['series']"));
        element.sendKeys("5");

        element = driver.findElement(By.name("fields['pages']"));
        element.sendKeys("10");

        element = driver.findElement(By.name("fields['month']"));
        element.sendKeys("3");

        element = driver.findElement(By.name("fields['organization']"));
        element.sendKeys("jee");

        element = driver.findElement(By.name("fields['publisher']"));
        element.sendKeys("testi");

        element = driver.findElement(By.name("fields['note']"));
        element.sendKeys("noottia");

        element = driver.findElement(By.name("fields['key']"));
        element.sendKeys("asdf");

        element.submit();
    }
    then 'user can add new citation', {
        element = driver.findElements(By.linkText("view")).get(lkm);
        element.click();
	driver.getPageSource().contains("author").shouldBe true
        driver.getPageSource().contains("testaaja").shouldBe true

	driver.getPageSource().contains("title").shouldBe true
	driver.getPageSource().contains("foo").shouldBe true

	driver.getPageSource().contains("booktitle").shouldBe true
	driver.getPageSource().contains("bar").shouldBe true

	driver.getPageSource().contains("year").shouldBe true
        driver.getPageSource().contains("2010").shouldBe true

	driver.getPageSource().contains("editor").shouldBe true
        driver.getPageSource().contains("buzz").shouldBe true

	driver.getPageSource().contains("volumeNumber").shouldBe true
        driver.getPageSource().contains("12").shouldBe true

	driver.getPageSource().contains("series").shouldBe true
        driver.getPageSource().contains("5").shouldBe true

	driver.getPageSource().contains("pages").shouldBe true
        driver.getPageSource().contains("10").shouldBe true

	driver.getPageSource().contains("month").shouldBe true
        driver.getPageSource().contains("3").shouldBe true

	driver.getPageSource().contains("organization").shouldBe true
        driver.getPageSource().contains("jee").shouldBe true

	driver.getPageSource().contains("publisher").shouldBe true
        driver.getPageSource().contains("testi").shouldBe true

	driver.getPageSource().contains("note").shouldBe true
        driver.getPageSource().contains("noottia").shouldBe true

	driver.getPageSource().contains("key").shouldBe true
        driver.getPageSource().contains("asdf").shouldBe true
    }
}

scenario "user can not add inproceedings citation with incorrect year", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'incorrect year and other correct entries are given', {
        element = driver.findElement(By.name("citeId"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("fields['booktitle']"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("karambola");

        element.submit();
    }
    then 'user can not add citation', {
        driver.getPageSource().contains("Select citation type").shouldBe true
    }
}

scenario "user can not add inproceedings citation with empty entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'no entries are given', {
        element = driver.findElement(By.name("fields['author']"));
        element.submit();
    }
    then 'user can not add citation', {
        driver.getPageSource().contains("Select citation type").shouldBe true
    }
}

scenario "user can not add inproceedings citation without given id", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'valid citation entries are given', {
        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("qwerty");

        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("fields['booktitle']"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");

        element.submit();
    }
    then 'user can add new citation', {
	driver.getPageSource().contains("Select citation type").shouldBe true
    }
}

scenario "user can not add inproceedings citation with missing required entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("inproceedings");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'valid citation entries are given', {
        element = driver.findElement(By.name("citeId"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("qwerty");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");

        element.submit();
    }
    then 'user can add new citation', {
	driver.getPageSource().contains("Select citation type").shouldBe true
    }
}
