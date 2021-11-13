package tests;

import driver.DriverProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverProvider.initBrowser();
        DriverProvider.loadApplication("https://yandex.by/");
    }

    @BeforeMethod
    protected void UIPreconditions() {
    }

    @AfterMethod
    public void teardown() {
        DriverProvider.destroy();
    }
}
