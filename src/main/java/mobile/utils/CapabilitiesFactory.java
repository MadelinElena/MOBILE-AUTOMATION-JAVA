package mobile.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesFactory {

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "Pixel_6_2"); // o el nombre exacto si es distinto
        caps.setCapability("appium:platformVersion", "14");
        caps.setCapability("appium:appPackage", "com.wdiodemoapp");
        caps.setCapability("appium:appActivity", ".MainActivity");
        caps.setCapability("appium:noReset", "true");
        caps.setCapability("appium:ensureWebviewsHavePages", "true");
        caps.setCapability("appium:app", "C:\\Users\\ASUS\\Documents\\mobile-automation-java\\src\\test\\resources\\android.wdio.native.app.v1.0.8.apk");

        return caps;
    }
}
