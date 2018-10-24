package lesson063pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By loginField = By.xpath("//input[@id=\"login_field\"]");
    private By passwordField = By.xpath("//input[@id=\"password\"]");
    private By signInButton = By.xpath("//input[@type=\"submit\"]");
    private By header = By.xpath("//h1[text()=\"Sign in to GitHub\"]");
    private By error = By.xpath("//div[@id=\"js-flash-container\"]//div[@class=\"container\"]");
    private By createAccountLink = By.xpath("//a[text()=\"Create an account\"]");


    public LoginPage typeUsername(String username) {
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickSignInButton(){
        driver.findElement(By.xpath("signInButton")).click();
        return new LoginPage(driver);
    }

    public Page login(String username, String password) {
        this.typePassword(username);
        this.typePassword(password);

        if (new StupidValidator(new HashMap<String, String>()).isRightCreds(username, password)) {
            return new Page(driver);
        } else {
            return new LoginPage(driver);
        }
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccountClick() {
        driver.findElement(createAccountLink).click();
        return new SignUpPage(driver);
    }


}
