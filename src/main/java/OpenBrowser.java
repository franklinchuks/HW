import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

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
