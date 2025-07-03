package mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import mobile.pages.MenuPage;
import mobile.pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void testSuccessfulRegistration() {
        MenuPage menu = new MenuPage(driver);
        menu.goToLogin();

        // En la pantalla Login, hay un botón para navegar al registro
        driver.findElement(AppiumBy.accessibilityId("button-sign-up-container")).click();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("testuser@mail.com", "Test1234");

        Assert.assertEquals(registerPage.getSuccessMessage(), "You successfully signed up!");
        registerPage.confirmAlert();
    }
}
