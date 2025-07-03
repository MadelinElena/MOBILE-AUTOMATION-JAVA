package mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import mobile.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser@mail.com");
        loginPage.enterPassword("Test1234");
        loginPage.submitLogin();

        Assert.assertEquals(loginPage.getAlertMessage(), "You are logged in!");
        loginPage.confirmAlert();
    }
}
