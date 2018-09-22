package lesson057presenceofelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementPresenceVerifier {
//    boolean isPresent;
//    String xPath;

    public static boolean isPresentByFindElementsSizeListIsGreaterThanZero(WebDriver driver, String xPath) {
        if (driver.findElements(By.xpath(xPath)).size() > 0) return true;
        else return false;
    }

}
