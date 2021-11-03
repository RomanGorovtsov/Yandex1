package pages;
import Utils.Wait;
import driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage {

    private static final By EMAIL_FIELD = By.xpath("//div//input[@class='Textinput-Control']");
    public static final By PASSWORD_FIELD = By.xpath("//div//input[@data-t='field:input-passwd']");
    public static final By LOGIN_BTN = By.xpath("//div//button[@data-t='button:action:passp:sign-in']");
    public static final By WRONG_PASSWORD_LOCATOR = By.xpath("//div[@id='field:input-passwd:hint']");
    public static final By WRONG_EMAIL_LOCATOR = By.xpath("//div[contains(text(),'Такого аккаунта нет')]");

    public void enterEmail(String email) {
        DriverProvider.Driver().findElement(EMAIL_FIELD).sendKeys(email, Keys.ENTER);
        Wait.ForPresent(EMAIL_FIELD);
    }

    public void enterPassword(String password) {
        Wait.ForPresent(PASSWORD_FIELD);
        DriverProvider.Driver().findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public StartPage clickSignIn() {
        Wait.ForPresent(LOGIN_BTN);
        DriverProvider.Driver().findElement(LOGIN_BTN).click();
        return new StartPage();
    }
    public boolean isMessageOfWrongPasswordDisplay() {
        Wait.ForPresent(WRONG_PASSWORD_LOCATOR);
        return DriverProvider.Driver().findElement(WRONG_PASSWORD_LOCATOR).isDisplayed();
    }
    public boolean isMessageOfWrongEmailDisplay() {
        Wait.ForPresent(WRONG_EMAIL_LOCATOR);
        return DriverProvider.Driver().findElement(WRONG_EMAIL_LOCATOR).isDisplayed();
    }
}
