package lesson059screenshots;

import org.apache.commons.io.FileUtils; //this is needed to be imported
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Date;

public class ScreenShotTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void screenShotTest() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        WebElement searchInput = driver.findElement(By.xpath("//input[@id=\"searchInput\"]"));

        System.out.println(searchInput.getClass());
        System.out.println(searchInput instanceof WebElement);

        /*Capturing as FILE*/
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        /*Capturing as BASE64*/
        String base64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        File scrBase64 = new File("target/test-classes/lesson059screenshots/screenshots/screenshot_" + FileName.dateTimeFileName(FileName.DATE_PATTERN_001) + ".base64");

        try {
            FileUtils.copyFile(scrFile, new File("target/test-classes/lesson059screenshots/screenshots/screenshot_" + FileName.dateTimeFileName(FileName.DATE_PATTERN_001) + ".png"));
            FileUtils.copyFile(scrFile, new File("target/test-classes/lesson059screenshots/screenshots/screenshot_" + FileName.epochFileName() + ".png"));

//            FileUtils.copyFile(scrBase64, new File("target/test-classes/lesson059screenshots/screenshots/screenshot_" + FileName.dateTimeFileName(FileName.DATE_PATTERN_001) + ".base64"));

            PrintWriter print = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(scrBase64)));
            print.println(base64);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Date now = new Date(System.currentTimeMillis());
        System.out.println(now.toString());
        System.out.println(base64);

        /*Just wait for a while after all instructions of test is done*/
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
