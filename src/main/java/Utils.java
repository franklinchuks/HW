import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            // Initialize WebDriver only if it's not already created
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the WebDriver instance
        }
    }
}
