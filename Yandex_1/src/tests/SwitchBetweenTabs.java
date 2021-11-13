package tests;

import Utils.Helpers.SwitchTab;
import driver.DriverProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;

public class SwitchBetweenTabs extends BaseTest {

    @Test
    public void jumpToSections() {
        //click on Video page
        var startPage = new StartPage();
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
}
