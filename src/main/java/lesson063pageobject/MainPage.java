package lesson063pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    /*Constructor*/
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "https://github.com";

    /*XPATH_CONSTANTS*/
    public static final String SIGN_IN_BUTTON_XPATH = "//a[text()=\"Sign in\"]";
    public static final String SIGN_UP_BUTTON_XPATH = "//a[text()=\"Sign up\"]";
    public static final String USERNAME_FIELD_XPATH = "//input[@id=\"user[login]\"]";
    public static final String EMAIL_FIELD_XPATH = "//input[@id=\"user[email]\"]";
    public static final String PASSWORD_FIELD_XPATH = "//input[@id=\"user[password]\"]";
    public static final String SIGN_UP_FORM_BUTTON_XPATH = "//button[text()=\"Sign up for GitHub\"]";

    /*WebElements*/
    @FindBy(xpath = SIGN_IN_BUTTON_XPATH)
    private WebElement signInButton;

    @FindBy(xpath = SIGN_UP_BUTTON_XPATH)
    private WebElement signUpButton;

    @FindBy(xpath = USERNAME_FIELD_XPATH)
    private WebElement usernameField;

    @FindBy(xpath = EMAIL_FIELD_XPATH)
    private WebElement emailField;

    @FindBy(xpath = PASSWORD_FIELD_XPATH)
    private WebElement passwordField;

    @FindBy(xpath = SIGN_UP_FORM_BUTTON_XPATH)
    private WebElement signUpFormButton;

    /*Getters*/
    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSignUpFormButton() {
        return signUpFormButton;
    }


    /*Page methods*/
    public LoginPage clickSignInButton() {
        signInButton.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public MainPage typeUsername(String username) throws InterruptedException {
        usernameField.sendKeys(username);
        Thread.sleep(1000);
        return this;
    }

    public MainPage typeEmail(String email) throws InterruptedException {
        emailField.sendKeys(email);
        Thread.sleep(1000);
        return this;
    }

    public MainPage typePassword(String password) throws InterruptedException {
        passwordField.sendKeys(password);
        Thread.sleep(1000);
        return this;
    }

    public SignUpPage clickSignUpFormButton() throws InterruptedException {
        signUpFormButton.click();
        Thread.sleep(1000);
        return new SignUpPage(driver);
    }

    public SignUpPage register(String username, String email, String password) throws ElementDisabledException, InterruptedException {
        this.typeUsername(username);
        this.typeEmail(email);
        this.typePassword(password);
//        this.clickSignUpFormButton();
        this.clickButton(signUpFormButton);
        return new SignUpPage(driver);
//        return this.clickSignUpFormButton();
    }
}
