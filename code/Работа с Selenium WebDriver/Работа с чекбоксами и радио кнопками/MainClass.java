import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\student\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://market.yandex.ru/");

        driver.findElement(By.xpath("//a[text()='Бытовая техника']")).click();
        driver.findElement(By.xpath("//a[text()='Стиральные машины']")).click();

        selectCheckBox("ATLANT");
        selectCheckBox("Bosch");
        selectCheckBox("Candy");

        deselectCheckBox("Bosch");

//        System.out.println();
//
//        System.out.println(driver.findElement(By.xpath("//label[text()='Самовывоз']/span/input")).isSelected());
//        driver.findElement(By.xpath("//label[text()='Самовывоз']/span")).click();
//        System.out.println(driver.findElement(By.xpath("//label[text()='Самовывоз']/span/input")).isSelected());
//        driver.findElement(By.xpath("//label[text()='С доставкой']/span")).click();
//        driver.quit();
    }

    public static void selectCheckBox(String name){
        String rbXpath = "//label[text()='%s']/preceding-sibling::span";
        if (!driver.findElement(By.xpath(String.format(rbXpath, name) + "/input")).isSelected())
            driver.findElement(By.xpath(String.format(rbXpath, name))).click();
    }
    public static void deselectCheckBox(String name){
        String rbXpath = "//label[text()='%s']/preceding-sibling::span";
        if (driver.findElement(By.xpath(String.format(rbXpath, name) + "/input")).isSelected())
            driver.findElement(By.xpath(String.format(rbXpath, name))).click();
    }
}
