import com.ohtu.miniprojektiv2.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'user can add other citations'

scenario "user can add book citation with required entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/listAll");
        lkm = driver.findElements(By.linkText("view")).size();
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("book");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'valid citation entries are given', {
        element = driver.findElement(By.name("citeId"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("harrharr");

        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("fields['publisher']"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");

        element.submit();
    }
    then 'user can add new citation', {
	element = driver.findElements(By.linkText("view")).get(lkm);
	element.click();
	driver.getPageSource().contains("harrharr").shouldBe true
	driver.getPageSource().contains("foo").shouldBe true
	driver.getPageSource().contains("bar").shouldBe true
        driver.getPageSource().contains("2014").shouldBe true
    }
}

scenario "user can add book citation with all possible entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/listAll");
        lkm = driver.findElements(By.linkText("view")).size();
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("book");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'valid citation entries are given', {
        element = driver.findElement(By.name("citeId"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("tyuio");

        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("fields['publisher']"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");

	element = driver.findElement(By.name("fields['volume']"));
        element.sendKeys("2");

        element = driver.findElement(By.name("fields['series']"));
        element.sendKeys("qwerty");

        element = driver.findElement(By.name("fields['address']"));
        element.sendKeys("kumpula");

        element = driver.findElement(By.name("fields['edition']"));
        element.sendKeys("3rd");
	
	element = driver.findElement(By.name("fields['month']"));
        element.sendKeys("8");

        element = driver.findElement(By.name("fields['note']"));
        element.sendKeys("fizz");

        element = driver.findElement(By.name("fields['key']"));
        element.sendKeys("buzz");

        element.submit();
    }
    then 'user can add new citation', {
	element = driver.findElements(By.linkText("view")).get(lkm);
	element.click();
        driver.getPageSource().contains("tyuio").shouldBe true
	driver.getPageSource().contains("foo").shouldBe true
	driver.getPageSource().contains("bar").shouldBe true
        driver.getPageSource().contains("2014").shouldBe true
	driver.getPageSource().contains("2").shouldBe true
	driver.getPageSource().contains("qwerty").shouldBe true
	driver.getPageSource().contains("kumpula").shouldBe true
        driver.getPageSource().contains("3rd").shouldBe true
	driver.getPageSource().contains("8").shouldBe true
	driver.getPageSource().contains("fizz").shouldBe true
	driver.getPageSource().contains("buzz").shouldBe true
    }
}

scenario "user can not add book citations with missing required entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("book");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'valid citation entries are given', {
        element = driver.findElement(By.name("citeId"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("harrharr");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");

        element.submit();
    }
    then 'user can add new citation', {
	driver.getPageSource().contains("Select citation type").shouldBe true
    }
}

scenario "user can add article citation with required entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/listAll");
        lkm = driver.findElements(By.linkText("view")).size();
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("article");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'valid citation entries are given', {
        element = driver.findElement(By.name("citeId"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("zxcv");

        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("fields['journal']"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");

        element.submit();
    }
    then 'user can add new citation', {
	element = driver.findElements(By.linkText("view")).get(lkm);
	element.click();
        driver.getPageSource().contains("zxcv").shouldBe true
	driver.getPageSource().contains("foo").shouldBe true
	driver.getPageSource().contains("bar").shouldBe true
        driver.getPageSource().contains("2014").shouldBe true
    }
}

scenario "user can add article citation with all possible entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/listAll");
        lkm = driver.findElements(By.linkText("view")).size();
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("article");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'valid citation entries are given', {
        element = driver.findElement(By.name("citeId"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("fdhfhdf");

        element = driver.findElement(By.name("fields['title']"));
        element.sendKeys("foo");

        element = driver.findElement(By.name("fields['journal']"));
        element.sendKeys("bar");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");

	element = driver.findElement(By.name("fields['volume']"));
        element.sendKeys("14");

        element = driver.findElement(By.name("fields['number']"));
        element.sendKeys("3");

        element = driver.findElement(By.name("fields['pages']"));
        element.sendKeys("17");
	
	element = driver.findElement(By.name("fields['month']"));
        element.sendKeys("2");

        element = driver.findElement(By.name("fields['note']"));
        element.sendKeys("fizz");

        element = driver.findElement(By.name("fields['key']"));
        element.sendKeys("buzz");

        element.submit();
    }
    then 'user can add new citation', {
	element = driver.findElements(By.linkText("view")).get(lkm);
	element.click();
        driver.getPageSource().contains("fdhfhdf").shouldBe true
	driver.getPageSource().contains("foo").shouldBe true
	driver.getPageSource().contains("bar").shouldBe true
        driver.getPageSource().contains("2014").shouldBe true
	driver.getPageSource().contains("14").shouldBe true
	driver.getPageSource().contains("3").shouldBe true
	driver.getPageSource().contains("17").shouldBe true
        driver.getPageSource().contains("2").shouldBe true
	driver.getPageSource().contains("fizz").shouldBe true
	driver.getPageSource().contains("buzz").shouldBe true
    }
}

scenario "user can not add article citation with missing required entries", {
    given 'add new citation selected', {
        driver = new HtmlUnitDriver()
        driver.get("http://localhost:8090/new");
	Select select = new Select(driver.findElement(By.name("citationType")));
	select.selectByVisibleText("book");
	element = driver.findElement(By.name("citationType"));
	element.submit();
    }
    when 'valid citation entries are given', {
        element = driver.findElement(By.name("citeId"));
        element.sendKeys("test");

        element = driver.findElement(By.name("fields['author']"));
        element.sendKeys("harrharr");

        element = driver.findElement(By.name("fields['year']"));
        element.sendKeys("2014");

        element.submit();
    }
    then 'user can add new citation', {
	driver.getPageSource().contains("Select citation type").shouldBe true
    }
}
