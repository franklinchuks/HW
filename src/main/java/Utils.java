import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

//utility class to be reused
public class Utils {
    private static boolean initialized = false;

    //    initializing
    public static void initializeSelenide() {
        if (!initialized) {
            Configuration.browser = "chrome";
            initialized = true;
        }
    }

//    open url
    public static void openBrowser(String url) {
        initializeSelenide();
        open(url);
    }

//    exit browser
    public static void closeBrowser() {
        closeWebDriver();
    }
}
