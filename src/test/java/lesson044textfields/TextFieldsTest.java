package lesson044textfields;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TextFieldsTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(960, 1080));
        driver.manage().window().setPosition(new Point(0, 0));
//        driver.manage().window().maximize();
    }

    @Test
    public void fillTextFileds() throws InterruptedException {
//        driver.get("https://en.wikipedia.org");
//        driver.findElement(By.xpath("//input[@id=\"searchInput\"]")).sendKeys("Selenium Webdriver");
//        driver.findElement(By.xpath("//input[@id=\"searchButton\"]")).click();
//        System.out.println(driver.findElement(By.xpath("//div[@id=\"searchText\"]/input")).getAttribute("value"));
//        driver.findElement(By.xpath("//div[@id=\"searchText\"]/input")).clear();
//
//
//        driver.navigate().to("https://github.com/");
//        driver.findElement(By.xpath("//*[@id=\"user[login]\"]")).sendKeys("testusername");
//        driver.findElement(By.xpath("//*[@id=\"user[password]\"]")).sendKeys("testpass");
//        WebElement button = driver.findElement(By.xpath("//form[@class=\"home-hero-signup js-signup-form\"]//button"));
//        button.submit();


        driver.navigate().to("https://www.facebook.com/");

        String wrongEmail = "butorinsasha@gmail.ru";
        String correctEmail = "butorinsasha@gmail.com";
        String wrongPass = "qweASD123";

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(wrongEmail);
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(wrongPass);
        driver.findElement(By.xpath("//label[@id=\"loginbutton\"]//input")).submit();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(correctEmail);
        System.out.println("Email is: " + driver.findElement(By.xpath("//*[@id=\"email\"]")).getAttribute("value"));
        Assert.assertEquals(correctEmail, driver.findElement(By.xpath("//*[@id=\"email\"]")).getAttribute("value"));
        Assert.assertEquals("", driver.findElement(By.xpath("//*[@id=\"pass\"]")).getAttribute("value"));
        Assert.assertEquals("Sign up for Facebook", driver.findElement(By.xpath("//a[@id=\"reg-link\"]")).getText());
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
