import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
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

        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class=\"n-filter-panel-aside__content\"]/div[4]//span[@class=\"checkbox__box\"]"));

//        checkboxes.get(3).click();

        if (checkboxes.size() == 12) System.out.println("It's okay!");
        else System.out.println("FAIL!");

        for (WebElement checkbox : checkboxes){
            checkbox.click();
        }

    }
}
