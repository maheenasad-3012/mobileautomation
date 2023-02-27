package config;

public class ConfigProperties {
    public static AppConfigReader appConfig = new AppConfigReader();
    public static String appPath;
    public static String appPackage;
    public static String appActivity;
    public static String basePath = System.getProperty("user.dir");

    static {
        appPath = basePath + appConfig.getAppPath();
        appPackage = appConfig.getAppPackage();
        appActivity = appConfig.getAppActivity();
    }
}
