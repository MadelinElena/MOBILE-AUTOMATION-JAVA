package mobile.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesFactory {

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:platformVersion", "11.0");
        caps.setCapability("appium:appPackage", "com.wdiodemoapp");
        caps.setCapability("appium:appActivity", "com.wdiodemoapp.MainActivity");
        caps.setCapability("appium:noReset", true);
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:app", "C:\\Users\\ASUS\\Downloads\\android.wdio.native.app.v1.0.8.apk");

        return caps;
    }
}
