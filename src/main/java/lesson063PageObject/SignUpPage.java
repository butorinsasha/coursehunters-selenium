package lesson063pageobject;

import org.openqa.selenium.WebDriver;

public class SignUpPage extends Page {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
