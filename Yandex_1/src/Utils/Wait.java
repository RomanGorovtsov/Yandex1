package Utils;

import driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public static void ForPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.Driver(), 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void ForClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.Driver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void ForEnabled(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.Driver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable((locator))).isEnabled();
    }
}
