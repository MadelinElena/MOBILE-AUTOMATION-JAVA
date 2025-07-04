package mobile.pages;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SwipePage extends BasePage {

    public SwipePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Carousel")
    private WebElement carousel;

    public void swipeCarousel() {
        int centerY = carousel.getLocation().getY() + (carousel.getSize().getHeight() / 2);
        int startX = (int) (carousel.getSize().getWidth() * 0.8);
        int endX = (int) (carousel.getSize().getWidth() * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, centerY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
        esperar(1);
    }

    public void swipeAllCarouselCards() {
        int totalSwipes = 5;
        for (int i = 0; i < totalSwipes; i++) {
            swipeCarousel();
        }
    }

    public void scrollDownUntilFound() {
        int maxSwipes = 8;
        for (int i = 0; i < maxSwipes; i++) {
            if (isHiddenTextVisible()) {
                esperar(2);
                break;
            }
            swipeVerticallyFromScrollContainer();
            esperar(1);
        }
    }

    public boolean isHiddenTextVisible() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@text='You found me!!!']"));
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    public void swipeVerticallyFromScrollContainer() {
        WebElement scrollContainer = driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc='Swipe-screen']/android.view.ViewGroup"));

        int startX = scrollContainer.getLocation().getX() + (scrollContainer.getSize().getWidth() / 2);
        int startY = scrollContainer.getLocation().getY() + (scrollContainer.getSize().getHeight() / 2);
        int endY = startY - 1000; // hacia arriba

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
        esperar(1);
    }
}
