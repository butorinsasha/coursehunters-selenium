package lesson049tables;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTest {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(960, 1040));
//        driver.manage().window().setSize(new Dimension(800, 900));
    }

    @Test
    public void testTable() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
         WebElement tableElement = driver.findElement(By.xpath("//table[@id=\"customers\"]"));

         Table table = new Table(tableElement, driver);
         Assert.assertEquals("Six rows in a table", 6, table.getRows().size());

         Assert.assertEquals("Cell at 2nd row and 3rd column is 'Mexico'", "Mexico", table.getValueFromCell(2,3));
         Assert.assertEquals("Cell at 4th row and 1st column is 'Island Trading'", "Island Trading", table.getValueFromCell(4,1));

         Assert.assertEquals("Cell at 4th row and header 'Company' is 'Island Trading'", "Island Trading", table.getValueFromCell(4, "Company"));
         Assert.assertEquals("Cell at 1st row and header 'Country' is 'Germany'", "Germany", table.getValueFromCell(1, "Country"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
