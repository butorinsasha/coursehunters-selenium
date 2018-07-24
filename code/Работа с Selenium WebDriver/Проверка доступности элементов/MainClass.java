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

        driver.get("http://www.w3schools.com/jsref/prop_pushbutton_disabled.asp");

        WebElement button1 = driver.findElement(By.xpath("//button[text()='My Button']"));
        WebElement button2 = driver.findElement(By.xpath("//a[@title='Home']"));

        System.out.println(button1.isEnabled());
        System.out.println(button2.isEnabled());

        if (button1.isEnabled()) button1.click();
        if (button2.isEnabled()) button2.click();

        driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");

        WebElement rb1 = driver.findElement(By.xpath("(//input[@name='agreementjdk-8u121-oth-JPR'])[1]"));
        WebElement rb2 = driver.findElement(By.xpath("(//input[@name='agreementjdk-8u121-oth-JPR'])[2]"));

        System.out.println("Radio button 2 selected: " + rb2.isSelected());

        if (!rb1.isSelected()) rb1.click();

        driver.get("http://ebay.com");

        WebElement link1 = driver.findElement(By.xpath("//a[contains(text(), 'Бытовая электроника')]"));
        WebElement link2 = driver.findElement(By.xpath("//a[text()='Подписки']"));

        System.out.println(link1.isDisplayed());
        System.out.println(link2.isDisplayed());

        if (link1.isDisplayed()) link1.click();
        else link2.click();






//        driver.quit();
    }
}
