package com.tujuhbelasan.zaidanEducare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Dasbor - Bendahara')]")
    WebElement dashboardHeading;

    // Ambil semua item di sidebar
    @FindBy(xpath = "//li[@data-sidebar='menu-item']//span")
    List<WebElement> sidebarItems;

    public boolean isAtDashboardAsBendahara() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(dashboardHeading));
            return dashboardHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Mengembalikan semua teks dari item sidebar
    public List<String> getSidebarItemsText() {
        List<String> itemsText = new ArrayList<>();
        for (WebElement item : sidebarItems) {
            itemsText.add(item.getText().trim());
        }
        return itemsText;
    }

    // Mengecek apakah sidebar mengandung item tertentu
    public boolean sidebarContains(String expectedItem) {
        for (WebElement item : sidebarItems) {
            if (item.getText().trim().equalsIgnoreCase(expectedItem)) {
                return true;
            }
        }
        return false;
    }
}
