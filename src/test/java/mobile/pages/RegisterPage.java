package mobile.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class RegisterPage {

    private AppiumDriver driver;

    private By emailInput = AppiumBy.accessibilityId("input-email");
    private By passwordInput = AppiumBy.accessibilityId("input-password");
    private By repeatPasswordInput = AppiumBy.accessibilityId("input-repeat-password");
    private By signUpButton = AppiumBy.accessibilityId("button-SIGN UP");
    private By successMessage = By.xpath("//android.widget.TextView[contains(@text,'You successfully signed up!')]");
    
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return msg.getText();
    }

    public void confirmAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(okButton));
        ok.click();
    }
}
