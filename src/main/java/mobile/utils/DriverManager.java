package mobile.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

    public static AppiumDriver getDriver() {
        DesiredCapabilities caps = CapabilitiesFactory.getCapabilities(); // Asegúrate que el método se llame así

        try {
            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("La URL del servidor Appium está mal formada", e);
        }
    }
}
