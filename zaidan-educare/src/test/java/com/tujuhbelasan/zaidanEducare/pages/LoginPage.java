package com.tujuhbelasan.zaidanEducare.pages;

import com.tujuhbelasan.zaidanEducare.locators.LoginPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement usernameTextbox = driver.findElement(LoginPageLocators.USERNAME_TEXTBOX);
        usernameTextbox.clear();
        usernameTextbox.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordTextbox = driver.findElement(LoginPageLocators.PASSWORD_TEXTBOX);
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(LoginPageLocators.ERROR_MESSAGE).getText().trim();
    }

    public boolean isLoginPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.USERNAME_TEXTBOX));
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.PASSWORD_TEXTBOX));
            return driver.findElement(LoginPageLocators.USERNAME_TEXTBOX).isDisplayed()
                    && driver.findElement(LoginPageLocators.PASSWORD_TEXTBOX).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}