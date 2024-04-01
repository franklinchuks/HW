import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class CalculationAccuracy {
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

        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();
        advanceRateSelect = new Select(advanceRateDropdown);
        paymentTermSelect = new Select(paymentTermDropdown);
    }

    @Test(priority=6)
    public void calculationAccuracyTest() throws InterruptedException {
        invoiceAmountField.sendKeys("700");
        interestRateField.sendKeys("4");
        commissionFeeField.sendKeys("0.3");
        advanceRateSelect.selectByValue("85");
        paymentTermSelect.selectByValue("30");

        driver.findElement(By.xpath("//button[contains(@class, 'button -guiding')]")).click();
        Thread.sleep(5000);

        WebElement percentOfInvoiceOutputField = driver.findElement(By.id("result_perc"));
        String percentOfInvoiceOutputText = percentOfInvoiceOutputField.getText();
        System.out.println("Percent Of Invoice Output value: " + percentOfInvoiceOutputText);
        String expectedPercentOfInvoiceOutputText = "0.58";
        if (percentOfInvoiceOutputText.equals(expectedPercentOfInvoiceOutputText))
        {
            System.out.println("*** Percent Of Invoice Test Is Correct! ***");
        } else {
            System.out.println("### Percent Of Invoice Test Is Incorrect! ###");
        }

        WebElement financingOfInvoiceOutputField = driver.findElement(By.id("result"));
        String financingOfInvoiceOutputText = financingOfInvoiceOutputField.getText();
        System.out.println("Financing Of Invoice Output value: " + financingOfInvoiceOutputText);
        String expectedFinancingOfInvoiceOutputText = "4.08";
        if (financingOfInvoiceOutputText.equals(expectedFinancingOfInvoiceOutputText)) {
            System.out.println("*** Financing Of Invoice Test Is Correct! ***");
        } else {
            System.out.println("### Financing Of Invoice Test Is Incorrect! ###");
        }
    }

}
