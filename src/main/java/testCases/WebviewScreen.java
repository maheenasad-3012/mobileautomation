package testCases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class WebviewScreen extends BaseTest{

    /* Tests */
    @Test(description = "user lands on webview screen")
    public void goToWebviewScreen() {
        MainCall.homePage.clickWebviewIcon();
        MainCall.webviewPage.checkForWebviewScreen();
    }

    @Test(description = "user go to get started screen")
    public static void goToGetStartedScreen() {
        MainCall.webviewPage.goToGetStartedScreen();
    }

    @Test(description = "user go to github web")
    public static void goToGitHubWebPage() {
        MainCall.webviewPage.goToGitHub();
    }

    @Test(description = "navigate back to app")
        public static void navigateFromWebToApp() {
        MainCall.webviewPage.navigateBackFromWebToApp();
    }
}
