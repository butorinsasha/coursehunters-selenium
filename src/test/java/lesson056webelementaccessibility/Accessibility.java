package lesson056webelementaccessibility;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Accessibility {
    WebDriver driver;
    JavascriptExecutor jse;
    Actions actions;
    WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        jse = (JavascriptExecutor)driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 5);

    }

    @Test
    public void testButtonIsEnabled() {
        driver.get("http://nativeformelements.com");

        WebElement button1 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/ul[19]/li[1]/button"));
        WebElement button2 = driver.findElement(By.xpath("//*[@id=\"container\"]/section/ul[19]/li[2]/button"));

        System.out.println("button1.isEnabled() = " + button1.isEnabled());
        System.out.println("button1.isEnabled() = " + button2.isEnabled());

        System.out.println();

        System.out.println("button1.isSelected() = " + button1.isSelected());
        System.out.println("button1.isSelected() = " + button2.isSelected());

        System.out.println();

        System.out.println("button1.isDisplayed() = " + button1.isDisplayed());
        System.out.println("button1.isDisplayed() = " + button2.isDisplayed());

        if (button1.isEnabled()) button1.click();
        if (button2.isEnabled()) button2.click();

        button1.click();
        button2.click();

    }

    @Test
    public void testRaiodButtonIsChecked() {
        driver.get("https://www.facebook.com/r.php");

        WebElement radioFemale = driver.findElement(By.xpath("//input[@type=\"radio\" and @value=\"1\"]"));
        WebElement radioMale = driver.findElement(By.xpath("//input[@type=\"radio\" and @value=\"2\"]"));

        Assert.assertTrue(!radioFemale.isSelected());
        Assert.assertTrue(!radioMale.isSelected());

        radioFemale.click();
        Assert.assertTrue(radioFemale.isSelected());
        Assert.assertTrue(!radioMale.isSelected());

        radioMale.click();
        Assert.assertTrue(!radioFemale.isSelected());
        Assert.assertTrue(radioMale.isSelected());

    }

    @Test
    public void testWebElemntIsDisplayed() {
        driver.get("https://www.ebay.com");

        WebElement link1 = driver.findElement(By.xpath("//ul[@class=\"hl-cat-nav__container\"]//li/a[text()=\"Электроника\"]"));
        WebElement link2 = driver.findElement(By.xpath("//a[contains(text(), \"iPhone\")]"));
        WebElement link3 = driver.findElement(By.xpath("//ul[@class=\"hl-cat-nav__container\"]//li/a[text()=\"Скидки\"]"));

        actions.moveToElement(link1).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), \"iPhone\")]")));

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        if (!link2.isDisplayed()) link2.click();
        else link3.click();
    }


    @After
    public void tearDown() throws Exception {
//        driver.quit();
    }

}
