package lesson036firstseleniumtest;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){

//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\butorin\\Documents\\work\\qa\\coursehunters-selenium\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\butorin\\Documents\\work\\qa\\coursehunters-selenium\\drivers\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
//        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");

        driver.get("https://www.seleniumhq.org/");
    }

    @Test
    public void downloadsPageHasRightTitle(){
        driver.findElement(By.id("menu_download")).click();
        Assert.assertEquals("Downloads", driver.getTitle());
    }

    /*intended to fail*/
    @Test
    public void projectsPageHasRightTitle(){
        driver.findElement(By.id("menu_projects")).click();
        Assert.assertEquals("Projects", driver.getTitle()); // it is actually "Selenium Projects"
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
