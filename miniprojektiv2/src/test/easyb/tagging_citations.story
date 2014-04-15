import com.ohtu.miniprojektiv2.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'user can tag citations'

scenario "user can list tags citations", {
    given 'new citations are added for tag', {
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

        element = driver.findElement(By.name("tagName"));
        element.sendKeys("newtag");
        element.submit();
    }
    when 'user chooses to view a tag', {
        element = driver.findElement(By.linkText("newtag"));
        element.click();
    }
    then 'user can see a list of citations', {
        driver.getPageSource().contains("Citations tagged with newtag:").shouldBe true
    }


}