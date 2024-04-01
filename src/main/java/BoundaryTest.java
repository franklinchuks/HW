import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BoundaryTest {

    //        calling utility class
    @BeforeClass
    public void setUp() {
        Utils.openBrowser("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
    }

//    testing its behaviour with minimum inputs
    @Test(priority=7)
    public void minBoundaryTest() {
        $("#D5").setValue("0.1");
        $("#D7").setValue("0");
        $("#D9").setValue("0");
        $("#D6").selectOptionByValue("75");
        $("#D8").selectOptionByValue("30");

        $("button.button.-guiding").click();
        sleep(3000);
    }

    //    testing its behaviour with maximum inputs
    @Test(priority=8)
    public void maxBoundaryTest() {
        $("#D5").setValue("1000000000");
        $("#D7").setValue("20");
        $("#D9").setValue("100");
        $("#D6").selectOptionByValue("90");
        $("#D8").selectOptionByValue("120");

        $("button.button.-guiding").click();
        sleep(3000);
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}
