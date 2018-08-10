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
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        WebElement donateLink = driver.findElement(By.partialLinkText("Donate"));
        WebElement searchInput = driver.findElement(By.name("search"));
        WebElement searchButton = driver.findElement(By.className("searchButton"));
        WebElement byId = driver.findElement(By.id("ca-viewsource"));
        WebElement byTagName = driver.findElement(By.tagName("input")); // returns first <input> tag
        WebElement byCssSelector = driver.findElement(By.cssSelector("div#p-namespaces > h3"));
        WebElement byXpath= driver.findElement(By.xpath("//div[@id=\"mw-panel\"]/div[@id=\"p-logo\"]"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
