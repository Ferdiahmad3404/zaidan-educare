package com.tujuhbelasan.zaidanEducare.stepDefinition;

import com.tujuhbelasan.zaidanEducare.pages.DashboardPage;
import com.tujuhbelasan.zaidanEducare.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.tujuhbelasan.zaidanEducare.utility.BrowserDriver.driver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Logout_zaidan {
    
    // Deklarasi variabel halaman yang dibutuhkan
    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    
    @And("User navigates to Dashboard page")
    public void userNavigatesToDashboardPage() {
        // Inisialisasi dashboard page
        dashboardPage = new DashboardPage(driver);
        
        // Verifikasi bahwa pengguna berada di halaman dashboard
        assertTrue(dashboardPage.isAtDashboardAsBendahara(), 
                "Pengguna tidak berada di halaman dashboard bendahara");
        System.out.println("Dashboard page opened");
    }

    @When("User clicks on logout button")
    public void userClicksOnLogoutButton() {
        // Klik tombol logout
        dashboardPage.clickLogoutButton();
        System.out.println("Logout button clicked");
    }

    @And("Clicks on logout confirmation pop up button")
    public void clicksOnLogoutConfirmationPopUpButton() {
        // Konfirmasi logout 
        dashboardPage.confirmLogout();
        System.out.println("Logout confirmation pop up button clicked");
    }

    @Then("User should navigated to the Login page")
    public void userShouldNavigatedToTheLoginPage() {
        try {
            // Tunggu proses logout selesai
            Thread.sleep(2000);
            
            // Reload halaman untuk memastikan redirects berfungsi
            driver.navigate().refresh();
            
            // Tunggu sebentar setelah refresh
            Thread.sleep(1000);
            
            // Periksa URL saat ini
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL after logout: " + currentUrl);
            
            // Verifikasi URL login
            boolean isOnLoginPage = currentUrl.contains("login");
            assertTrue(isOnLoginPage, "Pengguna tidak berada di halaman login. URL saat ini: " + currentUrl);
            System.out.println("Login page opened successfully - URL: " + currentUrl);
        } catch (Exception e) {
            throw new AssertionError("Gagal memverifikasi halaman login: " + e.getMessage(), e);
        }
    }
}
