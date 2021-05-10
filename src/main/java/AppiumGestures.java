import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;
import java.time.Duration;

public class AppiumGestures {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By accessibility = MobileBy.AccessibilityId("Accessibility");

        TouchAction touch = new TouchAction(driver);

        // Tap Gesture

        // 1. ElementOption
        touch.tap(ElementOption.element(driver.findElement(accessibility))).perform();
        // 2. PointOption
        touch.tap(PointOption.point(538, 416)).perform();
        // 3. TapOptions
        touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElement(accessibility)))).perform();


        // Press Gesture
        touch.press(ElementOption.element(driver.findElement(accessibility))).release().perform();
        // To make the element in pressed state for some duration
        touch.press(ElementOption.element(driver.findElement(accessibility)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
                .release()
                .perform();
        // Long Press
        touch.longPress(ElementOption.element(driver.findElement(accessibility))).release().perform();


        // Swipe Gesture
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int endX = startX;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        touch.press(new PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(new PointOption.point(endX, endY))
                .release()
                .perform();
    }

}
