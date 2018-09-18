package lesson053alert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AlertTest {

    WebDriver driver;
    JavascriptExecutor jse;
    WebDriverWait wait;
    Actions actions;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(960, 1040));
//        driver.manage().window().setPosition(new Point(0, 0));

//        driver.manage().window().setSize(new Dimension(900, 500));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wait = new WebDriverWait (driver, 5);
        actions = new Actions(driver);
        jse = (JavascriptExecutor)driver;

    }


    @Test
    public void testAcceptingAlert() {

        driver.navigate().to("https://google.com");
        driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");

        WebElement link = driver.findElement(By.xpath("//a[text()=\"jdk-8u181-windows-x64.exe\"]"));
//        link.click();
        Action act = actions.click(link).build();
        act.perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().accept();
    }

    @Test
    public void testDismissAlert() {
        driver.get("http://google.com");
        jse.executeScript("confirm('Are you sure');");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().dismiss();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}