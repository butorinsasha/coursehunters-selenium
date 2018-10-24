package lesson063pageobject;

import lesson057presenceofelement.WebElementPresenceVerifier;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static lesson063pageobject.SignUpPage.USERNAME_NOTE_XPATH;


public class MainPageTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void registerWithUnusedCreds() {
        driver.get("https://github.com/");
        MainPage mainPage = new MainPage(driver);
        System.out.println(mainPage.getEmailField().getTagName());

        SignUpPage signUpPage = mainPage.register("butorinsasha6", "butorinsasha6@rupayamail.com", "JOer33okokp");

        System.out.println(signUpPage.getClass());
        System.out.println(signUpPage.HEADER_XPATH);

//        mainPage.register("butorinsasha6", "butorinsasha6@rupayamail.com", "JOer33okokp");
//        SignUpPage signUpPage = new SignUpPage(driver);

//        System.out.println(signUpPage.getPageTitle());
        System.out.println(signUpPage.getHeader());
        System.out.println(signUpPage.getHeader().getTagName());
        System.out.println(signUpPage.getMainError());
//        System.out.println(signUpPage.getMainError().getTagName());

//        Assert.assertEquals("Join GitHub · GitHub", signUpPage.getPageTitle());
//        SignUpPage signUpPage = mainPage.register("butorinsasha6", "butorinsasha6@rupayamail.com", "JOer33okokp");
//        Assert.assertEquals("https://github.com/join", signUpPage.getPageURL());
    }

    @Test
    public void registerWithUsedUsername() {
        driver.get("https://github.com/");
        MainPage mainPage = new MainPage(driver);
//        SignUpPage signUpPage = mainPage.register("butorinsasha", "butorinsasha@rupayamail.com", "JOer33okokp");
        mainPage.register("butorinsasha", "butorinsasha@rupayamail.com", "JOer33okokp");
        SignUpPage signUpPage = new SignUpPage(driver);
        System.out.println(signUpPage.getHeaderText());
        System.out.println(signUpPage.getPageTitle());
        System.out.println(signUpPage.getHeader().getTagName());

//        Assert.assertEquals("There were problems creating your account.", signUpPage.getMainErrorText());
//        Assert.assertTrue(signUpPage.getUsernameErrorText().contains("already taken"));
//
//        Assert.assertFalse(WebElementPresenceVerifier.isPresentByFindElementsSizeListIsGreaterThanZero(driver, By.xpath(signUpPage.USERNAME_NOTE_XPATH)));
//        Assert.assertFalse(WebElementPresenceVerifier.isPresentByFindElementsSizeListIsGreaterThanZero(driver, By.xpath(signUpPage.PASSWORD_ERROR_XPATH)));
//
//        Assert.assertEquals("We’ll occasionally send updates about your account to this inbox. We’ll never share your email address with anyone.", signUpPage.getEmailNoteText());
//        Assert.assertEquals("Make sure it's more than 15 characters, or at least 7 characters, including a number, and a lowercase letter.", signUpPage.getPasswordNoteText());
    }

//    @Test
//    public void registrWithBlankFields() {
//        driver.get("https://github.com/");
//        MainPage mainPage = new MainPage(driver);
//        SignUpPage signUpPage = mainPage.register("", "", "");
//
//        Assert.assertEquals("There were problems creating your account.", signUpPage.getMainErrorText());
//        Assert.assertTrue(signUpPage.getUsernameErrorText().contains("can't be blank"));
//        Assert.assertTrue(signUpPage.getEmailErrorText().contains("can't be blank"));
//        Assert.assertTrue(signUpPage.getPasswordErrorText().contains("Password can't be blank and is too short (minimum is 7 characters)"));
//    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
    }
}
