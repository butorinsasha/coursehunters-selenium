package lesson054windows;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WindowsTest {

    WebDriver driver;
    JavascriptExecutor jse;
    WebDriverWait wait;
    Actions actions;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        jse = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
    }

    @Test
    public void testSwitchingWindows() {
        driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        WebElement aAgreement = driver.findElement(By.xpath("//a[text()=\"Oracle Binary Code License Agreement for Java SE\"]"));
        WebElement aBSDLicense = driver.findElement(By.xpath("//a[text()=\"Oracle BSD License.\"]"));

        aAgreement.click();
//        Set<String> windowHandlesSet = new HashSet<>(); // java.util.Set<java.lang.String> getWindowHandles() Return a LinkedHashSet of window handles which can be used to iterate over all open windows of this WebDriver instance by passing them to switchTo().WebDriver.Options.window()
        Set<String> windowHandlesSet;
        windowHandlesSet = driver.getWindowHandles();
        System.out.println(windowHandlesSet.getClass());

        /*Print windowHandlesSet*/
//        for ( String windowHandle : windowHandlesSet) {
//            System.out.println(windowHandle);
//        }

        /*Print windowHandlesSet by using iterator*/
//        Iterator<String> iterator = windowHandlesSet.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        /*Switch to the last windowHandle (BUT Set interface and LinkedHashSet class do not guarantee the ordering)*/
        for (String windowHandle : windowHandlesSet ) {
            driver.switchTo().window(windowHandle);
            System.out.println(driver.getWindowHandle()); // Print all windowHandles names
        }

        /*Print current windowHandle name*/
        System.out.println(driver.getWindowHandle());

        /*Find a Community link at secondary window*/
        WebElement aCommunityAtSecondaryWindow = driver.findElement(By.xpath("//div[text()=\"Community\"]/parent::a"));
        actions.click(aCommunityAtSecondaryWindow).build().perform();
        Assert.assertEquals("Java Community Home", driver.getTitle());

        /*Switch back to the mainWindow*/
        driver.switchTo().window(mainWindow);

        /*Find a Community link at mainWindow*/
        WebElement aCommunityAtMainWindow = driver.findElement(By.xpath("//div[text()=\"Community\"]/parent::a"));
        aCommunityAtMainWindow.click();
//        actions.click(aBSDLicense).build().perform();
        Assert.assertEquals("Java Community Home", driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
