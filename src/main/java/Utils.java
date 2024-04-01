import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

public class Utils {
    private static boolean initialized = false;

    public static void initializeSelenide() {
        if (!initialized) {
            Configuration.browser = "chrome";
            initialized = true;
        }
    }

    public static void openBrowser(String url) {
        initializeSelenide();
        open(url);
    }

    public static void closeBrowser() {
        closeWebDriver();
    }
}
