package com.tujuhbelasan.zaidanEducare.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {

    // Locator untuk elemen pada halaman login
    public static final By USERNAME_TEXTBOX = By.name("username");
    public static final By PASSWORD_TEXTBOX = By.name("password");
    public static final By LOGIN_BUTTON = By.xpath("/html/body/div[2]/div/div[2]/div/div/form/button");
    public static final By ERROR_MESSAGE = By.xpath("//div[contains(@class, 'flex') and contains(@class, 'justify-between')]//p");
}