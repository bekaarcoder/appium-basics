import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public class WebViewAutomation {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        TouchAction touch = new TouchAction(driver);

        By views = MobileBy.AccessibilityId("Views");
        By webView = MobileBy.AccessibilityId("WebView");

        driver.findElement(views).click();

        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int endX = startX;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for(int i=0; i<3; i++) {
            touch.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
        }

        driver.findElement(webView).click();

        Set<String> contextHandles = driver.getContextHandles();
        for(String contextHandle : contextHandles) {
            System.out.println(contextHandle);
        }

        //driver.context("WEBVIEW");
        driver.context(contextHandles.toArray()[1].toString());
        String header = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(header);
        String inputText = driver.findElement(By.xpath("//input[@id='i_am_a_textbox']")).getAttribute("value");
        System.out.println(inputText);

        driver.context("NATIVE_APP");

    }
}
