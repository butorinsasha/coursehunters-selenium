package lesson063pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Page {
    protected WebDriver driver;

    /*Constructer*/
    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*Methods*/
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Page clickButton (WebElement button) throws ElementDisabledException {
        if (button.isEnabled()) {
            button.click();
            return new Page(driver);
        } else {
            throw new ElementDisabledException("Button is disabled");
        }
    }

}
