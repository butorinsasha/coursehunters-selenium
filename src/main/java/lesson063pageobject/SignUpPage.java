package lesson063pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends Page {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By header = By.xpath("//h1");

    private By usernameField = By.xpath("//input[@id=\"user_login\"]");
    private By emailField = By.xpath("//input[@id=\"user_email\"]");
    private By passwordField = By.xpath("//input[@id=\"user_password\"]");

    private By signUpButton = By.xpath("//button[@id=\"signup_button\"]");

    private By mainError = By.xpath("//form[@id=\"signup-form\"]//div[@class=\"flash flash-error my-3\"]");
    private By usernameError = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/username\"]//dd[@class=\"error\"]");
    private By emailError = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/email\"]//dd[@class=\"error\"]");
    private By passwordError = By.xpath("//form[@id=\"signup-form\"]//password-strength//dd[@class=\"error\"]");

    private By usernameNote = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/usernameemail\"]//p[@class=\"note\"]");
    private By emailNote = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/email\"]//p[@class=\"note\"]");

    private By passwordNote = By.xpath("//form[@id=\"signup-form\"]//password-strength//p[@class=\"note\"]");

    public By getHeader() {
        return header;
    }

    public By getUsernameField() {
        return usernameField;
    }

    public By getEmailField() {
        return emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getSignUpButton() {
        return signUpButton;
    }

    public By getMainError() {
        return mainError;
    }

    public By getUsernameError() {
        return usernameError;
    }

    public By getEmailError() {
        return emailError;
    }

    public By getPasswordError() {
        return passwordError;
    }

    public By getUsernameNote() {
        return usernameNote;
    }

    public By getEmailNote() {
        return emailNote;
    }

    public SignUpPage typeUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword (String password) {
        driver.findElement(usernameField).sendKeys(password);
        return this;
    }

    public By getPasswordNote() {
        return passwordNote;
    }

    public Page register(String username, String email, String password) {
        typeUsername(username);
        typeEmail(email);
        typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }

    public String getUsernameErrorText() {
        return driver.findElement(usernameError).getText();
    }

    public String getUsernameNoteText() {
        return driver.findElement(usernameNote).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }

    public String getEmailNoteText() {
        return driver.findElement(emailNote).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

    public String getPasswordNoteText() {
        return driver.findElement(passwordNote).getText();
    }

}
