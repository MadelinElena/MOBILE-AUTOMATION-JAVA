package mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import mobile.pages.LoginPage;
import mobile.pages.MenuPage;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.goToLogin();  // Primero a Login

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("bob@example.com");
        loginPage.enterPassword("10203040");
        loginPage.submitLogin();

        String message = loginPage.getAlertMessage();
        Assert.assertTrue(message.contains("You are logged in"), "Mensaje esperado no fue mostrado.");

        loginPage.confirmAlert(); // Cerrar
    }
}
