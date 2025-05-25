package com.tujuhbelasan.zaidanEducare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    // Tambahkan selector untuk tombol profil/user (biasanya ada di pojok kanan atas)
    @FindBy(css = ".user-menu, .user-profile, .avatar")
    WebElement userMenu;

    // Deklarasi tombol logout (akan dicari langsung via selector By)
    private By confirmLogoutBy = By.xpath("//button[contains(text(),'Ya') or contains(text(),'Keluar')]");


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

   /**
     * Melakukan klik pada tombol logout
     */
    public void clickLogoutButton() {
        try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript(
                    "var elements = document.querySelectorAll('a, button, span, div');" +
                    "for(var i=0; i<elements.length; i++){" +
                    "  if(elements[i].innerText && elements[i].innerText.includes('Logout')){" +
                    "    elements[i].click(); return;" +
                    "  }" +
                    "}"
                );
                System.out.println("Logout dijalankan via JavaScript");
            } catch (Exception jsError) {
                System.err.println("Gagal melakukan logout: " + jsError.getMessage());
                throw new RuntimeException("Tidak dapat menemukan tombol logout", jsError);
            }
    }

    /**
     * Mengkonfirmasi logout pada popup konfirmasi
     */
    public void confirmLogout() {
        try {
            Thread.sleep(1000); // Tunggu dialog muncul
            WebElement confirmButton = driver.findElement(confirmLogoutBy);
            confirmButton.click();
            System.out.println("Tombol konfirmasi logout diklik");
        } catch (Exception e) {

            System.out.println("Tidak ada dialog konfirmasi atau logout langsung berhasil");
        }
    }
}
