package pageObjects;

import general.*;
import org.openqa.selenium.By;

public class FormsPage {

    /* Variables */
    public static By screenForms = By.xpath("//android.widget.ScrollView[@content-desc=\"Forms-screen\"]");
    public static By txtInput = By.xpath("//android.widget.EditText[@content-desc=\"text-input\"]");
    public static By txtInputResult = By.xpath("//android.widget.TextView[@content-desc=\"input-text-result\"]");
    public static By btnSwitch = By.xpath("//android.widget.Switch[@content-desc=\"switch\"]");
    public static By txtSwitch = By.xpath("//android.widget.TextView[@content-desc=\"switch-text\"]");
    public static By dropDownMenu = By.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]");
    public static By dropDownOpt = By.xpath("//android.widget.CheckedTextView[3]");
    public static By txtDropDownSelectedOpt = By.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.widget.EditText");
    public static By btnActive = By.xpath("//android.view.ViewGroup[@content-desc=\"button-Active\"]");
    public static By alertConfirmation = By.id("android:id/topPanel");
    public static By txtConfirmationAlert = By.id("android:id/message");
    public static By btnConfirmation = By.id("android:id/button1");

    boolean result = false;
    String text = "";

    /* Methods */
    public void checkForFormsScreen() {
        MobileDriverWaits.waitUntilByElementVisible(screenForms);
        result = CommonFunctions.checkIfElementIsPresent(screenForms);
        CommonAssertions.assertTrue(result,"Absence of Forms screen");
    }

    public void setDataInTextField() {
        MobileDriverWaits.waitUntilByElementVisible(txtInput);
        text = GenericFunctions.generateRandomAlphaNumericString(5);
        CommonFunctions.sendKeys(txtInput, text);
        String result = CommonFunctions.getText(txtInputResult);
        CommonAssertions.assertStringEqual(result,text,"Incorrect input");
    }

    public void checkSwitchOperation() {
        text = CommonFunctions.getText(txtSwitch);
        int len = text.length();
        System.out.println(len);
        String subInit = text.substring(len-3);
        System.out.println(subInit);
        CommonFunctions.click(btnSwitch);
        text = CommonFunctions.getText(txtSwitch);
        len = text.length();
        String subFinal = text.substring(len-3);
        System.out.println(subFinal);
        if (subInit.equalsIgnoreCase(EnvGlobals.AppData.on)) {
            CommonAssertions.assertStringEqual(subFinal,EnvGlobals.AppData.off,"Switch operation unsuccessful");
        }
        else
            CommonAssertions.assertStringEqual(subFinal,EnvGlobals.AppData.on,"Switch operation unsuccessful");
    }

    public void checkDropDown() {
        CommonFunctions.click(dropDownMenu);
        CommonFunctions.click(dropDownOpt);
        text = CommonFunctions.getText(txtDropDownSelectedOpt);
        CommonAssertions.assertStringEqual(text,EnvGlobals.AppData.dropDownSelectedData,"Incorrect data selected");
    }

    public void checkButton() {
        CommonFunctions.click(btnActive);
        MobileDriverWaits.waitUntilByElementVisible(alertConfirmation);
        text = CommonFunctions.getText(txtConfirmationAlert);
        CommonAssertions.assertStringEqual(text,EnvGlobals.AppData.msgActiveBtn,"Button is not active");
        CommonFunctions.click(btnConfirmation);
    }

}
