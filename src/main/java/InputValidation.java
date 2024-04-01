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


    @Test(priority=2)
    public void firstInputValidationTest() throws InterruptedException {
        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();

        invoiceAmountField.sendKeys("a");
        interestRateField.clear();
        WebElement errorMessage1 = driver.findElement(By.id("D5"));
        if (errorMessage1.isDisplayed()) {
            System.out.println("Error message was thrown for non-numeric entries");
        } else {
            System.out.println("No message was thrown for non-numeric entries");
        }

        interestRateField.sendKeys("a");
        commissionFeeField.clear();
        WebElement errorMessage2 = driver.findElement(By.id("D7"));
        if (errorMessage2.isDisplayed()) {
            System.out.println("Error message was thrown for non-numeric entries");
        } else {
            System.out.println("No message was thrown for non-numeric entries");
        }

        commissionFeeField.sendKeys("a");
        invoiceAmountField.clear();
        WebElement errorMessage3 = driver.findElement(By.id("D8"));
        if (errorMessage3.isDisplayed()) {
            System.out.println("Error message was thrown for non-numeric entries");
        } else {
            System.out.println("No message was thrown for non-numeric entries");
        }
    }


    @Test(priority=2)
    public void secondInputValidationTest() throws InterruptedException {
        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();

        invoiceAmountField.sendKeys("-1");
        interestRateField.clear();
        WebElement errorMessage1 = driver.findElement(By.id("D5"));
        if (errorMessage1.isDisplayed()) {
            System.out.println("Error message was thrown for negative entries");
        } else {
            System.out.println("No message was thrown for negative entries");
        }

        interestRateField.sendKeys("-1");
        commissionFeeField.clear();
        WebElement errorMessage2 = driver.findElement(By.id("D7"));
        if (errorMessage2.isDisplayed()) {
            System.out.println("Error message was thrown for negative entries");
        } else {
            System.out.println("No message was thrown for negative entries");
        }

        commissionFeeField.sendKeys("-1");
        invoiceAmountField.clear();
        WebElement errorMessage3 = driver.findElement(By.id("D8"));
        if (errorMessage3.isDisplayed()) {
            System.out.println("Error message was thrown for negative entries");
        } else {
            System.out.println("No message was thrown for negative entries");
        }
    }


    @Test(priority=3)
    public void thirdInputValidationTest() throws InterruptedException {
        invoiceAmountField.clear();
        interestRateField.clear();
        commissionFeeField.clear();

        invoiceAmountField.clear();
        interestRateField.clear();
        WebElement errorMessage1 = driver.findElement(By.id("D5"));
        if (errorMessage1.isDisplayed()) {
            System.out.println("Error message was thrown for empty entries");
        } else {
            System.out.println("No message was thrown");
        }

        interestRateField.clear();
        commissionFeeField.clear();
        WebElement errorMessage2 = driver.findElement(By.id("D7"));
        if (errorMessage2.isDisplayed()) {
            System.out.println("Error message was thrown for empty entries");
        } else {
            System.out.println("No message was thrown for empty entries");
        }

        commissionFeeField.clear();
        invoiceAmountField.clear();
        WebElement errorMessage3 = driver.findElement(By.id("D8"));
        if (errorMessage3.isDisplayed()) {
            System.out.println("Error message was thrown for empty entries");
        } else {
            System.out.println("No message was thrown for empty entries");
        }

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
