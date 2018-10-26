package lesson057presenceofelement;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class    WebElementPresenceVerifierTest {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse ;
    Actions actions;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 5);
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @Test
    public void testPresenceOfElementByFindElementsSizeListIsGreaterThanZero() {
        driver.get("https://github.com/");

        String signInXpath = "//a[text()=\"Sign in\"]";
        String logInXpath = "//a[text()=\"Login in\"]";

//        boolean isPresent;
//
//        isPresent = driver.findElements(By.xpath(signInXpath)).size() > 0;
//        System.out.println(isPresent);
//        Assert.assertTrue(isPresent);
//
//        isPresent = driver.findElements(By.xpath(logInXpath)).size() > 0;
//        System.out.println(isPresent);
//        Assert.assertFalse(isPresent);

        boolean isPresent;

        isPresent = ElementPresenceVerifier.isPresentByFindElementsSizeListIsGreaterThanZero(driver, By.xpath(signInXpath));
        System.out.println(isPresent);
        Assert.assertTrue(isPresent);

        isPresent =  ElementPresenceVerifier.isPresentByFindElementsSizeListIsGreaterThanZero(driver, By.xpath(logInXpath));
        System.out.println(isPresent);
        Assert.assertFalse(isPresent);

    }


    @Test
    public void testPresenceOfElementByNoSuchElementExceptionHandling() {
        driver.get("https://github.com/");

        String signInXpath = "//a[text()=\"Sign in\"]";
        String logInXpath = "//a[text()=\"Login in\"]";

        boolean isPresent;

        isPresent = ElementPresenceVerifier.isPresentByNoSuchElementExceptionHandling(driver, By.xpath(signInXpath));
        System.out.println(isPresent);
        Assert.assertTrue(isPresent);

        isPresent =  ElementPresenceVerifier.isPresentByNoSuchElementExceptionHandling(driver, By.xpath(logInXpath));
        System.out.println(isPresent);
        Assert.assertFalse(isPresent);
    }

    @Test
    public void testPresenceOfElementByPresenceOfElementLocated() {
        driver.get("https://github.com/");

        String signInXpath = "//a[text()=\"Sign in\"]";
        String logInXpath = "//a[text()=\"Login in\"]";

        boolean isPresent;

        isPresent = ElementPresenceVerifier.isPresentByPresenceOfElementLocated(driver,wait, By.xpath(signInXpath));
        System.out.println(isPresent);
        Assert.assertTrue(isPresent);

        isPresent =  ElementPresenceVerifier.isPresentByPresenceOfElementLocated(driver, wait, By.xpath(logInXpath));
        System.out.println(isPresent);
        Assert.assertFalse(isPresent);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
