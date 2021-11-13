package tests;

import Utils.Helpers.SwitchTab;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ComparePage;
import pages.LoginPage;
import pages.MarketPage;
import pages.StartPage;

public class SortingByTag extends BaseTest {

    @Test
    public void sortingByTag() {
        var StartPage = new StartPage();
        StartPage.clickMarketButton();
        SwitchTab.To(2);
        var marketPage = new MarketPage();
        marketPage.selectSection("'Бытовая техника'");
        marketPage.chooseAppliancesInHouseholdAppliances("'Холодильники'");
        marketPage.selectTheWidthOfFridge();
    }


}
