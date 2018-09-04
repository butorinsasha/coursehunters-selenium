package lesson049tables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesTest {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(960, 1040));
//        driver.manage().window().setSize(new Dimension(800, 900));
    }

    @Test
    public void workWithTables() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
         WebElement tableElement = driver.findElement(By.id("//table[@id=\"customers\"]"));
    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
    }
}
