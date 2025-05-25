package com.tujuhbelasan.zaidanEducare.hooks;

import com.tujuhbelasan.zaidanEducare.utility.BrowserDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

import static com.tujuhbelasan.zaidanEducare.utility.BrowserDriver.driver;

public class AppHooks {

    @Before
    public void beforeScenario() {
        new BrowserDriver();
        driver.manage().window().maximize();
        System.out.println("✅ Browser dibuka sebelum scenario");
    }

    @BeforeStep
    public void delayPerStep() throws InterruptedException {
        Thread.sleep(300); // Delay 3 detik setiap step
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit(); // tutup semua tab dan browser
            System.out.println("🛑 Browser ditutup setelah scenario");
        }
    }

    @After("@logout")
    public void afterLogoutScenario() {
        try {
            if (driver != null && !driver.getCurrentUrl().contains("login")) {
                driver.get("http://ptbsp.ddns.net:6882/login");
                System.out.println("⚠️ Kembali ke halaman login setelah logout");
            }
        } catch (Exception e) {
            System.err.println("Gagal mengarahkan ke halaman login: " + e.getMessage());
        }
    }
}
