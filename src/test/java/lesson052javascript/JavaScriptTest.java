package lesson052javascript;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class JavaScriptTest {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor jse;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(960, 1040));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wait = new WebDriverWait (driver, 5);
        actions = new Actions(driver);
        jse = (JavascriptExecutor)driver;
    }

    @Test
    public void testJavaScriptAlert() {
        driver.get("https://en.wikipedia.org");
        jse.executeScript("alert('Hello, World!');");
    }

    @Test
    public void testPageScrolling() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://en.wikipedia.org");
        jse.executeScript("window.scrollBy(0, 1000);");
        jse.executeScript("window.scrollBy(0, -900);");
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
