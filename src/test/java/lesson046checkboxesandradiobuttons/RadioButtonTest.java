package lesson046checkboxesandradiobuttons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtonTest {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(0,0));

        driver.manage().window().setSize(new Dimension(960, 1040));

//        driver.manage().window().setSize(new Dimension(800, 900));
//        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Maximum period of time driver will wait until it finds specific WebElement

    }

    @Test
    public void name() {

        driver.get("https://market.yandex.ru/");
        driver.findElement(By.xpath("//a[text()=\"Электроника\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Бытовая техника\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Стиральные машины\"]")).click();

        driver.findElement(By.xpath("//span[text()=\"С доставкой\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Самовывоз\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Любой\"]")).click();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
