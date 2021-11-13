package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.StartPage;

public class LoginWithInvalidEmail extends BaseTest {

    private String wrongeMail = "NoAutotestUser";

    @Test
    public void invalidEmail() {
        //click login button
        var startPage = new StartPage();
        startPage.clickLoginButton();
        //enter wrong login
        var loginPage = new LoginPage();
        loginPage.enterEmail(wrongeMail);
        // check that message of wrong login is displayed
        Assert.assertTrue(loginPage.isMessageOfWrongEmailDisplay());
    }
}
