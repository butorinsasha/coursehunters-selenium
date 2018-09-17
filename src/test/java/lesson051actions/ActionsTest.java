package lesson051actions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActionsTest {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(960, 1040));
//        driver.manage().window().setSize(new Dimension(800, 900));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);

    }

    @Test
    public void testActionsMoveToElement() throws InterruptedException {
        driver.get("https://www.ebay.com/");

        WebElement link1 = driver.findElement(By.xpath("//tr[@role=\"list\"]//a[text()=\"Электроника\"]"));
        WebElement link2 = driver.findElement(By.xpath("//a[@title=\"Электроника - iPhone\"]"));

        actions.moveToElement(link1).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title=\"Электроника - iPhone\"]")));

//        Thread.sleep(1000);

//        actions.moveToElement(link2).build().perform();
//        actions.click(link2).build().perform();
        actions.moveToElement(link2).click(link2).build().perform();


//        Assert.assertEquals("iPhone 6S и 6S Plus ужездесь | eBay", driver.getTitle());

    }

    @Test
    public void testActionsDragAndDrop() {
        driver.get("https://www.ebay.com/");

        WebElement link1 = driver.findElement(By.xpath("//tr[@role=\"list\"]//a[text()=\"Электроника\"]"));
        WebElement element1 = driver.findElement(By.xpath("//tr[@role=\"list\"]//a[text()=\"Электроника\"]"));

        actions.dragAndDrop(element1, link1);

//        actions.clickAndHold(element1).moveToElement(element1).release().build().perform();
//        Action action = actions.clickAndHold(element1).moveToElement(element1).release().build();
//        action.perform();

        actions.doubleClick(element1);
        actions.contextClick(element1); // right button click
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
