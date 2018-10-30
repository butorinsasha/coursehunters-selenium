package lesson063pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends Page {

    /*Constructor*/
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = "https://github.com/join";

    /*Xpath constants*/
    public static final String HEADER_XPATH = "//h1";
    public static final String SIGNUP_FORM_XPATH = "//form[@id=\"signup-form\"]";
    public static final String USERNAME_FIELD_XPATH = "//input[@id=\"user_login\"]";
    public static final String EMAIL_FIELD_XPATH = "//input[@id=\"user_email\"]";
    public static final String PASSWORD_FIELD_XPATH = "//input[@id=\"user_password\"]";
    public static final String SIGN_UP_BUTTON_XPATH = "//button[@id=\"signup_button\"]";
    public static final String MAIN_ERROR_XPATH = "//form[@id=\"signup-form\"]//div[@class=\"flash flash-error my-3\"]";
    public static final String USERNAME_ERROR_XPATH = "//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/username\"]//dd[@class=\"error\"]";
    public static final String EMAIL_ERROR_XPATH = "//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/email\"]//dd[@class=\"error\"]";
    public static final String PASSWORD_ERROR_XPATH = "//form[@id=\"signup-form\"]//password-strength//dd[@class=\"error\"]";
    public static final String USERNAME_NOTE_XPATH = "//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/username\"]//p[@class=\"note\"]";
    public static final String EMAIL_NOTE_XPATH = "//form[@id=\"signup-form\"]//auto-check[@src=\"/signup_check/email\"]//p[@class=\"note\"]";
    public static final String PASSWORD_NOTE_XPATH = "//form[@id=\"signup-form\"]//password-strength//p[@class=\"note\"]";


    /*Error texts*/
    public static final String MAIN_ERROR_TEXT = "There were problems creating your account.";

    public static final String USERNAME_BLANK_ERROR_TEXT = "Login can't be blank";
    public static final String USERNAME_RESERVED_WORD_ERROR_TEXT = "Login name 'username' is a reserved word";
    public static final String USERNAME_ALREADY_TAKED_ERROR_TEXT = "Login is already taken";
    public static final String USERNAME_INVALID_ERROR_TEXT = "Username may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen";
    public static final String USERNAME_TOO_LONG_ERROR_TEXT = "Login is too long (maximum is 39 characters)";

    public static final String EMAIL_BLANK_ERROR_TEXT = "Email can't be blank";
    public static final String EMAIL_ALREADY_TAKEN_ERROR_TEXT = "Email is invalid or already taken";
    public static final String EMAIL_INVALID_ERROR_TEXT = "Email is invalid or already taken";

    public static final String PASSWORD_BLANK_ERROR_TEXT = "Password can't be blank and is too short (minimum is 7 characters)";
    public static final String PASSWORD_TOO_SHORT_ERROR_TEXT = "Password is too short (minimum is 7 characters)";
    public static final String PASSWORD_TOO_LONG_ERROR_TEXT = "Password is too long (maximum is 72 characters)";


    /*Note texts*/
    public static final String USERNAME_BLANK_NOTE_TEXT = "This will be your username. You can add the name of your organization later.";
    public static final String USERNAME_ALREADY_TAKEN_NOTE_TEXT = "Username is already taken";
    public static final String USERNAME_RESERVED_WORD_NOTE_TEXT = "Username name 'username' is a reserved word";
    public static final String USERNAME_INVALID_NOTE_TEXT = "Username may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen";

    public static final String EMAIL_STANDART_NOTE_TEXT = "We’ll occasionally send updates about your account to this inbox. We’ll never share your email address with anyone.";
    public static final String EMAIL_ALREADY_TAKEN_NOTE_TEXT = "Email is invalid or already taken";
    public static final String EMAIL_INVALID_NOTE_TEXT = "Email is invalid or already taken";

    public static final String PASSWORD_STANDART_NOTE_TEXT = "Make sure it's more than 15 characters, or at least 7 characters, including a number, and a lowercase letter.";
    public static final String PASSWORD_TYPED_NOTE_TEXT = "Make sure it's more than 15 characters, or at least 7 characters, and including a number.";
    public static final String PASSWORD_TOO_SHORT_NOTE_TEXT = "Make sure it's more than 15 characters, or at least 7 characters, and including a number.";
    public static final String PASSWORD_TOO_LONG_NOTE_TEXT = "Make sure it's more than 15 characters, or at least 7 characters, and including a number.";


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

    @FindBy (xpath = USERNAME_ERROR_XPATH)
    private WebElement usernameError;

    @FindBy (xpath = EMAIL_ERROR_XPATH)
    private WebElement emailError;

    @FindBy (xpath = PASSWORD_ERROR_XPATH)
    private WebElement passwordError;

    @FindBy (xpath = USERNAME_NOTE_XPATH)
    private WebElement usernameNote;

    @FindBy (xpath = EMAIL_NOTE_XPATH)
    private WebElement emailNote;

    @FindBy (xpath = PASSWORD_NOTE_XPATH)
    private WebElement passwordNote;



    /*Getters*/
    public WebElement getHeader() {
        return this.header;
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

    public WebElement getUsernameError() {
        return usernameError;
    }

    public WebElement getEmailError() {
        return emailError;
    }

    public WebElement getPasswordError() {
        return passwordError;
    }

    public WebElement getUsernameNote() {
        return usernameNote;
    }

    public WebElement getEmailNote() {
        return emailNote;
    }

    public WebElement getPasswordNote() {
        return passwordNote;
    }


    /*Page methods*/
    public SignUpPage typeUsername(String username) throws InterruptedException {
        usernameField.sendKeys(username);
        Thread.sleep(1000);
        return new SignUpPage(driver);
    }

    public SignUpPage typeEmail(String email) throws InterruptedException {
        emailField.sendKeys(email);
        Thread.sleep(1000);
        return new SignUpPage(driver);
    }

    public SignUpPage typePassword (String password) throws InterruptedException {
        passwordField.sendKeys(password);
        Thread.sleep(1000);
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() throws InterruptedException {
        signUpButton.click();
        Thread.sleep(1000);
        return new SignUpPage(driver);
    }

    public void register(String username, String email, String password) throws ElementDisabledException, InterruptedException {
        typeUsername(username);
        typeEmail(email);
        typePassword(password);
        clickButton(signUpButton);
        new SignUpPage(driver);
    }

    public String getHeaderText() {
        return header.getText();
    }

    public String getMainErrorText() {
        return mainError.getText();
    }

    public String getUsernameErrorText() {
        return usernameError.getText();
    }

    public String getUsernameNoteText() {
        return usernameNote.getText();
    }

    public String getEmailErrorText() {
        return emailError.getText();
    }

    public String getEmailNoteText() {
        return emailNote.getText();
    }

    public String getPasswordErrorText() {
        return passwordError.getText();
    }

    public String getPasswordNoteText() {
        return passwordNote.getText();
    }

}
