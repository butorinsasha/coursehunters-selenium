package lesson050explicitwait;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {

    static WebDriver driver;
    static WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(960, 1040));
//        driver.manage().window().setSize(new Dimension(800, 900));
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Maximum period of time driver will wait until it finds specific WebElement

        wait = new WebDriverWait(driver, 5);
    }

//    public void selectOptionFromList(String listId, String option) {
//        String listXpath = String.format("//*div[@id=\"%s\"]", "country-code-lbl-aria"); // "country-code-lbl-aria", "usernamereg-birthDate"
//        String optionXpath = String.format("//*[@id=\"usernamereg-birthDate\"]");
//    }

    @Ignore
    @Test
    public void testExplicitWaitAtYahooRegistrationPage() {
        driver.get("https://login.yahoo.com/account/create?lang=en-GB");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), \"Sign\")]")));

        WebElement shortCountryCode = driver.findElement(By.xpath("//div[contains(@class, \"country-code-dropdown\")]"));
//        WebElement shortCountryCode = driver.findElement(By.xpath("//select[@name=\"shortCountryCode\"]"));

        WebElement birthDateList = driver.findElement(By.xpath("//div[@id=\"usernamereg-birthDate\"]"));
//        WebElement birthDateList = driver.findElement(By.xpath("//select[@name=\"mm\" and @id=\"usernamereg-month\"]"));

        WebElement optionSeptember = birthDateList.findElement(By.xpath(".//option[contains(text(), \"September\")]"));
        WebElement optionJanuary = birthDateList.findElement(By.xpath(".//option[contains(text(), \"January\")]"));

        birthDateList.click();
        wait.until(ExpectedConditions.visibilityOf(optionSeptember));
        optionSeptember.click();
//        wait.until(ExpectedConditions.invisibilityOf(optionSeptember));

    }

    @Test
    public void testExplicitWaitAtFacebookRegistrationPage() throws InterruptedException {
        driver.get("https://www.facebook.com/r.php");

        String createNewAccountTitleEnXpath = "//div[contains(text(), \"Create a new account\")]";

        WebElement createNewAccountTitle = driver.findElement(By.xpath(createNewAccountTitleEnXpath));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createNewAccountTitleEnXpath)));


        String monthListXpath = "//select[@name=\"birthday_month\" and @id=\"month\"]";
        WebElement monthList = driver.findElement(By.xpath(monthListXpath));


        List<String> monthOptionsXpaths = new ArrayList<>();

        for (int i = 0; i < 13; i++) {
            monthOptionsXpaths.add(monthListXpath + "//option[@value=\"" + i + "\"]");
        }
        for (String monthOptionsXpath : monthOptionsXpaths) {
            System.out.println(monthOptionsXpath);
        }


        List<WebElement> monthOptions = new ArrayList<>();

        for (int i = 0; i < 13; i++) {
            monthOptions.add(driver.findElement(By.xpath(monthOptionsXpaths.get(i))));
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(monthOptionsXpaths.get(2)))); //it's already on the page after it loads. bad example to test explicit wait
        monthList.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(monthOptionsXpaths.get(2))));
        monthOptions.get(2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(monthOptionsXpaths.get(2)))); //it's already on the page after it loads. bad example to test explicit wait

        monthList.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(monthOptionsXpaths.get(5))));
        monthOptions.get(5).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(monthOptionsXpaths.get(5)))); //it's already on the page after it loads. bad example to test explicit wait
    }

    @Test
    public void testExplicitWaitWhenLoadingSelectYouLanguagePane() {
        driver.get("https://www.facebook.com/r.php");

        String createNewAccountTitleEnXpath = "//div[contains(text(), \"Create a new account\")]";
        String createNewAccountTitleRuXpath = "//div[contains(text(), \"Создать новый аккаунт\")]";
        String russianLanguageSelectXpath = "//div[@id=\"language_container\"]//a[text()=\"Русский\"]";
        String moreLanguageButtonXpath = "//a[@role=\"button\" and @class=\"_42ft _4jy0 _517i _517h _51sy\"]";
        String languagesPaneXpath = "//div[@class=\"_t\"]";

        WebElement createNewAccountTitleEn = driver.findElement(By.xpath(createNewAccountTitleEnXpath));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moreLanguageButtonXpath)));
        WebElement moreLanguageButton = driver.findElement(By.xpath(moreLanguageButtonXpath));
        moreLanguageButton.click();

        /*Wait is necessarily needed to wait until languagePane is loaded otherwise NoSuchElementException is thrown*/
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(languagesPaneXpath)));


        WebElement russianLanguageSelect = driver.findElement(By.xpath(russianLanguageSelectXpath));
        russianLanguageSelect.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createNewAccountTitleRuXpath)));
//        WebElement createNewAccountTitleRu = driver.findElement(By.xpath(createNewAccountTitleRuXpath));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
