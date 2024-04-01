import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class InputValidation {

    //        calling utility class
    @BeforeClass
    public void setUp() {
        Utils.openBrowser("https://www.swedbank.lt/business/finance/trade/factoring?language=ENG");
    }

//    to test if non-numeric inputs shows error info
    @Test(priority = 3)
    public void firstInputValidationTest() {
        $("#D5").setValue("a");
        $("#D7").setValue("a");
        $("#D9").setValue("a");

//        using border-color to check if error was shown
        String D5 = $("#D5").getCssValue("border-color");
        String D7 = $("#D7").getCssValue("border-color");
        String D9 = $("#D9").getCssValue("border-color");
        if (D5.equalsIgnoreCase("rgb(197, 19, 28)") || D7.equalsIgnoreCase("rgb(197, 19, 28)") || D9.equalsIgnoreCase("rgb(197, 19, 28)")) {
            System.out.println("Error shown for non-numeric inputs");
        } else {
            System.out.println("No error shown for non-numeric inputs");
        }
    }

    //    to test if negative inputs shows error info
    @Test(priority = 4)
    public void secondInputValidationTest() {
        $("#D5").setValue("-1");
        $("#D7").setValue("-1");
        $("#D9").setValue("-1");

//        using border-color to check if error was shown
        String D5 = $("#D5").getCssValue("border-color");
        String D7 = $("#D7").getCssValue("border-color");
        String D9 = $("#D9").getCssValue("border-color");
        if (D5.equalsIgnoreCase("rgb(197, 19, 28)") || D7.equalsIgnoreCase("rgb(197, 19, 28)") || D9.equalsIgnoreCase("rgb(197, 19, 28)")) {
            System.out.println("Error shown for negative inputs");
        } else {
            System.out.println("No error shown for negative inputs");
        }
    }

    //    to test if empty inputs shows error info
    @Test(priority = 5)
    public void thirdInputValidationTest() {
        $("#D5").setValue("");
        $("#D7").setValue("");
        $("#D9").setValue("");
        $("#D7").clear();

//        using border-color to check if error was shown
        String D5 = $("#D5").getCssValue("border-color");
        String D7 = $("#D7").getCssValue("border-color");
        String D9 = $("#D9").getCssValue("border-color");
        if (D5.equalsIgnoreCase("rgb(197, 19, 28)") || D7.equalsIgnoreCase("rgb(197, 19, 28)") || D9.equalsIgnoreCase("rgb(197, 19, 28)")) {
            System.out.println("Error shown for empty fields");
        } else {
            System.out.println("No error shown for empty fields");
        }
    }
}
