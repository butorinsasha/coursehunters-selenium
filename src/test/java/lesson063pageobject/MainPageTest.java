package lesson063pageobject;

import lesson057presenceofelement.ElementPresenceVerifier;
import lesson059screenshots.FileName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void registerWithUnusedCreds() throws ElementDisabledException, InterruptedException {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        String timestamp = FileName.epochFileName();
        String username = "username" + timestamp;
        String email = "username" + timestamp + "@rupayamail.com";
        String password = "Password"+ timestamp;

        System.out.println("username: " + username);
        System.out.println("email: " + email);
        System.out.println("password: " + password);

        SignUpPage signUpPage = mainPage.register(username, email , password);
        Assert.assertFalse(ElementPresenceVerifier.isPresentByFindElementsSizeListIsGreaterThanZero(driver, By.xpath(SignUpPage.SIGNUP_FORM_XPATH)));

    }

    @Test
    public void registerWithUsedUsername() throws ElementDisabledException, InterruptedException {
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = mainPage.register("butorinsasha", "butorinsasha@rupayamail.com", "Password299792458");

        /*Check a presence of errors*/
        Assert.assertEquals(SignUpPage.MAIN_ERROR_TEXT, signUpPage.getMainErrorText());
        Assert.assertEquals(SignUpPage.USERNAME_ALREADY_TAKED_ERROR_TEXT, signUpPage.getUsernameErrorText());

        /*Check an absence of Errors and notes*/
        Assert.assertFalse(ElementPresenceVerifier.isPresentByFindElementsSizeListIsGreaterThanZero(driver, By.xpath(SignUpPage.USERNAME_NOTE_XPATH)));
        Assert.assertFalse(ElementPresenceVerifier.isPresentByNoSuchElementExceptionHandling(driver, By.xpath(SignUpPage.EMAIL_ERROR_XPATH)));
        Assert.assertFalse(ElementPresenceVerifier.isPresentByFindElementsSizeListIsGreaterThanZero(driver, By.xpath(SignUpPage.PASSWORD_ERROR_XPATH)));

        /*Check a presence of Notes*/
        Assert.assertEquals(SignUpPage.EMAIL_STANDART_NOTE_TEXT, signUpPage.getEmailNoteText());
        Assert.assertEquals(SignUpPage.PASSWORD_STANDART_NOTE_TEXT, signUpPage.getPasswordNoteText());
    }

    @Test
    public void registerWithBlankFields() throws ElementDisabledException, InterruptedException {
        driver.get("https://github.com/");
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = mainPage.register("", "", "");

        Assert.assertEquals(SignUpPage.MAIN_ERROR_TEXT, signUpPage.getMainErrorText());
        Assert.assertEquals(SignUpPage.USERNAME_BLANK_ERROR_TEXT, signUpPage.getUsernameErrorText());
        Assert.assertEquals(SignUpPage.EMAIL_BLANK_ERROR_TEXT, signUpPage.getEmailErrorText());
        Assert.assertEquals(SignUpPage.PASSWORD_BLANK_ERROR_TEXT, signUpPage.getPasswordErrorText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
