package lesson063pageobject;

import lesson057presenceofelement.ElementPresenceVerifier;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(expected = ElementDisabledException.class)
    public void cantSignUpWithBlankCreds() throws ElementDisabledException, InterruptedException {
        driver.get(SignUpPage.URL);
        SignUpPage signUpPage = new SignUpPage(driver);
            signUpPage.register("", "", "");
    }

    @Test(expected = ElementDisabledException.class)
    public void cantSignUpWithOnlyUsernameTypedCreds() throws ElementDisabledException, InterruptedException {
        driver.get(SignUpPage.URL);
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.register("butorinsasha299792458", "", "");
    }

    @Test
    public void signUpWithUnusedCreds() throws ElementDisabledException, InterruptedException {
        driver.get(SignUpPage.URL);
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.register("butorinsasha299792458", "butorinsasha299792458@rupayamail.com", "Password299792458");
    }

    @Test
    public void signUpWithUsedUsername() throws InterruptedException, ElementDisabledException {
        driver.get(SignUpPage.URL);
        SignUpPage signUpPage = new SignUpPage(driver);
//        try {
//            signUpPage.register("butorinsasha", "butorinsasha@rupayamail.com", "Password299792458");
//        } catch (ElementDisabledException e) {
//            e.getMessage();
//        }
        signUpPage.typeUsername("butorinsasha");
        signUpPage.typeEmail("butorinsasha@rupayamail.com");
        signUpPage.typePassword("Password299792458");

        Thread.sleep(1000);

        signUpPage = new SignUpPage(driver);


        /*Checking errors and notes texts*/
        Assert.assertEquals(signUpPage.USERNAME_ALREADY_TAKEN_NOTE_TEXT, signUpPage.getUsernameNoteText());
        Assert.assertFalse(ElementPresenceVerifier.isPresentByNoSuchElementExceptionHandling(driver, By.xpath(signUpPage.USERNAME_ERROR_XPATH)));

        Assert.assertEquals(signUpPage.EMAIL_STANDART_NOTE_TEXT, signUpPage.getEmailNoteText());
        Assert.assertFalse(ElementPresenceVerifier.isPresentByNoSuchElementExceptionHandling(driver, By.xpath(signUpPage.EMAIL_ERROR_XPATH)));

        Assert.assertEquals(signUpPage.PASSWORD_TYPED_NOTE_TEXT, signUpPage.getPasswordNoteText());
        Assert.assertFalse(ElementPresenceVerifier.isPresentByNoSuchElementExceptionHandling(driver, By.xpath(signUpPage.PASSWORD_ERROR_XPATH)));

        /*Button is enabled even if notes indicate some problems. So clicking (enabled) button leads no ElementDisabledException*/
        Assert.assertTrue(signUpPage.getSignUpButton().isEnabled());
        signUpPage.clickButton(signUpPage.getSignUpButton());
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
