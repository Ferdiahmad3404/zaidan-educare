package com.tujuhbelasan.zaidanEducare.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class BrowserDriver {
    public static WebDriver driver;

    public BrowserDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/msedgedriver.exe");

        // Try browsers in this order: Chrome, Brave, Edge
        if (initChrome()) {
            System.out.println("Using Google Chrome browser");
        } else if (initBrave()) {
            System.out.println("Using Brave browser");
        } else if (initEdge()) {
            System.out.println("Using Microsoft Edge browser");
        } else {
            throw new RuntimeException("No supported browsers (Chrome, Brave, or Edge) found on this system");
        }
    }

    private boolean initChrome() {
        List<String> chromePaths = Arrays.asList(
            "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
            "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
        );

        for (String path : chromePaths) {
            if (new File(path).exists()) {
                try {
                    ChromeOptions options = new ChromeOptions();
                    options.setBinary(path);
                    driver = new ChromeDriver(options);
                    return true;
                } catch (Exception e) {
                    System.out.println("Chrome found but failed to initialize: " + e.getMessage());
                }
            }
        }
        return false;
    }

    private boolean initBrave() {
        List<String> bravePaths = Arrays.asList(
            "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe",
            "C:\\Program Files (x86)\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
        );

        for (String path : bravePaths) {
            if (new File(path).exists()) {
                try {
                    ChromeOptions options = new ChromeOptions();
                    options.setBinary(path);
                    driver = new ChromeDriver(options);
                    return true;
                } catch (Exception e) {
                    System.out.println("Brave found but failed to initialize: " + e.getMessage());
                }
            }
        }
        return false;
    }

    private boolean initEdge() {
        List<String> edgePaths = Arrays.asList(
            "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
            "C:\\Program Files\\Microsoft\\Edge\\Application\\msedge.exe"
        );

        for (String path : edgePaths) {
            if (new File(path).exists()) {
                try {
                    EdgeOptions options = new EdgeOptions();
                    options.setBinary(path);
                    driver = new EdgeDriver(options);
                    return true;
                } catch (Exception e) {
                    System.out.println("Edge found but failed to initialize: " + e.getMessage());
                }
            }
        }
        return false;
    }

    public static void close() {
        if (driver != null) {
            driver.close();
        }
    }
}