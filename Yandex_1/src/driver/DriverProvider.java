package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverProvider {

    private static WebDriver driver;

    public static WebDriver Driver() {
        return driver;
    }

    public static void initBrowser() {
        if (driver == null);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    public static void destroy() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    public static void loadApplication(String URL) {
        driver.get(URL);
        driver.manage().window().maximize();
    }
}

