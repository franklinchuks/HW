import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class BoundaryTest {
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

        invoiceAmountField = driver.findElement(By.name("calc_d5"));
        interestRateField = driver.findElement(By.name("calc_d7"));
        commissionFeeField = driver.findElement(By.name("calc_d9"));
        WebElement advanceRateDropdown = driver.findElement(By.name("calc_d6"));
        WebElement paymentTermDropdown = driver.findElement(By.name("calc_d8"));

        advanceRateSelect = new Select(advanceRateDropdown);
        paymentTermSelect = new Select(paymentTermDropdown);
    }

    @Test(priority=7)
    public void minBoundaryTest() throws InterruptedException {
        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();

        invoiceAmountField.sendKeys("0.1");
        interestRateField.sendKeys("0");
        commissionFeeField.sendKeys("0");
        advanceRateSelect.selectByValue("75");
        paymentTermSelect.selectByValue("30");

        driver.findElement(By.xpath("//button[contains(@class, 'button -guiding')]")).click();
        Thread.sleep(5000);
    }

    @Test(priority=8)
    public void maxBoundaryTest() throws InterruptedException {
        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();

        invoiceAmountField.sendKeys("100000000");
        interestRateField.sendKeys("20");
        commissionFeeField.sendKeys("100");
        advanceRateSelect.selectByValue("90");
        paymentTermSelect.selectByValue("120");

        driver.findElement(By.xpath("//button[contains(@class, 'button -guiding')]")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
