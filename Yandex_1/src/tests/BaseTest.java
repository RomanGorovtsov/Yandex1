package tests;

import driver.DriverProvider;
import pages.ComparePage;
import pages.LoginPage;
import pages.MarketPage;
import pages.StartPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    LoginPage loginPage = new LoginPage();
    StartPage startPage = new StartPage();
    MarketPage marketPage = new MarketPage();
    ComparePage comparePage = new ComparePage();

    @BeforeMethod
    public void setup() {
        DriverProvider.initBrowser();
        DriverProvider.loadApplication("https://yandex.by/");
    }

    @AfterMethod
    public void teardown() {
        DriverProvider.destroy();
    }
}
