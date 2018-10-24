package lesson063pageobject;

import lesson057presenceofelement.WebElementPresenceVerifier;
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
    public void registerWithUnusedCreds() {
        driver.get("https://github.com/");
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = mainPage.register("butorinsasha6", "butorinsasha6@rupayamail.com", "JOer33okokp");
        Assert.assertEquals("Join GitHub · GitHub", signUpPage.getPageTitle());
        Assert.assertEquals("https://github.com/join", signUpPage.getPageURL());
    }

    @Test
    public void registerWithUsedUsername() {
        driver.get("https://github.com/");
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = mainPage.register("butorinsasha", "butorinsasha@rupayamail.com", "JOer33okokp");

        Assert.assertEquals("There were problems creating your account.", signUpPage.getMainErrorText());
        Assert.assertTrue(signUpPage.getUsernameErrorText().contains("already taken"));

        Assert.assertFalse(WebElementPresenceVerifier.isPresentByFindElementsSizeListIsGreaterThanZero(driver, signUpPage.getUsernameNote()));
        Assert.assertFalse(WebElementPresenceVerifier.isPresentByFindElementsSizeListIsGreaterThanZero(driver, signUpPage.getPasswordError()));

        Assert.assertEquals("We’ll occasionally send updates about your account to this inbox. We’ll never share your email address with anyone.", signUpPage.getEmailNoteText());
        Assert.assertEquals("Make sure it's more than 15 characters, or at least 7 characters, including a number, and a lowercase letter.", signUpPage.getPasswordNoteText());
    }

    @Test
    public void registrWithBlankFields() {
        driver.get("https://github.com/");
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = mainPage.register("", "", "");

        Assert.assertEquals("There were problems creating your account.", signUpPage.getMainErrorText());
        Assert.assertTrue(signUpPage.getUsernameErrorText().contains("can't be blank"));
        Assert.assertTrue(signUpPage.getEmailErrorText().contains("can't be blank"));
        Assert.assertTrue(signUpPage.getPasswordErrorText().contains("Password can't be blank and is too short (minimum is 7 characters)"));
    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
    }
}
