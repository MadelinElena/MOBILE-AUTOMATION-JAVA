package mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class SwipePage {

    private AppiumDriver driver;

    private By carousel = AppiumBy.accessibilityId("Carousel");

    public SwipePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void swipeCarousel() {
        WebElement carouselElement = driver.findElement(carousel);
        int startX = carouselElement.getLocation().getX() + (int)(carouselElement.getSize().getWidth() * 0.8);
        int endX = carouselElement.getLocation().getX() + (int)(carouselElement.getSize().getWidth() * 0.2);
        int y = carouselElement.getLocation().getY() + (carouselElement.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Swipe hacia la izquierda (derecha -> izquierda)
        for (int i = 0; i < 3; i++) {
            Sequence swipeLeft = new Sequence(finger, 1);
            swipeLeft.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, y));
            swipeLeft.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipeLeft.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, y));
            swipeLeft.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(swipeLeft));
        }

        // Swipe hacia la derecha (izquierda -> derecha)
        for (int i = 0; i < 3; i++) {
            Sequence swipeRight = new Sequence(finger, 1);
            swipeRight.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), endX, y));
            swipeRight.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipeRight.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, y));
            swipeRight.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(swipeRight));
        }
    }

    public void scrollToHiddenText() {
        boolean found = false;
        int maxScrolls = 5;

        while (!found && maxScrolls > 0) {
            try {
                WebElement textElement = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"You found me!!!\"))"));
                if (textElement.isDisplayed()) {
                    found = true;
                }
            } catch (Exception e) {
                maxScrolls--;
            }
        }
    }
}
