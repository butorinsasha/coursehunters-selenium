package lesson060fileupload;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(900, 1040));
    }

    @Test
    public void fileUploadTest() {
        driver.get("https://images.google.com");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id=\"qbi\"]")));
        WebElement photoImageButton = driver.findElement(By.xpath("//span[@id=\"qbi\"]"));
        photoImageButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class=\"qbtbha qbtbtxt qbclr\"]")));
        WebElement uploadImageTab = driver.findElement(By.xpath("//a[@class=\"qbtbha qbtbtxt qbclr\"]"));
        uploadImageTab.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type=\"file\"]")));
        WebElement uploadFileButton = driver.findElement(By.xpath("//input[@type=\"file\"]"));

        /*Windows*/
//        uploadFileButton.sendKeys("C:\\Users\\butorin\\Documents\\work\\qa\\coursehunters-selenium\\src\\main\\resources\\lesson060fileupload\\screenshot.png");

        /*Linux*/
        uploadFileButton.sendKeys("/media/sasha/DATA/sasha/work/qa/coursehunters-selenium/src/main/resources/lesson060fileupload/screenshot.png");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
