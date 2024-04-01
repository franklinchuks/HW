import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BasicFunctionality {

    //        calling utility class
    @BeforeClass
    public void setUp() {
        Utils.openBrowser("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
        $("button.ui-cookie-consent__accept-button").click();
    }

//    testing if page loads correctly
    @Test(priority = 1)
    public void basicFunctionalityTest() {
        String actualTitle = title();
        String expectedTitle = "Swedbank factoring service - Swedbank";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page opened successfully.");
        } else {
            System.out.println("Page did not open successfully.");
        }
    }

//    testing if calculate button works
    @Test(priority = 2)
    public void buttonFunctionalityTest() throws InterruptedException {
        $("button.-guiding").click();
        System.out.println("Button clicked successfully.");
    }
}
