package lesson057presenceofelement;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementPresenceVerifierTest {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;
    Actions actions;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @Test
    public void testPresenceOfElementByFindElementsSizeListIsGreaterThanZero() {
        driver.navigate().to("https://github.com/");

        String aSigninXpath = "//a[text()=\"Sign in\"]";
        String aLoginXpath = "//a[text()=\"Login in\"]";

        boolean isPresent;

        isPresent = driver.findElements(By.xpath(aSigninXpath)).size() > 0;
        System.out.println(isPresent);
        Assert.assertTrue(isPresent);

        isPresent = driver.findElements(By.xpath(aLoginXpath)).size() > 0;
        System.out.println(isPresent);
        Assert.assertFalse(isPresent);

    }


    @Test
    public void testPresenceOfElementByNoSuchElementExceptionHandling() {
        driver.get("https://github.com/");

        String aSigninXpath = "//a[text()=\"Sign in\"]";
        String aLoginXpath = "//a[text()=\"Login in\"]";


    }

    @Test
    public void testPresenceOfElementByPresenceOfElementLocated() {

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
