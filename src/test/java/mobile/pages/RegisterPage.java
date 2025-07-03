package mobile.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class RegisterPage {

    private AppiumDriver driver;

    private By emailInput = AppiumBy.accessibilityId("input-email");
    private By passwordInput = AppiumBy.accessibilityId("input-password");
    private By repeatPasswordInput = AppiumBy.accessibilityId("input-repeat-password");
    private By signUpButton = AppiumBy.accessibilityId("button-SIGN UP");
    private By successMessage = By.id("android:id/message");
    private By okButton = By.id("android:id/button1");

    public RegisterPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void register(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(repeatPasswordInput).sendKeys(password);
        driver.findElement(signUpButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public void confirmAlert() {
        driver.findElement(okButton).click();
    }
}
