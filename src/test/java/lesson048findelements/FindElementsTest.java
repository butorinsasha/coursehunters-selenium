package lesson048findelements;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class FindElementsTest {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(960, 1040));
//        driver.manage().window().setSize(new Dimension(800, 900));
    }

    @Test
    public void findElementsAndSaveThemIntoArrayList() {
        driver.get("https://market.yandex.ru/");
        driver.findElement(By.xpath("//a[text()=\"Электроника\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Бытовая техника\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Стиральные машины\"]")).click();

        String checkboxesXpath = "//fieldset[@data-autotest-id=\"7893318\"]//span[@class=\"NVoaOvqe58\"]";
        List<WebElement> checkboxes = driver.findElements(By.xpath(checkboxesXpath));
        checkboxes.get(3).click(); // !? How do we can access get() method without defining an implementation of List interface !?
        System.out.println(checkboxes.getClass());
        Assert.assertEquals(12, checkboxes.size());

        // Random ticking of the checkboxes
        for (WebElement checkbox : checkboxes) {
            if (new Random().nextBoolean()) {
                checkbox.click();
            }
        }

        //Counting how much of the checkboxes are selected ofter random ticking
        int tickedCheckboxCounter = 0;
        for (WebElement checkbox : checkboxes) {
//            if (checkbox.findElement(By.xpath("./../../input")).isSelected()) {
            if (checkbox.findElement(By.xpath("../../input")).isSelected()) {
                tickedCheckboxCounter++;
            }
        }
        System.out.println(tickedCheckboxCounter);
    }


    @After
    public void tearDown() throws Exception {
//        driver.quit();
    }
}
