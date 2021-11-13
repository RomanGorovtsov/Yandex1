package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;

public class ChangeLanguage extends BaseTest {

    @Test
    public void chooseLanguage() {
        //click on the language button on start page to open toolbar
        var startPage = new StartPage();
        startPage.clickChooseLanguageButton();
        //click on the language button in the toolbar
        startPage.clickBelarussianLanguageButton();
        //check that on the page are Belorussian words
        Assert.assertTrue(startPage.isBelarussianLanguagePageLoaded());
    }
}
