package mobile.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {

    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void back() {
        driver.navigate().back();
    }

    public boolean isAppLaunched() {
        return driver != null;
    }

    public void esperar(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void swipeVerticallyOnScreen() {
        int screenHeight = driver.manage().window().getSize().height;
        int screenWidth = driver.manage().window().getSize().width;

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.8);
        int endY = (int) (screenHeight * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }
}
