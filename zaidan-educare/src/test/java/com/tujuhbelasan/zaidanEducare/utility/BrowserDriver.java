package com.tujuhbelasan.zaidanEducare.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BrowserDriver {
    public static WebDriver driver;

    public BrowserDriver() {
        // Try browsers in this order: Chrome, Brave, Edge, Firefox
        if (initChrome()) {
            System.out.println("✅ Using Google Chrome browser");
        } else if (initBrave()) {
            System.out.println("✅ Using Brave browser");
        } else if (initEdge()) {
            System.out.println("✅ Using Microsoft Edge browser");
        } else if (initFirefox()) {
            System.out.println("✅ Using Firefox browser");
        } else {
            throw new RuntimeException("⚠️ No supported browsers found on this system");
        }
    }

    private boolean initChrome() {
        try {
            // Explicitly set WebDriverManager to use the latest ChromeDriver
            WebDriverManager.chromedriver().clearDriverCache().forceDownload().setup();

            // Configure Chrome options
            ChromeOptions options = new ChromeOptions();
            
            // Important: Add this to fix CDP version mismatch
            options.addArguments("--remote-allow-origins=*");

            options.setExperimentalOption("prefs", Map.of(
                    "credentials_enable_service", false,
                    "profile.password_manager_enabled", false,
                    "profile.password_manager_leak_detection", false
            ));

            // Disable Chrome security pop-ups
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            
            // Initialize ChromeDriver with options
            driver = new ChromeDriver(options);
            return true;
        } catch (Exception e) {
            System.out.println("⚠️ Chrome browser failed to initialize: " + e.getMessage());
            return false;
        }
    }

    private boolean initBrave() {
        List<String> bravePaths = Arrays.asList(
            "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe",
            "C:\\Program Files (x86)\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
        );

        for (String path : bravePaths) {
            if (new File(path).exists()) {
                try {
                    // Explicitly set WebDriverManager to use the latest ChromeDriver
                    WebDriverManager.chromedriver().clearDriverCache().forceDownload().setup();
                    
                    // Configure ChromeOptions for Brave
                    ChromeOptions options = new ChromeOptions();
                    options.setBinary(path);
                    
                    // Important: Add this to fix CDP version mismatch
                    options.addArguments("--remote-allow-origins=*");
                    
                    options.setExperimentalOption("prefs", Map.of(
                            "credentials_enable_service", false,
                            "profile.password_manager_enabled", false,
                            "profile.password_manager_leak_detection", false
                    ));
                    
                    // Disable Brave security pop-ups
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-infobars");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--start-maximized");
                    
                    // Initialize ChromeDriver with Brave binary
                    driver = new ChromeDriver(options);
                    return true;
                } catch (Exception e) {
                    System.out.println("⚠️ Brave browser found but failed to initialize: " + e.getMessage());
                }
            }
        }
        return false;
    }

    private boolean initEdge() {
        try {
            // Explicitly set WebDriverManager to use the latest EdgeDriver
            WebDriverManager.edgedriver().clearDriverCache().forceDownload().setup();
            
            // Configure EdgeOptions
            EdgeOptions options = new EdgeOptions();
            
            // Disable Edge security pop-ups
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            
            // Initialize EdgeDriver
            driver = new EdgeDriver(options);
            return true;
        } catch (Exception e) {
            System.out.println("⚠️ Edge browser failed to initialize: " + e.getMessage());
            return false;
        }
    }
    
    private boolean initFirefox() {
        try {
            // Explicitly set WebDriverManager to use the latest FirefoxDriver
            WebDriverManager.firefoxdriver().clearDriverCache().forceDownload().setup();
            
            // Configure FirefoxOptions
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
            
            // Initialize FirefoxDriver
            driver = new FirefoxDriver(options);
            return true;
        } catch (Exception e) {
            System.out.println("⚠️ Firefox browser failed to initialize: " + e.getMessage());
            return false;
        }
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}