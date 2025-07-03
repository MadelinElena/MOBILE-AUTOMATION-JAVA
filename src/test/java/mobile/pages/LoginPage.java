package mobile.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LoginPage {

    private AppiumDriver driver;

    private By emailInput = AppiumBy.accessibilityId("input-email");
    private By passwordInput = AppiumBy.accessibilityId("input-password");
    private By loginButton = AppiumBy.accessibilityId("button-LOGIN");
    private By successAlertMessage = AppiumBy.id("android:id/message");
    private By alertOkButton = AppiumBy.id("android:id/button1");

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(loginButton).click();
    }

    public String getAlertMessage() {
        return driver.findElement(successAlertMessage).getText();
    }

    public void confirmAlert() {
        driver.findElement(alertOkButton).click();
    }
}
