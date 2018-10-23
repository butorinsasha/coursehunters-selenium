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
    private By loginError = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/username\"]//dd[@class=\"error\"]");
    private By emailError = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/email\"]//dd[@class=\"error\"]");
    private By passwordError = By.xpath("//form[@id=\"signup-form\"]//password-strength//dd[@class=\"error\"]");

    private By usernameNote = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/username\"]//dd[@class=\"error\"]");
    private By emailNote = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/email\"]//dd[@class=\"error\"]");

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

    public String getMainError() {
        return driver.findElement(header).getText();
    }

    public String getUsernameNoteText() {
        return driver.findElement(usernameNote).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }
}
