package lesson055windows;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Window {

    public static void alertWindowHandle(WebDriver drv, JavascriptExecutor jse, long lag) {
        jse.executeScript("alert(' windowHandler = " + drv.getWindowHandle() + "');");
        try {
            Thread.sleep(lag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        drv.switchTo().alert().accept();
    }

    public static void switchToLastWindowOrTab(WebDriver drv) {
        for (String tab : drv.getWindowHandles()) {
            drv.switchTo().window(tab);
        }
    }
}
