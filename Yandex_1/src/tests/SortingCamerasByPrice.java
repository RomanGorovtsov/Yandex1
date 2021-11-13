package tests;

import Utils.Helpers.SwitchTab;
import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.LoginPage;
import pages.MarketPage;
import pages.StartPage;

public class SortingCamerasByPrice extends BaseTest {

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
    public void SortCamerasByPrice() {
        //click on the market button
        var startPage = new StartPage();
        startPage.clickMarketButton();
        //switch on the market button
        SwitchTab.To(2);
        //click on "electronics" button
        var marketPage = new MarketPage();
        marketPage.selectSection("'Электроника'");
        //click on "Action cameras"
        marketPage.clickOnActionCamerasButton();
        //select list type view
        marketPage.selectListView();
        //click on sort by price button
        marketPage.clickOnTheSortByPriceButton();
        //check that sorting is work
        var allPrices = marketPage.getAllDevicesPrices();
        Assert.assertTrue(Ordering.natural().isOrdered(allPrices));
    }
}
