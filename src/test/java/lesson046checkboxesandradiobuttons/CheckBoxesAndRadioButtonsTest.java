package lesson046checkboxesandradiobuttons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxesAndRadioButtonsTest {

    WebDriver driver;

    public void selectCheckBox(String checkBoxName) {
        String checkBoxXpath = "//*[text()=\"%s\"]";
        WebElement checkBox = driver.findElement(By.xpath(String.format(checkBoxXpath, checkBoxName)));
        if (!driver.findElement(By.xpath(checkBoxXpath + "/../../input")).isSelected()) {
            checkBox.click();
        }
    }

    public void deselectCheckBox(String checkBoxName) {
        String checkBoxXpath = "//*[text()=\"%s\"]";
        WebElement checkBox = driver.findElement(By.xpath(String.format(checkBoxXpath, checkBoxName)));
        if (driver.findElement(By.xpath(checkBoxXpath + "/../../input")).isSelected()) {
            checkBox.click();
        }
    }


    @Before
    public void setUp() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(800, 900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void selectCheckBoxesAndRadioButtons() {
        driver.get("https://market.yandex.ru/");
        driver.findElement(By.xpath("//a[text()=\"Электроника\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Бытовая техника\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Стиральные машины\"]")).click();

        selectCheckBox("ATLANT");
        selectCheckBox("Candy");
        selectCheckBox("Electrolux");
        selectCheckBox("Electrolux");
        deselectCheckBox("Candy");

    }

//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
}
