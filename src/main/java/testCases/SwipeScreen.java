package testCases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class SwipeScreen extends BaseTest {

    /* Tests */
    @Test(description = "user lands on swipe screen")
    public void goToSwipeScreen() {
        MainCall.homePage.clickSwipeIcon();
        MainCall.swipePage.checkForSwipeScreen();
    }

    @Test(description = "Swipe horizontal to see all cards")
    public static void swipeHorizontal() {
        MainCall.swipePage.checkVisibilityOfFirstCard();
        MainCall.swipePage.swipeElementLeft();
        MainCall.swipePage.checkVisibilityOfSecondCard();
        MainCall.swipePage.swipeElementRight();
        MainCall.swipePage.checkVisibilityOfFirstCard();
    }

    @Test(description = "Swipe up to see hidden image")
    public static void swipeScreenUp() throws InterruptedException{
        MainCall.swipePage.swipeScreenUp();
    }

}
