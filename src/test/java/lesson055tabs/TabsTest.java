package lesson055tabs;

import lesson055windows.Window;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabsTest {

    WebDriver driver;
    JavascriptExecutor jse;


//    public void alertWindowHandle(WebDriver drv, JavascriptExecutor jse, long lag) {
//        jse.executeScript("alert(' windowHandler = " + drv.getWindowHandle() + "');");
//        try {
//            Thread.sleep(lag);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        drv.switchTo().alert().accept();
//    }
//
//    public void switchToLastWindowOrTab(WebDriver drv) {
//        for (String tab : drv.getWindowHandles()) {
//            drv.switchTo().window(tab);
//        }
//    }



    @Before
    public void tearDown() throws Exception {
        driver = new ChromeDriver();
        jse = (JavascriptExecutor)driver;
    }

    @Test
    public void testSwitchingTabs() {
        driver.get("https://instagram.com");
        Window.alertWindowHandle(driver, jse, 3000);

        String mainWindow = driver.getWindowHandle();

        /*Print and show wcurrent windowHandle*/
//        System.out.println(mainWindow);
//        jse.executeScript("alert(' windowHandler = " + driver.getWindowHandle() + "');");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.switchTo().alert().accept();


        WebElement downloadOnTheAppStoreLink = driver.findElement(By.xpath("//a[@class=\"z1VUo\"][1]"));
        WebElement getOnGooglePlayLink = driver.findElement(By.xpath("//a[@class=\"z1VUo\"][2]"));

        getOnGooglePlayLink.click();

        /*Switch to the last window or tab*/
//        for (String tab : driver.getWindowHandles()) {
//            driver.switchTo().window(tab);
//        }

        Window.switchToLastWindowOrTab(driver);
        Window.alertWindowHandle(driver, jse, 3000);

        driver.findElement(By.xpath("//input[@id=\"gbqfq\"]")).sendKeys("vk");
        driver.findElement(By.xpath("//button[@id=\"gbqfb\"]")).click();

        driver.switchTo().window(mainWindow);
        downloadOnTheAppStoreLink.click();
        Window.switchToLastWindowOrTab(driver);
        Window.alertWindowHandle(driver, jse, 3000);

        System.out.println(driver.getWindowHandles());
    }

    @After
    public void setUp() throws Exception {
        driver.quit();
    }
}
