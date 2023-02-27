package general;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class CommonFunctions {

    public static void sendKeys(By fieldLocator, String fieldText) {
        clearField(fieldLocator);
        MobileDriverFactory.getDriver().findElement(fieldLocator).sendKeys(fieldText);
    }

    public static String getText(By fieldLocator) {
        return MobileDriverFactory.getDriver().findElement(fieldLocator).getText();
    }

    public static void clearField(By fieldLocator) {
        MobileDriverFactory.getDriver().findElement(fieldLocator).clear();
    }

    public static void click(By clickElement) {
        MobileDriverFactory.getDriver().findElement(clickElement).click();
    }

    public static void navigateBack() {
        MobileDriverFactory.getDriver().navigate().back();
    }

    public static void closeKeyboard() {
        MobileDriverFactory.getDriver().hideKeyboard();
    }

    public static void androidKeyboardOperations(AndroidKey opt) {
        MobileDriverFactory.getDriver().pressKey(new KeyEvent(opt));
    }

    public static boolean checkIfElementIsPresent(By locator) {
        return MobileDriverFactory.getDriver().findElement(locator).isDisplayed();
    }

    public static void swipeScreen(EnvGlobals.Direction dir) throws InterruptedException {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        final int ANIMATION_TIME = 300; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = MobileDriverFactory.getScreenSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            TouchAction touchAction = new TouchAction(MobileDriverFactory.getDriver());
            touchAction.press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
        }
    }

    public static boolean swipeElementAndroid(By element, EnvGlobals.Direction dir) {
        System.out.println("swipeElementAndroid(): dir: '" + dir + "'"); // always log your actions

        final int ANIMATION_TIME = 500; // ms

        final int PRESS_TIME = 1000; // ms

        int edgeBorder;
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        MobileElement field= MobileDriverFactory.getDriver().findElement(element);
        Rectangle rect = field.getRect();
        System.out.println("rect:" + field.getRect());
        Dimension dims = MobileDriverFactory.getScreenSize();
        // sometimes it is needed to configure edgeBorders
        // you can also improve borders to have vertical/horizontal
        // or left/right/up/down border variables
        edgeBorder = 10;

        switch (dir) {
            case DOWN: // from up to down
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                break;
            case UP: // from down to up
                pointOptionStart = PointOption.point(rect.x + rect.width / 2,
                        rect.y + rect.height - edgeBorder);
                pointOptionEnd = PointOption.point(rect.x + rect.width / 2,
                        rect.y + edgeBorder);
                break;
            case LEFT: // from right to left
                pointOptionStart = PointOption.point(rect.x + rect.width - edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                System.out.println("pointOptionStart:" + pointOptionStart);
                System.out.println("pointOptionEnd:" + pointOptionEnd);
                break;
            case RIGHT: // from left to right
                pointOptionStart = PointOption.point(rect.x + edgeBorder,
                        rect.y + rect.height / 2);
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                System.out.println("pointOptionStart:" + pointOptionStart);
                System.out.println("pointOptionEnd:" + pointOptionEnd);
                break;
            default:
                throw new IllegalArgumentException("swipeElementAndroid(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            TouchAction touchAction = new TouchAction(MobileDriverFactory.getDriver());
            touchAction.press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
            Thread.sleep(ANIMATION_TIME);
            return true;
        } catch (Exception e) {
            System.err.println("swipeElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropElementAndroid(By element1, By element2) {

        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 500; // ms

        MobileElement elementToDrag= MobileDriverFactory.getDriver().findElement(element1);
        Rectangle rect1 = elementToDrag.getRect();

        MobileElement elementToDrop= MobileDriverFactory.getDriver().findElement(element2);
        Rectangle rect2 = elementToDrop.getRect();

        PointOption pointOptionStart, pointOptionEnd;

        pointOptionStart = PointOption.point(rect1.x+ rect1.width / 2,
                rect1.y + rect1.height / 2);
        pointOptionEnd = PointOption.point(rect2.x + rect2.width / 2,
                rect2.y + rect2.height / 2);

        try {
            TouchAction touchAction = new TouchAction(MobileDriverFactory.getDriver());
            touchAction.press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
            Thread.sleep(ANIMATION_TIME);
            return true;
        } catch (Exception e) {
            System.err.println("dragAndDropElementAndroid(): TouchAction FAILED\n" + e.getMessage());
            return false;
        }
    }
}
