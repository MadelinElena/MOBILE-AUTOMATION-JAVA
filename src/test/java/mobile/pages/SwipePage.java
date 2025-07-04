package mobile.pages;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

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

        // Swipe izquierda (→ ←)
        for (int i = 0; i < 3; i++) {
            Sequence swipeLeft = new Sequence(finger, 1);
            swipeLeft.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
            swipeLeft.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipeLeft.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, y));
            swipeLeft.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(swipeLeft));
        }
    }

    public void scrollToHiddenText() {
        try {
            WebElement scrollable = driver.findElement(AppiumBy.accessibilityId("Swipe-screen"));
            int startX = scrollable.getLocation().getX() + (scrollable.getSize().getWidth() / 2);
            int startY = scrollable.getLocation().getY() + (int)(scrollable.getSize().getHeight() * 0.8);
            int endY = scrollable.getLocation().getY() + (int)(scrollable.getSize().getHeight() * 0.2);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            boolean found = false;
            int attempts = 0;

            while (!found && attempts < 5) {
                try {
                    WebElement hiddenText = driver.findElement(By.xpath("//*[@text='You found me!!!']"));
                    if (hiddenText.isDisplayed()) {
                        found = true;
                        break;
                    }
                } catch (Exception e) {
                    // Scroll hacia arriba (para ver lo de abajo)
                    Sequence swipe = new Sequence(finger, 1);
                    swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
                    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                    swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
                    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                    driver.perform(Collections.singletonList(swipe));
                    attempts++;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo hacer scroll vertical en Swipe-screen", e);
        }
    }
}
