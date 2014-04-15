import com.ohtu.miniprojektiv2.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'user can tag citations'

scenario "user can create new tag for added cite", {
    given 'new citation is added', {
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

        element = driver.findElement(By.linkText("view"));
        element.click();
    }
    when 'user chooses to add a new tag', {
        element = driver.findElement(By.name("tagName"));
        element.sendKeys("newtag");
    }
    then 'user can see page containing tag', {
        driver.getPageSource().contains("newtag").shouldBe true
    }


}
scenario "user can add existing tag to citation", {
    given 'new citations are added', {

    }
    when 'user chooses to add an existing tag', {

    }
    then 'user can see page containing tag', {

    }


}
scenario "user can list tags citations", {
    given 'new citations are added for tag', {

    }
    when 'user chooses to view a tag', {

    }
    then 'user can see a list of citations', {

    }


}