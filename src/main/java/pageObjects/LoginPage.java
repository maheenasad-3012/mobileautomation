package pageObjects;

import general.*;
import org.openqa.selenium.By;

public class LoginPage {

    /* Variables */
    public static By screenLogin = By.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]");
    public static By tabLogin = By.xpath("//android.view.ViewGroup[@content-desc=\"button-login-container\"]");
    public static By tabSignup = By.xpath("//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]");
    public static By inputEmail = By.xpath("//android.widget.EditText[@content-desc=\"input-email\"]");
    public static By inputPassword = By.xpath("//android.widget.EditText[@content-desc=\"input-password\"]");
    public static By inputConfirmPassword = By.xpath("//android.widget.EditText[@content-desc=\"input-repeat-password\"]");
    public static By btnLogin = By.xpath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]");
    public static By btnSignup = By.xpath("//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]");
    public static By txtErrorEmail = By.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
    public static By txtErrorPassword = By.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]");
    public static By alertConfirmation = By.id("android:id/topPanel");
    public static By txtConfirmationAlert = By.id("android:id/message");
    public static By btnConfirmation = By.id("android:id/button1");

    boolean result = false;
    String text = "";
    EnvGlobals.UserData userData = new EnvGlobals.UserData();

    /* Methods */
    public void checkForLoginScreen() {
        MobileDriverWaits.waitUntilByElementVisible(screenLogin);
        result = CommonFunctions.checkIfElementIsPresent(screenLogin);
        CommonAssertions.assertTrue(result,"Absence of Login Screen");
    }

    public void goToSignupTab() {
        CommonFunctions.click(tabSignup);
    }


    public void goToLoginTab() {
        CommonFunctions.click(tabLogin);
    }

    public void signup() {
        userData.email = GenericFunctions.generateRandomEmail(8);
        userData.password = GenericFunctions.generateRandomAlphaNumericString(8);

        goToSignupTab();
        MobileDriverWaits.waitUntilByElementVisible(inputEmail);
        CommonFunctions.sendKeys(inputEmail, userData.email);
        MobileDriverWaits.waitUntilByElementVisible(inputPassword);
        CommonFunctions.sendKeys(inputPassword, userData.password);
        MobileDriverWaits.waitUntilByElementVisible(inputConfirmPassword);
        CommonFunctions.sendKeys(inputConfirmPassword, userData.password);
        CommonFunctions.click(btnSignup);
        MobileDriverWaits.waitUntilByElementVisible(alertConfirmation);
        text = CommonFunctions.getText(txtConfirmationAlert);
        CommonAssertions.assertStringEqual(text,EnvGlobals.AppData.msgSignup,"User not signed up");
        CommonFunctions.click(btnConfirmation);
    }

    public void checkValidationOnSignup() {
        goToSignupTab();
        CommonFunctions.click(btnSignup);
        result = CommonFunctions.checkIfElementIsPresent(txtErrorEmail);
        CommonAssertions.assertTrue(result,"Vaidation on Email is not present");
        result = CommonFunctions.checkIfElementIsPresent(txtErrorPassword);
        CommonAssertions.assertTrue(result,"Vaidation on Password is not present");
    }

    public void login() {
        goToLoginTab();
        MobileDriverWaits.waitUntilByElementVisible(inputEmail);
        CommonFunctions.sendKeys(inputEmail, userData.email);
        MobileDriverWaits.waitUntilByElementVisible(inputPassword);
        CommonFunctions.sendKeys(inputPassword, userData.password);
        CommonFunctions.click(btnLogin);
        MobileDriverWaits.waitUntilByElementVisible(alertConfirmation);
        text = CommonFunctions.getText(txtConfirmationAlert);
        CommonAssertions.assertStringEqual(text,EnvGlobals.AppData.msgLogin,"User not logged in");
        CommonFunctions.click(btnConfirmation);
    }
}
