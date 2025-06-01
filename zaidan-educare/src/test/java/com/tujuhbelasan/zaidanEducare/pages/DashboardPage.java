package com.tujuhbelasan.zaidanEducare.pages;

import com.tujuhbelasan.zaidanEducare.locators.DashboardPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAtDashboardAsBendahara() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardPageLocators.DASHBOARD_HEADING));
            return driver.findElement(DashboardPageLocators.DASHBOARD_HEADING).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> getSidebarItemsText() {
        List<WebElement> sidebarElements = driver.findElements(DashboardPageLocators.SIDEBAR_ITEMS);
        List<String> itemsText = new ArrayList<>();
        for (WebElement item : sidebarElements) {
            itemsText.add(item.getText().trim());
        }
        return itemsText;
    }

    public boolean sidebarContains(String expectedItem) {
        List<WebElement> sidebarElements = driver.findElements(DashboardPageLocators.SIDEBAR_ITEMS);
        for (WebElement item : sidebarElements) {
            if (item.getText().trim().equalsIgnoreCase(expectedItem)) {
                return true;
            }
        }
        return false;
    }

    public void clickLogoutButton() {
        WebElement userMenu = driver.findElement(DashboardPageLocators.LOGOUT_BUTTON);

        try {
            userMenu.click();
        } catch (Exception e) {
            throw new RuntimeException("Tidak dapat menemukan tombol logout", e);
        }
    }

    public void confirmLogout() {
        try {
            WebElement confirmButton = driver.findElement(DashboardPageLocators.CONFIRM_LOGOUT_BUTTON);
            confirmButton.click();
        } catch (Exception e) {
            System.out.println("Tidak ada dialog konfirmasi atau logout langsung berhasil");
        }
    }
}