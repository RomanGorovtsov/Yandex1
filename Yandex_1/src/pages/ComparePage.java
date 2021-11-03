package pages;
import Utils.Wait;
import driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComparePage {

    public static final By COMPARE_ZONE_LOCATOR = By.xpath("//div[@data-apiary-widget-name='@MarketNode/CompareContent']//div[@class='_1P4gD _34m6b']");
    public static final By ELEMENTS_TO_COMPARE = By.xpath ("//div[@class='Lwwoc _2VGDF']");
    public static final By CLEAR_LIST_OF_COMPARE_BUTTON = By.xpath ("//div//button[@class='_1KpjX _1KU3s']");
    public static final By IMAGINE_OF_CLEAR_COMPARE_LIST = By.xpath("//img[@src='//yastatic.net/market-export/_/i/zero-state/compare.svg']");

    private WebElement getCompareZoneElement()
    {
        return DriverProvider.Driver().findElement(COMPARE_ZONE_LOCATOR);
    }

    public List<WebElement> getElementsForComparison(){
        var compareElements =  getCompareZoneElement().findElements(ELEMENTS_TO_COMPARE);
        return compareElements;
    }

    public void clickClearListButton() {
        Wait.ForPresent(CLEAR_LIST_OF_COMPARE_BUTTON);
        DriverProvider.Driver().findElement(CLEAR_LIST_OF_COMPARE_BUTTON).click();
    }

    public boolean isImagineOfClearCompareListIsDisplayed() {
        Wait.ForPresent(IMAGINE_OF_CLEAR_COMPARE_LIST);
        return DriverProvider.Driver().findElement(IMAGINE_OF_CLEAR_COMPARE_LIST).isDisplayed();
    }
}
