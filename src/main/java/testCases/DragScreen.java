package testCases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class DragScreen extends BaseTest {

    /* Tests */
    @Test(description = "user lands on drag screen")
    public void goToDragScreen() {
        MainCall.homePage.clickDragIcon();
        MainCall.dragPage.checkForDragScreen();
    }

    @Test(description = "Drag and Drop Icons to complete the picture")
    public static void completePicture() {
        MainCall.dragPage.dragAndDrop("l");
        MainCall.dragPage.dragAndDrop("r");
        MainCall.dragPage.dragAndDrop("c");
        MainCall.dragPage.checkGreetingText();
    }

}
