import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
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

    //        handling cookie pop up
        WebElement cookieAcceptButton = driver.findElement(By.xpath("//button[contains(@class, 'button ui-cookie-consent__accept-button')]"));
        cookieAcceptButton.click();
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("Name: " + cookie.getName());
            System.out.println("Value: " + cookie.getValue());
            System.out.println("Cookies accepted!");
        }
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
