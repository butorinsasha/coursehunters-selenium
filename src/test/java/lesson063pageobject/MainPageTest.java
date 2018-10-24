package lesson063pageobject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainPageTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @Test
    public void registerAtMainPageWithRightCreds() {
        driver.get("https://github.com/");
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = mainPage.register("butorinsasha5", "butorinsasha5@rupayamail.com", "M4Jokshr75Jjj");
        Assert.assertEquals("Join GitHub · GitHub", signUpPage.getPageTitle());
        Assert.assertEquals("https://github.com/join", signUpPage.getPageURL());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
