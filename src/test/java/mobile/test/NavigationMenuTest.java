package mobile.test;

import org.testng.annotations.Test;

import mobile.pages.MenuPage;

public class NavigationMenuTest extends BaseTest {

    @Test
    public void testMenuNavigation() {
        MenuPage menu = new MenuPage(driver);

        menu.goToHome();
        menu.goToWebView();
        menu.goToLogin();
        menu.goToForms();
        menu.goToSwipe();
        menu.goToDrag();
    }
}
