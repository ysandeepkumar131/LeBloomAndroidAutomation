package Utility;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserUtility {
    public static AndroidDriver getAndroidDriver() {
        AndroidDriver driver=null;
        ConfigFileReader prop=new ConfigFileReader();
        //String phone=prop.getConfigPropertyVal("phoneNo");

        try {
           DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", prop.getConfigPropertyVal("deviceName"));
            caps.setCapability("automationName", prop.getConfigPropertyVal("automationName"));
            caps.setCapability("platformName", prop.getConfigPropertyVal("platformName"));
            caps.setCapability("platformVersion", prop.getConfigPropertyVal("platformVersion"));
            caps.setCapability("appPackage", prop.getConfigPropertyVal("appPackage"));
            caps.setCapability("appActivity", prop.getConfigPropertyVal("appActivity"));
            caps.setCapability("noReset", true);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
