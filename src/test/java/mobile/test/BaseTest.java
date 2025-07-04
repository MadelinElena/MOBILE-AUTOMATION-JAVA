package mobile.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        File app = new File("src/test/resources/android.wdio.native.app.v1.0.8.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("deviceName", "Pixel_6_2");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", app.getAbsolutePath());
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("appWaitActivity", "*");
        caps.setCapability("newCommandTimeout", 240);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
