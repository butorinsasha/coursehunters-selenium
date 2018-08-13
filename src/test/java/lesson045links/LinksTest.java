package lesson045links;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LinksTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(960, 1080));
        driver.manage().window().maximize();
//        driver.manage().window().setPosition(new Point(0, 0));
    }

    @Test
    public void fillTextFileds() {
        driver.get("https://en.wikipedia.org");
        WebElement link = driver.findElement(By.xpath("//li[@id=\"n-aboutsite\"]/a"));
        System.out.println(link.getText());
        link.click();

        driver.get("https://github.com/");
        driver.findElement(By.xpath("//a[text()=\"Personal\"]")).click();
        System.out.println();
        Assert.assertTrue(driver.getCurrentUrl().contains("github.com/personal"));

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[text()=\"Forgotten account?\"]")).click();
        Assert.assertEquals("Forgotten Password | Can't Log In | Facebook", driver.getTitle());
    }

    /*@After
    public void tearDown() {
        driver.quit();
    }*/

}
