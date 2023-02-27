package pageObjects;

import general.CommonAssertions;
import general.CommonFunctions;
import general.MobileDriverWaits;
import org.openqa.selenium.By;

public class HomePage {

    /* Variables */
    public static By viewApp = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]");
    public static By screenHome = By.xpath("//android.widget.ScrollView[@content-desc=\"Home-screen\"]");
    public static By iconHome = By.xpath("//android.widget.Button[@content-desc=\"Home\"]");
    public static By iconWebview = By.xpath("//android.widget.Button[@content-desc=\"Webview\"]");
    public static By iconLogin = By.xpath("//android.widget.Button[@content-desc=\"Login\"]");
    public static By iconForms = By.xpath("//android.widget.Button[@content-desc=\"Forms\"]");
    public static By iconSwipe = By.xpath("//android.widget.Button[@content-desc=\"Swipe\"]");
    public static By iconDrag = By.xpath("//android.widget.Button[@content-desc=\"Drag\"]");

    boolean result = false;

    /* Methods */
    public void checkForAppLoaded() {
        MobileDriverWaits.waitUntilByElementVisible(viewApp);
    }

    public void checkForHomeScreen() {
        result = CommonFunctions.checkIfElementIsPresent(screenHome);
        CommonAssertions.assertTrue(result,"User is not on Home Screen");
    }

    public void clickHomeIcon() {
        CommonFunctions.click(iconHome);
    }

    public void clickWebviewIcon() {
        CommonFunctions.click(iconWebview);
    }

    public void clickLoginIcon() {
        CommonFunctions.click(iconLogin);
    }

    public void clickFormIcon() {
        CommonFunctions.click(iconForms);
    }

    public void clickSwipeIcon() {
        CommonFunctions.click(iconSwipe);
    }

    public void clickDragIcon() {
        CommonFunctions.click(iconDrag);
    }

}
