import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\student\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://en.wikipedia.org");

        WebElement link = driver.findElement(By.xpath("//li[@id='n-aboutsite']/a"));
        System.out.println(link.getText());
        link.click();

        driver.get("http://github.com");
        driver.findElement(By.xpath("//nav[@class='site-header-nav site-header-nav-main']/a[1]")).click();

        driver.get("http://en-gb.facebook.com");
        driver.findElement(By.xpath("//a[text()='Forgotten account?']")).click();


//        driver.quit();

    }
}
