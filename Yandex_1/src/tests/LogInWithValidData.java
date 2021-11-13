package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.StartPage;

public class LogInWithValidData extends BaseTest {

    private String password = "autotestPassword123";
    private String eMail = "AutotestLogin";

    @Test
    public void logIn() {
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
    }
}
