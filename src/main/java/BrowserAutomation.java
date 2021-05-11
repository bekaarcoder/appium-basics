import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BrowserAutomation {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.in");
    }
}
