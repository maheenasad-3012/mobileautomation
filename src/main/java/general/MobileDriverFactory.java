package general;

import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import config.ConfigProperties;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileDriverFactory {
    public static AndroidDriver driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }

    public static AndroidDriver startDriver(String appPath) throws IOException {
        String appPackage = "";
        String appActivity="";
        if(appPath == ConfigProperties.appPath) {
             appPackage = ConfigProperties.appPackage;
             appActivity = ConfigProperties.appActivity;
        }
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), setCapabilities(appPath,appPackage,appActivity));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        System.out.println(driver);
        return driver;
    }

    public static void finishDriver() {
        if (driver != null) {
            removeApp(driver.getCapabilities().getCapability("appPackage").toString());
            driver.quit();
            driver = null;
        }
    }

    public static Dimension getScreenSize() {
        return driver.manage().window().getSize();
    }

    public static DesiredCapabilities setCapabilities(String appPath,String appPackage, String appActivity) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", appPath);
        capabilities.setCapability("autoGrantPermissions",true);
        capabilities.setCapability("appPackage",appPackage);
        capabilities.setCapability("appActivity",appActivity);
        return capabilities;
    }

    public static void removeApp(String appPackage) {
        driver.removeApp(appPackage);
    }


}
