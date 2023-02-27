package testCases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class FormsScreen extends BaseTest {

    /* Tests */
    @Test(description = "go to Forms Screen")
    public void goToFormsScreen() {
        MainCall.homePage.clickFormIcon();
        MainCall.formsPage.checkForFormsScreen();
    }

    @Test(description = "Verify input field")
    public void checkInputField() {
        MainCall.formsPage.setDataInTextField();
    }

    @Test(description = "Check switch functionality")
    public void checkSwitch() {
        MainCall.formsPage.checkSwitchOperation();
    }

    @Test(description = "Check Dropdown menu and select an option")
    public void selectOptionFromDropdown() {
        MainCall.formsPage.checkDropDown();
    }

    @Test(description = "Check Button functionality")
    public void checkButton() {
        MainCall.formsPage.checkButton();
    }
}
