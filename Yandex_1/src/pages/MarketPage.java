package pages;

import Utils.Wait;
import driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MarketPage {
    public static final By MARKET_SEARCH_FIELD_LOCATOR = By.xpath("//div//input[@id='header-search']");
    //    public static final By FIRST_ELEMENTS_FIELD_LOCATOR = By.xpath("//article[@class='_2vCnw cia-vs cia-cs'][1]//div[@data-tid='b9e1d6c3']");
//    public static final By SECOND_ELEMENTS_FIELD_LOCATOR = By.xpath("//article[@class='_2vCnw cia-vs cia-cs'][2]//div[@data-tid='b9e1d6c3']");
    public static String ELEMENTS_FIELD_LOCATOR = "//article[@class='_2vCnw cia-vs cia-cs'][%s]//div[@data-tid='b9e1d6c3']";
    public static String ELEMENTS_FIELD_LOCATOR_WITH_NO_NUMBER = "//article[@class='_2vCnw cia-vs cia-cs']//div[@data-tid='b9e1d6c3']";
    public static String FIRST_DEVICE_FOR_COMPARE = "1";
    public static String SECOND_DEVICE_FOR_COMPARE = "2";
    public static final By ACCOUNT_FIELD_LOCATOR = By.xpath("//div[@class='_3RDrv _1Vd4y']");
    public static final By COMPARE_BUTTON_LOCATOR = By.xpath("//a[@href='/compare?track=menu']");
    public static final By ACTION_CAMERAS_BUTTON_LOCATOR = By.xpath("//a[text()='Экшн-камеры']");
    public static final By ACTION_CAMERAS_2_BUTTON_LOCATOR = By.xpath("//a[text()='Экшн-камеры']");
    public static final By SORT_CAMERAS_BY_PRICE_BUTTON = By.xpath("//div//button[@class='_23p69 _3D8AA']");
    public static final By PRICES_OF_CAMERAS = By.xpath("//div[@class='_3NaXx _33ZFz _2m5MZ c5gK7']//span/span");
    public static final By SECTION_PANEL = By.xpath("//div[@data-apiary-widget-name='@MarketNode/HeaderTabs']");
    public static final By LIST_VIEW_BUTTON = By.xpath("//label[@class='_1AaH5']//input[@value='list']");

    public MarketPage searchInMarketField(String Note8) {
        Wait.ForPresent(MARKET_SEARCH_FIELD_LOCATOR);
        DriverProvider.Driver().findElement(MARKET_SEARCH_FIELD_LOCATOR).sendKeys(Note8, Keys.ENTER);
        return new MarketPage();
    }

    public void chooseDevice() {
        if (!AreDevicesDisplayedAsList()) {
            DriverProvider.Driver().findElement(LIST_VIEW_BUTTON).click();
        } else {
            Wait.ForPresent(By.xpath(String.format(ELEMENTS_FIELD_LOCATOR, FIRST_DEVICE_FOR_COMPARE)));
            Wait.ForPresent(By.xpath(String.format(ELEMENTS_FIELD_LOCATOR, SECOND_DEVICE_FOR_COMPARE)));
            DriverProvider.Driver().findElement(By.xpath(String.format(ELEMENTS_FIELD_LOCATOR, FIRST_DEVICE_FOR_COMPARE))).click();
            DriverProvider.Driver().findElement(By.xpath(String.format(ELEMENTS_FIELD_LOCATOR, SECOND_DEVICE_FOR_COMPARE))).click();
        }
    }

    public Boolean AreDevicesAddedToCompareList(){
        var addedToCompare = DriverProvider.Driver().findElement(LIST_VIEW_BUTTON).findElement(By.xpath("//article[@class='_2vCnw cia-vs cia-cs']//div[@data-tid='b9e1d6c3']")).getAttribute("class");
        var result = addedToCompare.contains("_2Es7h RN9hX");

    }

    public Boolean AreDevicesDisplayedAsList() {
        Wait.ForPresent(LIST_VIEW_BUTTON);
        var containedClasses = DriverProvider.Driver().findElement(LIST_VIEW_BUTTON).findElement(By.xpath("./following-sibling::span")).getAttribute("class");
        var result = containedClasses.contains("wXibA");
        return result;
    }


    public void clickOnAccountField() {
        Wait.ForPresent(ACCOUNT_FIELD_LOCATOR);
        DriverProvider.Driver().findElement(ACCOUNT_FIELD_LOCATOR).click();
    }

    public MarketPage clickOnCompareButtonField() {
        Wait.ForPresent(COMPARE_BUTTON_LOCATOR);
        DriverProvider.Driver().findElement(COMPARE_BUTTON_LOCATOR).click();
        return new MarketPage();
    }

    public void selectSection(String SectionName) {
        Wait.ForPresent(SECTION_PANEL);

        var sectionElement = DriverProvider.Driver().findElement(SECTION_PANEL);
        var locatorPattern = (".//span[text()=%s]");
        var section = sectionElement.findElement(By.xpath(String.format(locatorPattern, SectionName)));
        section.click();
    }

    public void clickOnActionCamerasButton() {
        //TO DO: WAIT FOR SECTION TO APPEAR
        Wait.ForPresent(ACTION_CAMERAS_BUTTON_LOCATOR);
        DriverProvider.Driver().findElement(ACTION_CAMERAS_BUTTON_LOCATOR).click();
    }

    public void clickOnActionCamerasButton2() {
        Wait.ForPresent(ACTION_CAMERAS_2_BUTTON_LOCATOR);
        DriverProvider.Driver().findElement(ACTION_CAMERAS_2_BUTTON_LOCATOR).click();
    }

    public void clickOnTheSortByPriceButton() {
        Wait.ForPresent(SORT_CAMERAS_BY_PRICE_BUTTON);
        DriverProvider.Driver().findElement(SORT_CAMERAS_BY_PRICE_BUTTON).click();
    }

    public List<Integer> getAllDevicesPrices() {

        var devicesPrices = DriverProvider.Driver().findElements(PRICES_OF_CAMERAS);
        var ListOfDevices = new LinkedList<Integer>();
        for (WebElement device : devicesPrices) {
            var price = Integer.parseInt(device.getText());
            ListOfDevices.add(price);
        }
        return ListOfDevices;
    }
}
