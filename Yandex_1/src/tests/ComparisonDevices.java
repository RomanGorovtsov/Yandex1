package tests;

import Utils.Helpers.SwitchTab;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.LoginPage;
import pages.MarketPage;
import pages.StartPage;

public class ComparisonDevices extends BaseTest {

    private String password = "autotestPassword123";
    private String eMail = "AutotestLogin";
    private String Note8 = "Note 8";

    @BeforeMethod
    @Override
    protected void UIPreconditions() {
        //click om the login button
        var startPage = new StartPage();
        startPage.clickLoginButton();
        //enter email
        var loginPage = new LoginPage();
        loginPage.enterEmail(eMail);
        //enter password
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
        //click market button
        startPage.clickMarketButton();
        SwitchTab.To(2);
        //open toolbar
        var marketPage = new MarketPage();
        marketPage.clickOnAccountField();
        //click on compare button in toolbar
        marketPage.clickOnCompareButtonField();
        var comparePage = new ComparePage();
        comparePage.clickOnTheClearButtonInTheBeginning();
    }

    @Test
    public void comparison() {
        //open toolbar
        var marketPage = new MarketPage();
        var comparePage = new ComparePage();
        //enter "Note 8"
        marketPage.searchInMarketField(Note8);
        //add to compare 2 first elements
        var devicesToBeChosen = new int[]{
                1, 2
        };
        marketPage.chooseDevice(devicesToBeChosen);
        //open toolbar
        marketPage.clickOnAccountField();
        //click on compare button in toolbar
        marketPage.clickOnCompareButtonField();
        //check compare field
        var elementsForComparisonList = comparePage.getElementsForComparison();
        Assert.assertEquals(elementsForComparisonList.stream().count(), 2);
    }
}
