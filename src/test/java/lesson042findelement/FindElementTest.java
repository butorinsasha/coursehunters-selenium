package lesson042findelement;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindElementTest {
    WebDriver driver;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(900, 500));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //    @Ignore("Ignored is just for testing")
    @Test
    public void findElementByDifferentWays() {
        driver.get("https://en.wikipedia.org"); //same as driver.navigate.to()
        System.out.println(driver.getCurrentUrl());
        WebElement link1 = driver.findElement(By.linkText("Log in"));
        WebElement link2 = driver.findElement(By.partialLinkText("Donate"));


//        System.out.println(driver.getCurrentUrl());
//        driver.navigate().to("https://www.wikipedia.org/");  // same as driver.get()
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        Assert.assertEquals("Wikipedia", driver.getTitle());
//        Assert.assertEquals("https://www.wikipedia.org/", driver.getCurrentUrl());
//        Assert.assertTrue(driver.getCurrentUrl().contains("wikipedia.org"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
