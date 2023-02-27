package testCases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class LoginScreen extends BaseTest {

    /* Tests */
    @Test(description = "user lands on login screen")
    public void goToLoginScreen() {
        MainCall.homePage.clickLoginIcon();
        MainCall.loginPage.checkForLoginScreen();
    }

    @Test(description = "User hits signup with missing information")
    public void checkValidations() {
        MainCall.loginPage.checkValidationOnSignup();
    }

    @Test(description = "User signup")
    public void signup() {
        MainCall.loginPage.signup();
    }

    @Test(description = "User login")
        public void login() {
            MainCall.loginPage.login();
        }





}
