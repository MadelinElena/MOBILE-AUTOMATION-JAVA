package mobile.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LoginPage {

    private AppiumDriver driver;

    // Elementos
    private By emailField = AppiumBy.accessibilityId("input-email");
    private By passwordField = AppiumBy.accessibilityId("input-password");
    private By loginButton = AppiumBy.accessibilityId("button-LOGIN");
    private By alertMessage = AppiumBy.id("android:id/message");
    private By okButton = AppiumBy.id("android:id/button1");

    // Constructor
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Métodos
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(loginButton).click();
    }

    public String getAlertMessage() {
        return driver.findElement(alertMessage).getText();
    }

    public void confirmAlert() {
        driver.findElement(okButton).click();
    }
}
