package lesson063pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    /*Constants*/
    public static final String LOGIN_FIELD_XPATH = "//input[@id=\"login_field\"]";
    public static final String PASSWORD_FIELD_XPATH = "//input[@id=\"password\"]";
    public static final String SIGN_IN_BUTTON_XPATH = "//input[@type=\"submit\"]";
    public static final String HEADER_XPATH = "//h1[text()=\"Sign in to GitHub\"]";
    public static final String MAIN_ERROR_XPATH = "//div[@id=\"js-flash-container\"]//div[@class=\"container\"]";
    public static final String CREATE_ACCOUNT_LINK_XPATH = "//a[text()=\"Create an account\"]";

    /*WebElements*/
    @FindBy(xpath = "LOGIN_FIELD_XPATH")
    private WebElement loginField;

    @FindBy(xpath = "PASSWORD_FIELD_XPATH")
    private WebElement passwordField;

    @FindBy(xpath = "SIGN_IN_BUTTON_XPATH")
    private WebElement signInButton;

    @FindBy(xpath = "HEADER_XPATH")
    private WebElement header;

    @FindBy(xpath = "ERROR_XPATH")
    private WebElement mainError;

    @FindBy(xpath = "CREATE_ACCOUNT_LINK_XPATH")
    private WebElement createAccountLink;

    /*Methods*/
    public LoginPage typeUsername(String username) {
        loginField.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSignInButton(){
        signInButton.click();
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
        return header.getText();
    }

    public String getErrorText() {
        return mainError.getText();
    }

    public SignUpPage createAccountClick() {
        createAccountLink.click();
        return new SignUpPage(driver);
    }


}
