import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\student\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://accounts.google.com/SignUp?service=mail&hl=ru&continue=http%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-ru");


        selectOption("Пол", "Мужской");
        selectOption("Страна", "Ангола (Angola)");

    }

    public static void selectOption(String listName, String option){
        String listXpath = String.format("(//strong[text()='%s']/following-sibling::div/div[@role='listbox'])[1]", listName);
        String optionXpath = String.format("//div[text()='%s']/parent::div[@role='option']", option);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
    }
}
