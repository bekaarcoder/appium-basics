import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.time.Duration;

public class InteractionWithApp {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By accessibility = MobileBy.AccessibilityId("Accessibility");

        // Terminate app
        driver.terminateApp("io.appium.android.apis");

        // Install application
        String appUrl = System.getProperty("user.dir") + "\\src\\main\\resources\\ApiDemos-debug.apk";
        driver.installApp(appUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());

        // Is app installed
        driver.isAppInstalled("io.appium.android.apis");

        // Run application is background
        driver.runAppInBackground(Duration.ofMillis(5000));

        // Lock Device
        ((AndroidDriver) driver).lockDevice(Duration.ofMillis(5000));

        // Check if device is locked
        ((AndroidDriver) driver).isDeviceLocked();

        // Unlock device
        ((AndroidDriver) driver).unlockDevice();


        // Android working with keys

        // Check if keyboard is displayed
        ((AndroidDriver) driver).isKeyboardShown();
        // Press android key
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.S));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        // Hide keyboard
        driver.hideKeyboard();

    }
}
