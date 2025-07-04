package mobile.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class MenuPage {

    private AppiumDriver driver;

    private By homeTab = AppiumBy.accessibilityId("Home");
    private By webViewTab = AppiumBy.accessibilityId("Webview");
    private By loginTab = AppiumBy.accessibilityId("Login");
    private By formsTab = AppiumBy.accessibilityId("Forms");
    private By swipeTab = AppiumBy.accessibilityId("Swipe");
    private By dragTab = AppiumBy.accessibilityId("Drag");

    public MenuPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void goToHome() {
        driver.findElement(homeTab).click();
    }

    public void goToWebView() {
        driver.findElement(webViewTab).click();
    }

    public void goToLogin() {
        driver.findElement(loginTab).click();
    }

    public void goToForms() {
        driver.findElement(formsTab).click();
    }

    public void goToSwipe() {
        driver.findElement(swipeTab).click();
    }

    public void goToDrag() {
        driver.findElement(dragTab).click();
    }

    public void goToRegister() {
        goToForms();
    }
}
