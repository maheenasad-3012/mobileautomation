package pageObjects;

import general.CommonAssertions;
import general.CommonFunctions;
import general.EnvGlobals;
import general.MobileDriverWaits;
import org.openqa.selenium.By;

public class DragPage {

    /* Variables */
    public static By screenDrag = By.xpath("//android.view.ViewGroup[@content-desc=\"Drag-drop-screen\"]");
    public By dragElement;
    public By dropElement;
    public static By txtGreeting = By.xpath("//android.view.ViewGroup[@content-desc=\"Drag-drop-screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView");

    boolean result = false;

    /* Methods */
    public void checkForDragScreen() {
        MobileDriverWaits.waitUntilByElementVisible(screenDrag);
        result = CommonFunctions.checkIfElementIsPresent(screenDrag);
        CommonAssertions.assertTrue(result,"Absence of Drag Screen");
    }

    public void dragAndDrop(String series){
        int count=0;
        boolean result;
        for(int i=1 ; i<=3 ; i++) {
            dropElement = By.xpath("//android.view.ViewGroup[@content-desc=\"drop-" + series + i + "\"]");
            dragElement = By.xpath("//android.view.ViewGroup[@content-desc=\"drag-" + series + i + "\"]");

            result = CommonFunctions.dragAndDropElementAndroid(dragElement, dropElement);
            if (result)
                count++;
        }
        CommonAssertions.assertIntEqual(count,3,"Drag and Drop operation is unsuccessful");
    }

    public void checkGreetingText() {
        MobileDriverWaits.waitUntilByElementVisible(txtGreeting);
        String result = CommonFunctions.getText(txtGreeting);
        CommonAssertions.assertStringEqual(result, EnvGlobals.AppData.msgGreeting,"Drag and drop operation is unsuccessful");
    }




}
