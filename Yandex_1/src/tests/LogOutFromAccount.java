package tests;

import driver.DriverProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.StartPage;

public class LogOutFromAccount extends BaseTest {

    private String password = "autotestPassword123";
    private String eMail = "AutotestLogin";

    @Test
    public void logOut() {
        //click login button
        var startPage = new StartPage();
        startPage.clickLoginButton();
        //enter email in field
        var loginPage = new LoginPage();
        loginPage.enterEmail(eMail);
        //enter password in field
        loginPage.enterPassword(password);
        //click sign in button
        loginPage.clickSignIn();
        //check that is right email on the page
        Assert.assertTrue(startPage.getUserName().equals(eMail));
        //click on the button in toolbar
        startPage.clickLogoutEmailButton();
        //click logout button in toolbar
        startPage.clickLogoutButton();
        //check url on the page
        String actualUrl = DriverProvider.Driver().getCurrentUrl();
        Assert.assertTrue(actualUrl.startsWith("https://yandex.by/"));
        Assert.assertTrue(startPage.isLoginButtonLoaded());
    }
}
