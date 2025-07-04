package mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import mobile.pages.LoginPage;
import mobile.pages.MenuPage;
import mobile.pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void testSuccessfulRegistrationAndLogin() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.goToLogin(); //Ir a Login

        // Clic a registro
        driver.findElement(AppiumBy.accessibilityId("button-sign-up-container")).click();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("testuser@example.com", "12345678");

        String message = registerPage.getSuccessMessage();
        Assert.assertTrue(message.contains("You successfully signed up!"), "El mensaje de registro no fue el esperado");

        registerPage.confirmAlert();

        // Volver a Login
        driver.findElement(AppiumBy.accessibilityId("button-login-container")).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser@example.com");
        loginPage.enterPassword("12345678");
        loginPage.submitLogin();

        String loginMessage = loginPage.getSuccessMessage();
        Assert.assertTrue(loginMessage.contains("You are logged in"), "El login no fue exitoso");
    }
}
