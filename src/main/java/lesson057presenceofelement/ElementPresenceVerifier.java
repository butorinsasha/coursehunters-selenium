package lesson057presenceofelement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementPresenceVerifier {
//    boolean isPresent;
//    String xPath;

//    public static boolean isPresentByFindElementsSizeListIsGreaterThanZero(WebDriver driver, String xPath) {
//        if (driver.findElements(By.xpath(xPath)).size() > 0) return true;
//        else return false;
//    }

    public static boolean isPresentByFindElementsSizeListIsGreaterThanZero(WebDriver driver, By by) {
        if (driver.findElements(by).size() > 0) return true;
        else return false;
    }

    public static boolean isPresentByNoSuchElementExceptionHandling(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isPresentByPresenceOfElementLocated(WebDriver driver, WebDriverWait wait, By by) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}
