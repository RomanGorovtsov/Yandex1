package tests;

import Utils.Helpers.SwitchTab;
import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Pull2 extends BaseTest {

    private String password = "autotestPassword123";
    private String eMail = "AutotestLogin";
    private String Note8 = "Note 8";

    @Test
    public void comparison() {
        //click om the login button
        startPage.clickLoginButton();
        //enter email
        loginPage.enterEmail(eMail);
        //enter password
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
        //click market button
        startPage.clickMarketButton();
        SwitchTab.To(2);
        //enter "Note 9"
        marketPage.searchInMarketField(Note8);
        //add to compare 2 first elements
        marketPage.chooseDevice();
        //go to compare list
        //open toolbar
        marketPage.clickOnAccountField();
        //click on compare button in toolbar
        marketPage.clickOnCompareButtonField();
        //check compare field
        var elementsForComparisonList = comparePage.getElementsForComparison();
        Assert.assertEquals(elementsForComparisonList.stream().count(), 2);
    }

    @Test
    public void deleteComparisonItems() {
        //click om the login button
        startPage.clickLoginButton();
        //enter email
        loginPage.enterEmail(eMail);
        //enter password
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
        //click market button
        startPage.clickMarketButton();
        SwitchTab.To(2);
        //enter "Note 9"
        marketPage.searchInMarketField(Note8);
        //add to compare 2 first elements
        marketPage.chooseDevice();
        //go to compare list
        //open toolbar
        marketPage.clickOnAccountField();
        //click on compare button in toolbar
        marketPage.clickOnCompareButtonField();
        //check compare field
        var elementsForComparisonList = comparePage.getElementsForComparison();
        Assert.assertEquals(elementsForComparisonList.stream().count(), 2);
        comparePage.clickClearListButton();
        Assert.assertTrue(comparePage.isImagineOfClearCompareListIsDisplayed());
    }

    @Test
    public void SortCamerasByPrice() {
        //click on the market button
        startPage.clickMarketButton();
        //switch on the market button
        SwitchTab.To(2);
        //click on "electronics" button
        marketPage.selectSection("'Электроника'");
        //click on "Action cameras"
        marketPage.clickOnActionCamerasButton();
        //click on "Action cameras inside the "Photo and video""
        marketPage.clickOnActionCamerasButton2();
        //click on sort by price button
        marketPage.clickOnTheSortByPriceButton();
        //check that sorting is work
        var allPrices = marketPage.getAllDevicesPrices();
        Assert.assertTrue(Ordering.natural().isOrdered(allPrices));

        //создать лист с элементами цены
        //считать эти элементы
        //отсортировать эти элементы по цене
        //сравнить с тем списком, что сначалаа скачал

    }

}


