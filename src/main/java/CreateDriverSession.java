import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static AppiumDriver initializeDriver(String platformName) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability("newCommandTimeout", 300);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");


        // Launch Android Emulator Automatically
//        caps.setCapability("avd", "Pixel_3");
//        caps.setCapability("avdLaunchTimeout", 180000);

        // Installs the apk in the device
        String appUrl = System.getProperty("user.dir") + "\\src\\main\\resources\\ApiDemos-debug.apk";
        caps.setCapability(MobileCapabilityType.APP, appUrl);

        // Opens the existing application in the device
//        caps.setCapability("appPackage", "io.appium.android.apis");
//        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        // Android device lock capability
        caps.setCapability("unlockType", "pin");
        caps.setCapability("unlockKey", "1111");

        return new AndroidDriver(url, caps);
    }

}
