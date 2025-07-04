package mobile.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LoginPage {

    private AppiumDriver driver;

    private By emailInput = AppiumBy.accessibilityId("input-email");
    private By passwordInput = AppiumBy.accessibilityId("input-password");
    private By loginButton = AppiumBy.accessibilityId("button-LOGIN");

    // Confirmación
    private By alertMessage = By.id("android:id/message");
    private By okButton = By.id("android:id/button1");

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
        return msg.getText();
    }

    public void confirmAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(okButton));
        btn.click();
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//android.widget.TextView[contains(@text,'You are logged in')]")
        ));
    return msg.getText();
}
}
