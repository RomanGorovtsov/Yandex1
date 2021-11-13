package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.StartPage;

public class LogInWithInvalidPassword extends BaseTest {

    private String wrongpassword = "NoAutotestPassword";
    private String eMail = "AutotestLogin";

    @Test
    public void invalidPassword() {
        //click login button
        var startPage = new StartPage();
        startPage.clickLoginButton();
        //enter email button
        var loginPage = new LoginPage();
        loginPage.enterEmail(eMail);
        //enter wrong password
        loginPage.enterPassword(wrongpassword);
        //click sign in button
        loginPage.clickSignIn();
        // check that message of wrong password is displayed
        Assert.assertTrue(loginPage.isMessageOfWrongPasswordDisplay());
    }
}
