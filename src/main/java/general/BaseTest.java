package general;

import com.aventstack.extentreports.ExtentTest;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import config.ConfigProperties;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    private static ExtentTest extentTest;

    @BeforeSuite()
    public void beforeSuite() throws IOException {
        MobileDriverFactory.startDriver(ConfigProperties.appPath);
        MainCall.report.reportSetup();
    }

    @BeforeMethod()
    public void beforeTest(Method method)  {
        extentTest = MainCall.report.getExtentReport().createTest(method.getName());
    }

    @AfterMethod()
    public void afterMethod(ITestResult result, ITestContext ctx, Method method) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                extentTest.fail("Test Case Failed reason is: " + result.getThrowable());
                extentTest.addScreenCaptureFromPath(Screenshots.takeScreenshot(result.getMethod().getMethodName()));
            } else if (result.getStatus() == ITestResult.SKIP) {
                extentTest.skip("Test Case Skipped is: " + result.getName());
            } else {
                extentTest.pass(result.getMethod().getMethodName() + " is Passed");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @AfterSuite()
    public void afterSuite() throws Exception {
        MobileDriverFactory.finishDriver();
        MainCall.report.reportEnd();
    }

}
