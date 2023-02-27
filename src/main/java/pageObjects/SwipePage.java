package pageObjects;

import general.*;
import org.openqa.selenium.By;


public class SwipePage {

    /* Variables */
    public static By screenSwipe = By.xpath("//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]");
    public static By cardOne = By.xpath("(//android.view.ViewGroup[@content-desc=\"card\"])[1]");
    public static By cardTwo = By.xpath("(//android.view.ViewGroup[@content-desc=\"card\"])[2]");
    public static By hiddenImage = By.xpath("//android.widget.ImageView[@content-desc=\"WebdriverIO logo\"]");
    public static By hiddenText = By.xpath("//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]/android.view.ViewGroup/android.widget.TextView");

    boolean result = false;

    /* Methods */
    public void checkForSwipeScreen() {
        MobileDriverWaits.waitUntilByElementVisible(screenSwipe);
        result = CommonFunctions.checkIfElementIsPresent(screenSwipe);
        CommonAssertions.assertTrue(result,"Absence of Swipe Screen");
    }

    public void swipeElementRight()  {
        result = CommonFunctions.swipeElementAndroid(cardTwo,EnvGlobals.Direction.RIGHT);
        CommonAssertions.assertTrue(result,"User is not able to swipe right");
    }

    public void swipeElementLeft()  {
        result = CommonFunctions.swipeElementAndroid(cardOne,EnvGlobals.Direction.LEFT);
        CommonAssertions.assertTrue(result,"User is not able to swipe left");
    }

    public void checkVisibilityOfFirstCard() {
        result = CommonFunctions.checkIfElementIsPresent(cardOne);
        CommonAssertions.assertTrue(result,"Card one is not displayed");

    }

    public void checkVisibilityOfSecondCard() {
        result = CommonFunctions.checkIfElementIsPresent(cardTwo);
        CommonAssertions.assertTrue(result,"Card two is not displayed");
    }

    public void swipeScreenUp()  throws InterruptedException{
        CommonFunctions.swipeScreen(EnvGlobals.Direction.UP);
        result = CommonFunctions.checkIfElementIsPresent(hiddenImage);
        CommonAssertions.assertTrue(result,"Image not found");
        MobileDriverWaits.waitUntilByElementVisible(hiddenText);
        String result = CommonFunctions.getText(hiddenText);
        CommonAssertions.assertStringEqual(result, EnvGlobals.AppData.msgHiddenImg,"Swipe operation is unsuccessful");
    }
}
