package general;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;

import java.io.File;
import java.io.IOException;

public class Report {

    /* Variables */
    static ExtentReports extent = new ExtentReports();

    /* Methods */
    public static ExtentReports reportSetup() throws IOException {
        deleteExistingReports();
        JsonFormatter json = new JsonFormatter("reports/report.json");
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/report.html");
        extent.createDomainFromJsonArchive("reports/report.json");
        extent.attachReporter(spark, json);
        extent.setSystemInfo("Driver", MobileDriverFactory.getDriver().getContext());
        extent.setSystemInfo("Platform Name", MobileDriverFactory.getDriver().getCapabilities().getCapability("platformName").toString());
        extent.setSystemInfo("Version", MobileDriverFactory.getDriver().getCapabilities().getCapability("platformVersion").toString());
        extent.setSystemInfo("Device Name", MobileDriverFactory.getDriver().getCapabilities().getCapability("deviceName").toString());
        extent.setSystemInfo("Device Api Level", MobileDriverFactory.getDriver().getCapabilities().getCapability("deviceApiLevel").toString());
        extent.setSystemInfo("Screen Size", MobileDriverFactory.getDriver().getCapabilities().getCapability("deviceScreenSize").toString());
        return extent;
    }

    public static ExtentReports getExtentReport() {
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }

    public void reportEnd() {
        extent.flush();
    }

    public static void deleteExistingReports() {
        File file1 = new File("reports/report.json");
        if (file1.exists()) {
            file1.delete();
        }

        File file2 = new File("reports/report.html");
        if (file2.exists()) {
            file2.delete();
        }

    }
}
