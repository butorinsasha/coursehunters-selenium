package lesson046checkboxesandradiobuttons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxesTest {

    WebDriver driver;

    public void selectCheckBox(String checkBoxName) {
        String spanCheckBoxXpath = "//fieldset[@data-autotest-id=\"7893318\"]//span[text()=\"%s\"]";
        WebElement checkBox = driver.findElement(By.xpath(String.format(spanCheckBoxXpath, checkBoxName)));
        if (!driver.findElement(By.xpath(String.format(spanCheckBoxXpath, checkBoxName) + "/../../input")).isSelected()) {
            checkBox.click();
        }
    }

    public void deselectCheckBox(String checkBoxName) {
        String spanCheckBoxXpath = "//fieldset[@data-autotest-id=\"7893318\"]//span[text()=\"%s\"]";
        WebElement checkBox = driver.findElement(By.xpath(String.format(spanCheckBoxXpath, checkBoxName)));
        if (driver.findElement(By.xpath(String.format(spanCheckBoxXpath, checkBoxName) + "/../../input")).isSelected()) {
            checkBox.click();
        }
    }


    @Before
    public void setUp() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();

        driver.manage().window().setPosition(new Point(0,0));

        driver.manage().window().setSize(new Dimension(960, 1080));
//        driver.manage().window().setSize(new Dimension(800, 900));
//        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void selectCheckBoxes() {
        driver.get("https://market.yandex.ru/");
        driver.findElement(By.xpath("//a[text()=\"Электроника\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Бытовая техника\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Стиральные машины\"]")).click();

        selectCheckBox("ATLANT");
        selectCheckBox("Candy");
        selectCheckBox("Electrolux");
        selectCheckBox("Electrolux");
        deselectCheckBox("Candy");

        Assert.assertTrue(driver.findElement(By.xpath("//fieldset[@data-autotest-id=\"7893318\"]//span[text()=\"ATLANT\"]/../../input")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//fieldset[@data-autotest-id=\"7893318\"]//span[text()=\"Electrolux\"]/../../input")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//fieldset[@data-autotest-id=\"7893318\"]//span[text()=\"Candy\"]/../../input")).isSelected());

    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
    }
}
