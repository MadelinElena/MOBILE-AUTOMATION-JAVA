package mobile.test;

import mobile.pages.MenuPage;
import mobile.pages.SwipePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    @Test
    public void testSwipeAndScroll() {
        MenuPage menu = new MenuPage(driver);
        menu.goToSwipe();

        SwipePage swipePage = new SwipePage(driver);
        swipePage.swipeCarousel();
        swipePage.scrollToHiddenText();

        // Verificamos que el texto realmente está presente luego del scroll
        WebElement hiddenText = driver.findElement(By.xpath("//*[@text='You found me!!!']"));
        Assert.assertTrue(hiddenText.isDisplayed(), "Hidden text 'You found me!!!' was not found after scrolling.");
    }
}
