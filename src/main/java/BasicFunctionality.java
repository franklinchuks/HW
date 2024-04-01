import org.openqa.selenium.*;
import org.testng.annotations.*;

public class BasicFunctionality {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = Utils.getWebDriver();
    }

    @Test
    public void basicFunctionality() {
        driver.get("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
        WebElement cookieAcceptButton = driver.findElement(By.xpath("//button[contains(@class, 'button ui-cookie-consent__accept-button')]"));
        cookieAcceptButton.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Swedbank factoring service - Swedbank";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page opened successfully.");
        } else {
            System.out.println("Page did not open successfully.");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
