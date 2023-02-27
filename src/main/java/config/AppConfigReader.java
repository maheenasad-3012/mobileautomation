package config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource.Classpath;

@Classpath({"AppConfig.properties"})
public class AppConfigReader {

    @Property("appPath")
    private String appPath;

    @Property("appPackage")
    private String appPackage;

    @Property("appActivity")
    private String appActivity;


    public AppConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    public String getAppPath() {
        return this.appPath;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public String getAppActivity() {
        return this.appActivity;
    }

}
