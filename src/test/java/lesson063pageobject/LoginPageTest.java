package lesson063pageobject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void loginWithUsedCreds() {
        driver.get(LoginPage.URL);
        LoginPage loginPage = new LoginPage(driver);
        Page newPage = loginPage.login("butorinsasha", "M4Jokshr75Jjj");
        Assert.assertEquals("GitHub", newPage.getPageTitle());
    }

    @Test
    public void loginWithUnusedCreds() {
        driver.get(LoginPage.URL);
        LoginPage loginPage = new LoginPage(driver);
        Page newPage = loginPage.login("username299792458", "Password299792458");
        LoginPage newLoginPage = (LoginPage) newPage;
        Assert.assertEquals(LoginPage.MAIN_ERROR_TEXT, newLoginPage.getErrorText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
