package com.tujuhbelasan.zaidanEducare.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Map;

public class BrowserDriver {
    public static WebDriver driver;

    public BrowserDriver() {
        if (initChrome()) {
            System.out.println("✅ Using Google Chrome browser");
        } else {
            throw new RuntimeException("⚠️ Google Chrome gagal diinisialisasi.");
        }
    }

    private boolean initChrome() {
        try {
            // Setting up WebDriverManager untuk Chrome
            WebDriverManager.chromedriver().setup();

            // Konfigurasi ChromeOptions
            ChromeOptions options = new ChromeOptions();

            options.setExperimentalOption("prefs", Map.of(
                    "credentials_enable_service", false, // Nonaktifkan kredensial
                    "profile.password_manager_enabled", false, // Nonaktifkan password manager
                    "profile.password_manager_leak_detection", false
            ));


            // Nonaktifkan pop-up keamanan Chrome
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized"); // Jalankan browser dalam mode maksimal

            // (Opsional) Jalankan browser tanpa UI
            // options.addArguments("--headless"); // Hanya untuk penggunaan tanpa tampilan

            // Inisialisasi ChromeDriver dengan opsi
            driver = new ChromeDriver(options);
            return true;
        } catch (Exception e) {
            System.out.println("⚠️ Gagal memulai Chrome: " + e.getMessage());
            return false;
        }
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}