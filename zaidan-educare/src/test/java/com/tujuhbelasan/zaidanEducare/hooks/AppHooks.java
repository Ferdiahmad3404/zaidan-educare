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
        Thread.sleep(500); // Delay 3 detik setiap step
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit(); // tutup semua tab dan browser
            System.out.println("🛑 Browser ditutup setelah scenario");
        }
    }
}
