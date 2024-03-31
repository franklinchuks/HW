import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    WebDriver driver;

    @Test(priority=1)
    public void openBrowser() {
        System.setProperty("web-driver.chrome.driver", "../chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
        String actualTitle = driver.getTitle();
        System.out.println("Title Of Website: " + actualTitle);

        //        handling cookie pop up
        try {
            WebElement cookieAcceptButton = driver.findElement(By.xpath("//button[contains(@class, 'button ui-cookie-consent__accept-button')]"));
            cookieAcceptButton.click();
            Set<Cookie> cookies = driver.manage().getCookies();
            for (Cookie cookie : cookies) {
                System.out.println("Name: " + cookie.getName());
                System.out.println("Value: " + cookie.getValue());
            }
            System.out.println("Cookies accepted!");
        } catch (Exception e) {
            System.out.println("Could not find cookie button.");
        }
    }


    @Test(dependsOnMethods = {"openBrowser"})
    public void browserInputs() throws InterruptedException {
        WebElement invoiceAmountField = driver.findElement(By.name("calc_d5"));
        invoiceAmountField.sendKeys("700");

        Thread.sleep(5000);
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
