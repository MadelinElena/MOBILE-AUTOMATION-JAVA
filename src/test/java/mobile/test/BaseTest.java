package mobile.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Pixel_6_2");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.wdiodemoapp");
        caps.setCapability("appActivity", "com.wdiodemoapp.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
