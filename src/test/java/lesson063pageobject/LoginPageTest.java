package lesson063pageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @Test
    public void loginAtMainPage() {

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
