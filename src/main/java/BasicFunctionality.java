import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.Set;

public class BasicFunctionality {
    WebDriver driver;

    @Test(priority=1)
    public void openBrowser() {
        System.setProperty("web-driver.chrome.driver", "../chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
        String actualTitle = driver.getTitle();
        System.out.println("Title Of Website: " + actualTitle);
        WebElement cookieAcceptButton = driver.findElement(By.xpath("//button[contains(@class, 'button ui-cookie-consent__accept-button')]"));
        cookieAcceptButton.click();


    }

    @Test(dependsOnMethods = {"openBrowser"})
    public void browserInputs() throws InterruptedException {
        WebElement invoiceAmountField = driver.findElement(By.name("calc_d5"));
        WebElement interestRateField = driver.findElement(By.name("calc_d7"));
        WebElement commissionFeeField = driver.findElement(By.name("calc_d9"));
        WebElement advanceRateDropdown = driver.findElement(By.name("calc_d6"));
        WebElement paymentTermDropdown = driver.findElement(By.name("calc_d8"));

        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();

        invoiceAmountField.sendKeys("700");
        interestRateField.sendKeys("4");
        commissionFeeField.sendKeys("0.5");

        Select advanceRateSelect = new Select(advanceRateDropdown);
        advanceRateSelect.selectByValue("85");

        Select paymentTermSelect = new Select(paymentTermDropdown);
        paymentTermSelect.selectByValue("120");

        Thread.sleep(3000);

//        click calculate button
        driver.findElement(By.xpath("//button[contains(@class, 'button -guiding')]")).click();

        Thread.sleep(3000);
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
