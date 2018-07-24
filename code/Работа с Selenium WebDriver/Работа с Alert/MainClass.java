import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainClass {

    public static void main(String[] args) {

//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\student\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\student\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
        driver.findElement(By.xpath("//a[text()='jdk-8u121-windows-x64.exe']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

        driver.get("http://google.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("confirm('Are you sure?');");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();



//        driver.quit();
    }
}
