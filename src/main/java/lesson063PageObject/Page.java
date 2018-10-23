package lesson063pageobject;

import org.openqa.selenium.WebDriver;

public class Page {
    private WebDriver driver;

    public Page() {}

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }
}
