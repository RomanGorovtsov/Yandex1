package pages;

import Utils.Wait;
import driver.DriverProvider;
import org.openqa.selenium.By;

public class StartPage {
    public static final By LOGIN_BUTTON_LOCATOR = By.xpath("//div[@class='desk-notif-card__login-new-items']//a[@target='_self']");
    public static final By USER_NAME = By.xpath("//span[contains(@class,'username')]");
    public static final By LOGOUT_BUTTON = By.xpath("//a[ @aria-label='Выйти']");
    public static final By LOGOUT_EMAIL_LOCATOR = By.xpath("//div[@class='desk-notif-card__title']");
    public static final By VIDEO_LOCATOR = By.xpath("//div//a[@href='https://yandex.by/video?utm_source=main_stripe_big']");
    public static final By PICTURES_LOCATOR = By.xpath("//div//LI[@class='services-new__list-item']//a[@data-id='images']");
    public static final By NEWS_LOCATOR = By.xpath("//div//li[@class='services-new__list-item']//a[@data-id='news']");
    public static final By MAPS_LOCATOR = By.xpath("//div//li[@class='services-new__list-item']//a[@data-id='maps']");
    public static final By MARKET_LOCATOR = By.xpath("//div//li[@class='services-new__list-item']//a[@data-id='market']");
    public static final By TRANSLATE_LOCATOR = By.xpath("//div//li[@class='services-new__list-item']//a[@data-id='translate']");
    public static final By MUSIC_LOCATOR = By.xpath("//div//li[@class='services-new__list-item']//a[@data-id='music']");
    public static final By LANGUAGE_LOCATOR = By.xpath("//div//a[@title='Выбрать язык']");
    public static final By BEL_LANGUAGE_LOCATOR = By.xpath("//span[contains(text(), 'Bel')]");
    public static final By BEL_LOGIN_LOCATOR = By.xpath("//div[contains(text(), 'Увайсці')]");

    public boolean isLoginButtonLoaded() {
        Wait.ForPresent(LOGIN_BUTTON_LOCATOR);
        return DriverProvider.Driver().findElement(LOGIN_BUTTON_LOCATOR).isDisplayed();
    }

    public LoginPage clickLoginButton() {
        Wait.ForPresent(LOGIN_BUTTON_LOCATOR);
        DriverProvider.Driver().findElement(LOGIN_BUTTON_LOCATOR).click();
        return new LoginPage();
    }

    public LoginPage clickLogoutButton() {
        Wait.ForPresent(LOGOUT_BUTTON);
        DriverProvider.Driver().findElement(LOGOUT_BUTTON).click();
        return new LoginPage();
    }

    public String getUserName() {
        Wait.ForPresent(USER_NAME);
        return DriverProvider.Driver().findElement(USER_NAME).getText();
    }

    public StartPage clickLogoutEmailButton() {
        Wait.ForPresent(LOGOUT_EMAIL_LOCATOR);
        DriverProvider.Driver().findElement(LOGOUT_EMAIL_LOCATOR).click();
        return new StartPage();
    }

    public StartPage clickVideoButton() {
        Wait.ForPresent(VIDEO_LOCATOR);
        DriverProvider.Driver().findElement(VIDEO_LOCATOR).click();
        return new StartPage();
    }

    public StartPage clickImagineButton() {
        Wait.ForPresent(PICTURES_LOCATOR);
        DriverProvider.Driver().findElement(PICTURES_LOCATOR).click();
        return new StartPage();
    }

    public StartPage clickNewsButton() {
        Wait.ForPresent(NEWS_LOCATOR);
        DriverProvider.Driver().findElement(NEWS_LOCATOR).click();
        return new StartPage();
    }

    public StartPage clickMapsButton() {
        Wait.ForPresent(MAPS_LOCATOR);
        DriverProvider.Driver().findElement(MAPS_LOCATOR).click();
        return new StartPage();
    }

    public MarketPage clickMarketButton() {
        Wait.ForPresent(MARKET_LOCATOR);
        DriverProvider.Driver().findElement(MARKET_LOCATOR).click();
        return new MarketPage();
    }

    public StartPage clickTranslateButton() {
        Wait.ForPresent(TRANSLATE_LOCATOR);
        DriverProvider.Driver().findElement(TRANSLATE_LOCATOR).click();
        return new StartPage();
    }

    public StartPage clickMusicButton() {
        Wait.ForPresent(MUSIC_LOCATOR);
        DriverProvider.Driver().findElement(MUSIC_LOCATOR).click();
        return new StartPage();
    }

    public StartPage clickChooseLanguageButton() {
        Wait.ForPresent(LANGUAGE_LOCATOR);
        DriverProvider.Driver().findElement(LANGUAGE_LOCATOR).click();
        return new StartPage();
    }

    public StartPage clickBelarussianLanguageButton() {
        Wait.ForPresent(BEL_LANGUAGE_LOCATOR);
        DriverProvider.Driver().findElement(BEL_LANGUAGE_LOCATOR).click();
        return new StartPage();
    }

    public boolean isBelarussianLanguagePageLoaded() {
        return DriverProvider.Driver().findElement(BEL_LOGIN_LOCATOR).isDisplayed();
    }
}
