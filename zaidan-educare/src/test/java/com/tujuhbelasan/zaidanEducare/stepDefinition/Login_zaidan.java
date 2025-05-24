package com.tujuhbelasan.zaidanEducare.stepDefinition;

import com.tujuhbelasan.zaidanEducare.pages.LoginPage;
import com.tujuhbelasan.zaidanEducare.pages.DashboardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.tujuhbelasan.zaidanEducare.utility.BrowserDriver.driver;

public class Login_zaidan {

    LoginPage loginPage;

    @Given("User navigated to Login page")
    public void user_navigated_to_login_page() {
        driver.get("http://ptbsp.ddns.net:6882/login");
        loginPage = new LoginPage(driver); // inisialisasi di sini
        System.out.println("✅ Login page opened: http://ptbsp.ddns.net:6882/login");
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUsername(username);
        System.out.println("Username entered");
    }
    @When("Enters password {string}")
    public void enters_password(String password) {
        loginPage.enterPassword(password);
        System.out.println("Password entered");
    }
    @When("Clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLoginButton();
        System.out.println("Login button clicked");
    }

    @Then("User navigated to bendahara Dashboard page")
    public void user_navigated_to_dashboard_page() {
        DashboardPage dashboardPage = new DashboardPage(driver);
            assertTrue(dashboardPage.isAtDashboardAsBendahara(), "❌ User is not at the dashboard");
        System.out.println("✅ Login successful and dashboard is visible");
    }

    @Then("User should see the following sidebar items:")
    public void user_should_see_the_following_sidebar_items(io.cucumber.datatable.DataTable dataTable) {
        DashboardPage dashboardPage = new DashboardPage(driver);
        List<String> expectedItems = dataTable.asList();
        List<String> actualItems = dashboardPage.getSidebarItemsText();

        for (String expectedItem : expectedItems) {
            boolean found = false;
            for (String actualItem : actualItems) {
                if (actualItem.equalsIgnoreCase(expectedItem)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "Sidebar tidak mengandung item yang diharapkan: " + expectedItem);
        }
    }

    @Then("User should get a warning message {string}")
    public void user_should_get_a_warning_message(String expectedMessage) {

        assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

}
