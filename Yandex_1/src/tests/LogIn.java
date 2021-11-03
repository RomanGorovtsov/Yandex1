package tests;

import Utils.Helpers.SwitchTab;
import driver.DriverProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn extends BaseTest {

    private String password = "autotestPassword123";
    private String wrongpassword = "NoAutotestPassword";
    private String wrongeMail = "NoAutotestUser";
    private String eMail = "AutotestLogin";

    @Test
    public void logIn(){
        //click login button
        startPage.clickLoginButton();
        //enter email in field
        loginPage.enterEmail(eMail);
        //enter password in field
        loginPage.enterPassword(password);
        //click sign in button
        loginPage.clickSignIn();
        //check that is right email on the page
        Assert.assertTrue(startPage.getUserName().equals(eMail));
    }

    @Test
    public void logOut(){
        //click login button
        startPage.clickLoginButton();
        //enter email in field
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

    @Test
    public void invalidPassword(){
        //click login button
        startPage.clickLoginButton();
        //enter email button
        loginPage.enterEmail(eMail);
        //enter wrong password
        loginPage.enterPassword(wrongpassword);
        //click sign in button
        loginPage.clickSignIn();
        // check that message of wrong password is displayed
        Assert.assertTrue(loginPage.isMessageOfWrongPasswordDisplay());
    }

    @Test
    public void invalidEmail(){
        //click login button
        startPage.clickLoginButton();
        //enter wrong login
        loginPage.enterEmail(wrongeMail);
        // check that message of wrong login is displayed
        Assert.assertTrue(loginPage.isMessageOfWrongEmailDisplay());
    }

    @Test
    public void jumpToSections(){
        //click on Video page
        startPage.clickVideoButton();
        //switch on the second page
        SwitchTab.To(2);
        //check current URL
        String actualUrl = DriverProvider.Driver().getCurrentUrl();
        Assert.assertTrue(actualUrl.startsWith("https://yandex.by/video/"));
        //close the browser
        DriverProvider.Driver().close();
        //go bach on the first tab
        SwitchTab.To(1);
        //switch on Imagine page and check
        startPage.clickImagineButton();
        //switch on the second page
        SwitchTab.To(2);
        //check current URL
        String actualUrl2 = DriverProvider.Driver().getCurrentUrl();
        Assert.assertTrue(actualUrl2.startsWith("https://yandex.by/images/"));
        DriverProvider.Driver().close();
        //go bach on the first tab
        SwitchTab.To(1);
        //switch on News page and check
        startPage.clickNewsButton();
        //switch on the second page
        SwitchTab.To(2);
        //check current URL
        String actualUrl3 = DriverProvider.Driver().getCurrentUrl();
        Assert.assertTrue(actualUrl3.startsWith("https://yandex.by/news/"));
        DriverProvider.Driver().close();
        //go bach on the first tab
        SwitchTab.To(1);
        //switch on Maps page and check
        startPage.clickMapsButton();
        //switch on the second page
        SwitchTab.To(2);
        //check current URL
        String actualUrl4 = DriverProvider.Driver().getCurrentUrl();
        Assert.assertTrue(actualUrl4.startsWith("https://yandex.by/maps/"));
        DriverProvider.Driver().close();
        //go bach on the first tab
        SwitchTab.To(1);
        //switch on Market page and check
        startPage.clickMarketButton();
        //switch on the second page
        SwitchTab.To(2);
        //check current URL
        String actualUrl5 = DriverProvider.Driver().getCurrentUrl();
        Assert.assertTrue(actualUrl5.startsWith("https://market.yandex.by"));
        DriverProvider.Driver().close();
        //go bach on the first tab
        SwitchTab.To(1);
        //switch on Translate page and check
        startPage.clickTranslateButton();
        //switch on the second page
        SwitchTab.To(2);
        //check current URL
        String actualUrl6 = DriverProvider.Driver().getCurrentUrl();
        Assert.assertTrue(actualUrl6.startsWith("https://translate.yandex.by"));
        DriverProvider.Driver().close();
        //go bach on the first tab
        SwitchTab.To(1);
        //switch on Music page and check
        startPage.clickMusicButton();
        //switch on the second page
        SwitchTab.To(2);
        //check current URL
        String actualUrl7 = DriverProvider.Driver().getCurrentUrl();
        Assert.assertTrue(actualUrl7.startsWith("https://music.yandex.by"));
    }

    @Test
    public void chooseLanguage(){
        //click on the language button on start page to open toolbar
        startPage.clickChooseLanguageButton();
        //click on the language button in the toolbar
        startPage.clickBelarussianLanguageButton();
        //check that on the page are Belorussian words
        Assert.assertTrue(startPage.isBelarussianLanguagePageLoaded());
    }
}
