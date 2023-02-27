package pageObjects;

import general.*;
import org.openqa.selenium.By;

public class WebviewPage {

    /* Variables */
    public static By screenWebView = By.className("android.webkit.WebView");
    public static By txtIntroPara = By.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.TextView");
    public static By btnGetStarted = By.xpath("//android.view.View[@content-desc=\"Get Started\"]");
    public static By btnViewGitHub = By.xpath("//android.view.View[@content-desc=\"View on GitHub\"]");
    public static By headGetStarted = By.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView");
    public static By btnHome = By.xpath("//android.view.View[@content-desc=\"Home page\"]");
    public static By inputTextBarWeb = By.id("com.android.chrome:id/url_bar");

    boolean result = false;

    /* Methods */
    public void checkForWebviewScreen() {
        MobileDriverWaits.waitUntilByElementVisible(screenWebView);
        result = CommonFunctions.checkIfElementIsPresent(screenWebView);
        CommonAssertions.assertTrue(result,"Absence of Webview Screen");
    }

    public void goToGetStartedScreen() {
        CommonFunctions.swipeElementAndroid(txtIntroPara, EnvGlobals.Direction.UP);
        CommonFunctions.click(btnGetStarted);
        result = CommonFunctions.checkIfElementIsPresent(headGetStarted);
        CommonAssertions.assertTrue(result,"Absence of Getting started Screen");
        CommonFunctions.click(btnHome);
    }

    public void goToGitHub() {
        CommonFunctions.swipeElementAndroid(txtIntroPara, EnvGlobals.Direction.UP);
        CommonFunctions.swipeElementAndroid(btnGetStarted, EnvGlobals.Direction.UP);
        CommonFunctions.click(btnViewGitHub);
        MobileDriverWaits.waitUntilByElementVisible(inputTextBarWeb);
        String text = CommonFunctions.getText(inputTextBarWeb);
        CommonAssertions.assertStringEqual(text,EnvGlobals.WebData.url,"Not landed on web page");
    }

    public void navigateBackFromWebToApp(){
        CommonFunctions.navigateBack();
        MainCall.homePage.checkForAppLoaded();

    }

}
