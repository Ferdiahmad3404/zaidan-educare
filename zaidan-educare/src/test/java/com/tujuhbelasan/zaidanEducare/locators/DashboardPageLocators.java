package com.tujuhbelasan.zaidanEducare.locators;

import org.openqa.selenium.By;

public class DashboardPageLocators {

    // Locator untuk elemen pada dashboard
    public static final By DASHBOARD_HEADING = By.xpath("//h1[contains(text(),'Dasbor - Bendahara')]");
    public static final By SIDEBAR_ITEMS = By.xpath("//li[@data-sidebar='menu-item']//span");
    public static final By USER_MENU = By.xpath("/html/body/div[2]/main/div/div[1]/div/div/div[2]/button");
    public static final By LOGOUT_BUTTON = By.xpath("/html/body/div[2]/main/div/div[1]/div/div/div[2]/button");
    public static final By CONFIRM_LOGOUT_BUTTON = By.xpath("//button[contains(text(),'Ya') or contains(text(),'Keluar')]");
}