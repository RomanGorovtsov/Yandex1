package pages;

import Utils.Wait;
import driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.LinkedList;
import java.util.List;

public class MarketPage {
    public static final By MARKET_SEARCH_FIELD_LOCATOR = By.xpath("//div//input[@id='header-search']");
    public static final By ACCOUNT_FIELD_LOCATOR = By.xpath("//div[@class='_3RDrv _1Vd4y']");
    public static final By COMPARE_BUTTON_LOCATOR = By.xpath("//a[@href='/compare?track=menu']");
    public static final By ACTION_CAMERAS_BUTTON_LOCATOR = By.xpath("//a[text()='Экшн-камеры']");
    public static final By SORT_CAMERAS_BY_PRICE_BUTTON = By.xpath("//div//button[@class='_23p69 _3D8AA']");
    public static final By PRICES_OF_CAMERAS = By.xpath("//div[@class='_3NaXx _33ZFz _2m5MZ c5gK7']//span/span");
    public static final By SECTION_PANEL = By.xpath("//div[@data-apiary-widget-name='@MarketNode/HeaderTabs']");
    public static final By LIST_VIEW_BUTTON = By.xpath("//label[@class='_1AaH5']//input[@value='list']");
    public static final By LIST_IN_HOUSEHOLD_APPLIANCE = By.xpath("//div[@data-tid='cb168a42']");
    public static final By WIDTH_TILL_LOCATOR = By.xpath("//input[@name='Ширина до']");
    public static final By FRIDGE_SIZE_LOCATOR = By.xpath("//div//li[contains(text(), 'ШхВхГ')]");

    public MarketPage searchInMarketField(String Note8) {
        Wait.ForPresent(MARKET_SEARCH_FIELD_LOCATOR);
        DriverProvider.Driver().findElement(MARKET_SEARCH_FIELD_LOCATOR).sendKeys(Note8, Keys.ENTER);
        return new MarketPage();
    }

    public void selectListView() {
        if (!AreDevicesDisplayedAsList()) {
            DriverProvider.Driver().findElement(LIST_VIEW_BUTTON).click();
        }
    }

    public void chooseDevice(int[] deviceNumber) {
        if (!AreDevicesDisplayedAsList()) {
            DriverProvider.Driver().findElement(LIST_VIEW_BUTTON).click();
        }

        for (var device : deviceNumber) {
            if (!IsDeviceAddedToCompareList(device)) {
                var deviceArea = GetDeviceArea(device);
                Wait.ForPresent(By.xpath("//div[@data-tid='b9e1d6c3']"));
                var compareButton = deviceArea.findElement(By.xpath(".//div[@data-tid='b9e1d6c3']"));
                compareButton.click();
            }
        }
    }

    public Boolean AreDevicesDisplayedAsList() {
        Wait.ForPresent(LIST_VIEW_BUTTON);
        var containedClasses = DriverProvider.Driver().findElement(LIST_VIEW_BUTTON).findElement(By.xpath("./following-sibling::span")).getAttribute("class");
        var result = containedClasses.contains("wXibA");
        return result;
    }

    public WebElement GetDeviceArea(int deviceNumber) {
        var deviceLocator = By.xpath(String.format("//article[%s]", deviceNumber));
        Wait.ForClickable(deviceLocator);
        var deviceArea = DriverProvider.Driver().findElement(deviceLocator);
        return deviceArea;
    }

    public Boolean IsDeviceAddedToCompareList(int deviceNumber) {
        var deviceArea = GetDeviceArea(deviceNumber);
        var comparisonButton = deviceArea.findElement(By.xpath(".//div[@data-tid='b9e1d6c3']/parent::div"));
        var containedClasses = comparisonButton.getAttribute("class");

        return containedClasses.contains("_2Es7h");
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

    public void chooseAppliancesInHouseholdAppliances(String SectionName) {
        Wait.ForPresent(LIST_IN_HOUSEHOLD_APPLIANCE);

        var sectionElement = DriverProvider.Driver().findElement(LIST_IN_HOUSEHOLD_APPLIANCE);
        var locatorPattern = (".//a[text()=%s]");
        //a[text()='Холодильники']
        var section = sectionElement.findElement(By.xpath(String.format(locatorPattern, SectionName)));
        section.click();
    }


    public void clickOnActionCamerasButton() {
        //TO DO: WAIT FOR SECTION TO APPEAR
        Wait.ForPresent(ACTION_CAMERAS_BUTTON_LOCATOR);
        DriverProvider.Driver().findElement(ACTION_CAMERAS_BUTTON_LOCATOR).click();
    }

    public void clickOnTheSortByPriceButton() {
        Wait.ForPresent(SORT_CAMERAS_BY_PRICE_BUTTON);
        //DriverProvider.Driver().findElement(SORT_CAMERAS_BY_PRICE_BUTTON).click();
        Actions actions = new Actions(DriverProvider.Driver());
        WebElement sortCamerasByPrise = DriverProvider.Driver().findElement(SORT_CAMERAS_BY_PRICE_BUTTON);
        actions.doubleClick(sortCamerasByPrise).perform();
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

    public MarketPage selectTheWidthOfFridge() {
        Wait.ForPresent(WIDTH_TILL_LOCATOR);
        String widthOfFridge = "50";
        DriverProvider.Driver().findElement(WIDTH_TILL_LOCATOR).sendKeys(widthOfFridge);
        return new MarketPage();
    }

}
