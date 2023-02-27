package testCases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class HomeScreen extends BaseTest {

    /*Tests */
    @Test(description = "Launch App")
    public static void applicationLaunch()  {
        MainCall.homePage.checkForAppLoaded();
        MainCall.homePage.checkForHomeScreen();
    }
}
