package lesson063pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends Page {
    private WebDriver driver;

    /*Constructor*/
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    /*By using*/
//    private By header = By.xpath("//h1");
//    private By usernameFieldBy = By.xpath("//input[@id=\"user_login\"]");
//    private By emailFieldBy = By.xpath("//input[@id=\"user_email\"]");
//    private By passwordFieldBy = By.xpath("//input[@id=\"user_password\"]");
//    private By signUpButtonBy = By.xpath("//button[@id=\"signup_button\"]");
//    private By mainErrorBy = By.xpath("//form[@id=\"signup-form\"]//div[@class=\"flash flash-error my-3\"]");
//    private By usernameErrorBy = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/username\"]//dd[@class=\"error\"]");
//    private By emailErrorBy = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/email\"]//dd[@class=\"error\"]");
//    private By passwordErrorBy = By.xpath("//form[@id=\"signup-form\"]//password-strength//dd[@class=\"error\"]");
//    private By usernameNoteBy = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/usernameemail\"]//p[@class=\"note\"]");
//    private By emailNoteBy = By.xpath("//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/email\"]//p[@class=\"note\"]");
//    private By passwordNoteBy = By.xpath("//form[@id=\"signup-form\"]//password-strength//p[@class=\"note\"]");

    /*XPATH_CONSTANTS*/
    public static final String HEADER_XPATH = "//h1";
    public static final String USERNAME_FIELD_XPATH = "//input[@id=\"user_login\"]";
    public static final String EMAIL_FIELD_XPATH = "//input[@id=\"user_email\"]";
    public static final String PASSWORD_FIELD_XPATH = "//input[@id=\"user_password\"]";
    public static final String SIGN_UP_BUTTON_XPATH = "//button[@id=\"signup_button\"]";
    public static final String MAIN_ERROR_XPATH = "//form[@id=\"signup-form\"]//div[@class=\"flash flash-error my-3\"]";
    public static final String USERNAME_ERROR_XPATH = "//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/username\"]//dd[@class=\"error\"]";
    public static final String EMAIL_ERROR_XPATH = "//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/email\"]//dd[@class=\"error\"]";
    public static final String PASSWORD_ERROR_XPATH = "//form[@id=\"signup-form\"]//password-strength//dd[@class=\"error\"]";
    public static final String USERNAME_NOTE_XPATH = "//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/usernameemail\"]//p[@class=\"note\"]";
    public static final String EMAIL_NOTE_XPATH = "//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/email\"]//p[@class=\"note\"]";
    public static final String PASSWORD_NOTE_XPATH = "//form[@id=\"signup-form\"]//password-strength//p[@class=\"note\"]";

    /*WebElements*/
    @FindBy (xpath = HEADER_XPATH)
    private WebElement header;

    @FindBy (xpath = USERNAME_FIELD_XPATH)
    private WebElement usernameField;

    @FindBy (xpath = EMAIL_FIELD_XPATH)
    private WebElement emailField;

    @FindBy (xpath = PASSWORD_FIELD_XPATH)
    private WebElement passwordField;

    @FindBy (xpath = SIGN_UP_BUTTON_XPATH)
    private WebElement signUpButton;

    @FindBy (xpath = MAIN_ERROR_XPATH)
    private WebElement mainError;
//
//    @FindBy (xpath = USERNAME_ERROR_XPATH)
//    private WebElement usernameError;
//
//    @FindBy (xpath = EMAIL_ERROR_XPATH)
//    private WebElement emailError;
//
//    @FindBy (xpath = PASSWORD_ERROR_XPATH)
//    private WebElement passwordError;
//
//    @FindBy (xpath = USERNAME_NOTE_XPATH)
//    private WebElement usernameNote;
//
//    @FindBy (xpath = EMAIL_NOTE_XPATH)
//    private WebElement emailNote;
//
//    @FindBy (xpath = PASSWORD_NOTE_XPATH)
//    private WebElement passwordNote;

    /*Getters*/
    public WebElement getHeader() {
        return header;
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

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getMainError() {
        return mainError;
    }
//
//    public WebElement getUsernameError() {
//        return usernameError;
//    }
//
//    public WebElement getEmailError() {
//        return emailError;
//    }
//
//    public WebElement getPasswordError() {
//        return passwordError;
//    }
//
//    public WebElement getUsernameNote() {
//        return usernameNote;
//    }
//
//    public WebElement getEmailNote() {
//        return emailNote;
//    }
//
//    public WebElement getPasswordNote() {
//        return passwordNote;
//    }


    /*Page methods*/
    public SignUpPage typeUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPage typePassword (String password) {
        usernameField.sendKeys(password);
        return this;
    }

    public Page register(String username, String email, String password) {
        typeUsername(username);
        typeEmail(email);
        typePassword(password);
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public String getHeaderText() {
        return header.getText();
    }

    public String getMainErrorText() {
        return mainError.getText();
    }
//
//    public String getUsernameErrorText() {
//        return usernameError.getText();
//    }
//
//    public String getUsernameNoteText() {
//        return usernameNote.getText();
//    }
//
//    public String getEmailErrorText() {
//        return emailError.getText();
//    }
//
//    public String getEmailNoteText() {
//        return emailNote.getText();
//    }
//
//    public String getPasswordErrorText() {
//        return passwordError.getText();
//    }
//
//    public String getPasswordNoteText() {
//        return passwordNote.getText();
//    }

}
