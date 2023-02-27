package general;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MobileDriverWaits {
    public static WebDriverWait wait = new WebDriverWait(MobileDriverFactory.getDriver(), 20);

    public static void waitUntilByElementToBeClickable(By locator) {
        new WebDriverWait(MobileDriverFactory.getDriver(), 50).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilByElementVisible(By locator) {
        new WebDriverWait(MobileDriverFactory.getDriver(), 50).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilByElementInvisible(By locator) {
        new WebDriverWait(MobileDriverFactory.getDriver(), 50).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}
