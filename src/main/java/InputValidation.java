import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class InputValidation {
    private WebDriver driver;
    private WebElement invoiceAmountField;
    private WebElement interestRateField;
    private WebElement commissionFeeField;
    private Select advanceRateSelect;
    private Select paymentTermSelect;

    @BeforeClass
    public void setUp() {
        driver = Utils.getWebDriver();
        driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
        WebElement cookieAcceptButton = driver.findElement(By.xpath("//button[contains(@class, 'button ui-cookie-consent__accept-button')]"));
        cookieAcceptButton.click();

        invoiceAmountField = driver.findElement(By.name("calc_d5"));
        interestRateField = driver.findElement(By.name("calc_d7"));
        commissionFeeField = driver.findElement(By.name("calc_d9"));
        WebElement advanceRateDropdown = driver.findElement(By.name("calc_d6"));
        WebElement paymentTermDropdown = driver.findElement(By.name("calc_d8"));

        advanceRateSelect = new Select(advanceRateDropdown);
        paymentTermSelect = new Select(paymentTermDropdown);
    }

    @Test(priority=1)
    public void firstInputValidationTest() throws InterruptedException {
        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();

        invoiceAmountField.sendKeys("7");
        interestRateField.sendKeys("4");
        commissionFeeField.sendKeys("0.5");
        advanceRateSelect.selectByValue("85");
        paymentTermSelect.selectByValue("120");

        driver.findElement(By.xpath("//button[contains(@class, 'button -guiding')]")).click();
        Thread.sleep(5000);
    }

    @Test(priority=2)
    public void secondInputValidationTest() throws InterruptedException {
        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();

        invoiceAmountField.sendKeys("5");
        interestRateField.sendKeys("2");
        commissionFeeField.sendKeys("0.5");
        advanceRateSelect.selectByValue("90");
        paymentTermSelect.selectByValue("60");

        driver.findElement(By.xpath("//button[contains(@class, 'button -guiding')]")).click();
        Thread.sleep(5000);
    }

    @Test(priority=3)
    public void thirdInputValidationTest() throws InterruptedException {
        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();

        invoiceAmountField.sendKeys("3");
        interestRateField.sendKeys("2");
        commissionFeeField.sendKeys("0.1");
        advanceRateSelect.selectByValue("75");
        paymentTermSelect.selectByValue("30");

        driver.findElement(By.xpath("//button[contains(@class, 'button -guiding')]")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
