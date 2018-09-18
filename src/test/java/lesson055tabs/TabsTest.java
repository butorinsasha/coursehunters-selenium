package lesson055tabs;

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

    @Before
    public void tearDown() throws Exception {
        driver = new ChromeDriver();
        jse = (JavascriptExecutor)driver;
    }

    public void alertWindowHandle(WebDriver drv, JavascriptExecutor jse, long lag) {
        jse.executeScript("alert(' windowHandler = " + drv.getWindowHandle() + "');");
        try {
            Thread.sleep(lag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        drv.switchTo().alert().accept();
    }

    public void switchToLastWindowOrTab(WebDriver drv) {
        for (String tab : drv.getWindowHandles()) {
            drv.switchTo().window(tab);
        }
    }

    @Test
    public void testSwitchingTabs() {
        driver.get("https://instagram.com");
        alertWindowHandle(driver, jse, 3000);

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


        WebElement aDownloadOnTheAppStore = driver.findElement(By.xpath("//a[@class=\"z1VUo\"][1]"));
        WebElement aGetOnGooglePlay = driver.findElement(By.xpath("//a[@class=\"z1VUo\"][2]"));

        aGetOnGooglePlay.click();

        /*Switch to the last window or tab*/
//        for (String tab : driver.getWindowHandles()) {
//            driver.switchTo().window(tab);
//        }

        switchToLastWindowOrTab(driver);
        alertWindowHandle(driver, jse, 3000);

        driver.findElement(By.xpath("//input[@id=\"gbqfq\"]")).sendKeys("vk");
        driver.findElement(By.xpath("//button[@id=\"gbqfb\"]")).click();

        driver.switchTo().window(mainWindow);
        aDownloadOnTheAppStore.click();
        switchToLastWindowOrTab(driver);
        alertWindowHandle(driver, jse, 3000);

        System.out.println(driver.getWindowHandles());
    }

    @After
    public void setUp() throws Exception {
//        driver.quit();
    }
}
