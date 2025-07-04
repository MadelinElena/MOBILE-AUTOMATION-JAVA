package mobile.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mobile.pages.MenuPage;
import mobile.pages.SwipePage;

public class SwipeTest extends BaseTest {

    private MenuPage menuPage;
    private SwipePage swipePage;

    @BeforeMethod
    public void setUpTest() {
        menuPage = new MenuPage(driver);
        swipePage = new SwipePage(driver);
        menuPage.goToSwipe();
    }

    @Test
    public void testSwipeCarouselAndScrollToHiddenText() {
        SoftAssert softAssert = new SoftAssert();

        swipePage.swipeAllCarouselCards();
        swipePage.scrollDownUntilFound();

        boolean isVisible = swipePage.isHiddenTextVisible();
        System.out.println("¿Se encontró el texto?: " + isVisible);
        softAssert.assertTrue(isVisible, "'You found me!!!' no fue encontrado tras hacer scroll.");

        softAssert.assertAll();
    }
}
