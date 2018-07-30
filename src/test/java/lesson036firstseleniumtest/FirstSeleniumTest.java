package lesson036firstseleniumtest;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumTest {

//    WebDriver driver = new ChromeDriver();
    private WebDriver driver;


    @Before
    public void setUp(){


        /* *** Windows *** */
        /*chrome*/
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\drivers\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

        /*firefox*/
//        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\drivers\\geckodriver.exe");
//        System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");

        /*
        Use this to define the Firefox version you want to use.
        Most of the issue I have faced trying Selenium is around version issues, with no clear messages or info on which versions are compatible.
        (works only if system property webdriver.gecko.driver is set manually in code)
        */
//        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");



        /* *** Linux *** */
        /*chrome*/
//        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver"); // to add into the $PATH locate drivers into the /usr/bin and make them executable: chmod 777 chromedirver geckodriver
//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
//        System.setProperty("webdriver.chrome.bin", "/usr/bin/google-chrome");

        /*firefox*/
//        System.setProperty("webdriver.gecko.driver", "/usr/bin/chromedriver"); // to add into the $PATH use locade drivers into the /usr/bin
//        System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox"); // Need a custom installation: tar jxf firefox*.tar.bz2 -C /opt



//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
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
