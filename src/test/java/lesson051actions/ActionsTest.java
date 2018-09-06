package lesson051actions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsTest {

    WebDriver driver;

    WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(960, 1040));
        //        driver.manage().window().setSize(new Dimension(800, 900));

    }

    @Test
    public void testActions() {
        driver.get("https://www.ebay.com/");
        WebElement link = driver.findElement(By.xpath("//tr[@role=\"list\"]//a[contains(text(), \"Электроника\")]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(link).build().perform();
    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
    }
}
