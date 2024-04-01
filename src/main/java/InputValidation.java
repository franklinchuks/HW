import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class InputValidation {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = Utils.getWebDriver();
    }

    @Test
    public void inputValidation() throws InterruptedException {
        driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
        WebElement cookieAcceptButton = driver.findElement(By.xpath("//button[contains(@class, 'button ui-cookie-consent__accept-button')]"));
        cookieAcceptButton.click();

        WebElement invoiceAmountField = driver.findElement(By.name("calc_d5"));
        WebElement interestRateField = driver.findElement(By.name("calc_d7"));
        WebElement commissionFeeField = driver.findElement(By.name("calc_d9"));
        WebElement advanceRateDropdown = driver.findElement(By.name("calc_d6"));
        WebElement paymentTermDropdown = driver.findElement(By.name("calc_d8"));

        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();

        invoiceAmountField.sendKeys("7");
        interestRateField.sendKeys("4");
        commissionFeeField.sendKeys("0.5");

        Select advanceRateSelect = new Select(advanceRateDropdown);
        advanceRateSelect.selectByValue("85");

        Select paymentTermSelect = new Select(paymentTermDropdown);
        paymentTermSelect.selectByValue("120");

        Thread.sleep(3000);

//        click calculate button
        driver.findElement(By.xpath("//button[contains(@class, 'button -guiding')]")).click();

        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
