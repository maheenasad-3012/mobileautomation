package general;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Screenshots {
    /* Variables */
    public static File screenShot;
    public static String filePath;

    /* Methods */
    public static String takeScreenshot(String test) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_hh-mm-ss");
        Calendar now = Calendar.getInstance();
        screenShot = MobileDriverFactory.getDriver().getScreenshotAs(OutputType.FILE);
        filePath = System.getProperty("user.dir") + "/Screenshots/" + test + "_" + formatter.format(now.getTime()) + ".jpg";

        try {
            FileUtil.copyFile(screenShot, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath = filePath.replace(System.getProperty("user.dir"), "..");
        return filePath;
    }
}
