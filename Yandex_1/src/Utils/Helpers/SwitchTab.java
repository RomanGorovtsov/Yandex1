package Utils.Helpers;

import driver.DriverProvider;

import java.util.ArrayList;

public class SwitchTab {

    public static void To(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<String>(DriverProvider.Driver().getWindowHandles());
        DriverProvider.Driver().switchTo().window(tabs.get(tabNumber - 1));
    }
}
