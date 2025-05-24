package com.tujuhbelasan.zaidanEducare.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {
    public static WebDriver driver;

    String driverUrl = "/src/test/resources/drivers/chromedriver.exe";

    public BrowserDriver() {
        this.driver = driver;
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverUrl);
        this.driver = new ChromeDriver();
    }

    public void clsoe() {
        this.driver.close();
    }
}
