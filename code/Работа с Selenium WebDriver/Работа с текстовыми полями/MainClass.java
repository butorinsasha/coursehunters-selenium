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
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium WebDriver");
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='searchText']/input")).getAttribute("value"));
        driver.findElement(By.xpath("//div[@id='searchText']/input")).clear();

        driver.get("http://github.com");
        driver.findElement(By.xpath(".//*[@id='user[login]']")).sendKeys("testusername");
        driver.findElement(By.xpath(".//*[@id='user[password]']")).sendKeys("testpass");
        WebElement button = driver.findElement(By.xpath("//form[@class='home-hero-signup js-signup-form']//button"));
        button.submit();
//        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
//
        driver.get("http://en-gb.facebook.com");
        driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("testmail");
        driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("testpass");
        driver.findElement(By.xpath("//label[@id='loginbutton']/input")).submit();
        System.out.println("Mail is: " + driver.findElement(By.xpath(".//*[@id='email']")).getAttribute("value"));;


//        driver.quit();

    }
}
