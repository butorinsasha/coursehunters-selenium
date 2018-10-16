package lesson043buttons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ButtonsTest {

    WebDriver driver;
    WebDriver driver2;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(900,500));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setPosition(new Point(0,0));

    }

    @Test
    public void pushTheButtons() {
        driver.get("https://en.wikipedia.org");
        driver.findElement(By.xpath("//input[@id=\"searchButton\"]")).click();

        driver.navigate().to("http://github.com");
        WebElement button = driver.findElement(By.xpath("//form[@class=\"home-hero-signup js-signup-form\"]//button"));
        System.out.println("Button text is: " + button.getText());
        Assert.assertEquals("Sign up for GitHub", button.getText());
//        button.submit();
        driver.findElement(By.xpath("//a[text()=\"Sign in\"]")).click();


        driver.navigate().to("https://www.facebook.com/");
        driver.findElement(By.xpath("//label[@id=\"loginbutton\"]//input")).submit(); // public abstract void submit(): If this current element is a form-element, or an element within a form, then this will be submitted to the remote server.
    }

    @After
    public void tearTown() {
        driver.quit();
    }

}
