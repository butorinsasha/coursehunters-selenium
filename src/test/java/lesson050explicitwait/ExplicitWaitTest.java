package lesson050explicitwait;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(960, 1040));
        //        driver.manage().window().setSize(new Dimension(800, 900));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Maximum period of time driver will wait until it finds specific WebElement

    }

    @Test
    public void name() {

    }

    @After
    public void tearDown() throws Exception {

    }
}
