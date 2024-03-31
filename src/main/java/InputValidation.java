import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class InputValidation {

    WebDriver driver;

    @Test(priority = 2)
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
}
