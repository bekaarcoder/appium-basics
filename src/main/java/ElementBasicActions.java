import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class ElementBasicActions {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By views = MobileBy.AccessibilityId("Views");
        By textFields = MobileBy.AccessibilityId("TextFields");
        By editText = MobileBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(494, 1788))
                .moveTo(new PointOption().withCoordinates(528, 314))
                .release()
                .perform();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(491, 1827))
                .moveTo(new PointOption().withCoordinates(506, 360))
                .release()
                .perform();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(491, 1827))
                .moveTo(new PointOption().withCoordinates(506, 360))
                .release()
                .perform();

        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("Hello World");
        Thread.sleep(3000);
        driver.findElement(editText).clear();
    }

}
