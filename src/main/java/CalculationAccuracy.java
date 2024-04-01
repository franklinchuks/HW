import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CalculationAccuracy {

    @BeforeClass
    public void setUp() {
        Utils.openBrowser("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
    }

    @Test(priority=6)
    public void calculationAccuracyTest() {
        $("#D5").setValue("1700");
        $("#D7").setValue("2");
        $("#D9").setValue("0.3");
        $("#D6").selectOptionByValue("85");
        $("#D8").selectOptionByValue("30");

        $("button.button.-guiding").click();
        sleep(5000);

        try {
            $("#result_perc").shouldHave(text("0.44"));
            System.out.println("*** Percent Of Invoice Test Is Correct! ***");
        } catch (Throwable e) {
            System.out.println("### Percent Of Invoice Test Failed! ###");
            e.printStackTrace();
        }

        try {
            $("#result").shouldHave(text("7.51"));
            System.out.println("*** Financing Of Invoice Test Is Correct! ***");
        } catch (Throwable e) {
            System.out.println("### Financing Of Invoice Test Failed! ###");
            e.printStackTrace();
        }
    }
}
