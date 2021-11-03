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


    //public static void ForPresents(By locator, int index) {
    //        WebDriverWait wait = new WebDriverWait(DriverProvider.Driver(), 15);
    //
    //        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    //        List<WebElement> elements = DriverProvider.Driver().findElements();
    //        elements.get(1)
}
