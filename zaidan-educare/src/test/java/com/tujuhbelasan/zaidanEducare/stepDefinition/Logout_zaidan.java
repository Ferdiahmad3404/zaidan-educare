package com.tujuhbelasan.zaidanEducare.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout_zaidan {
    @And("User navigates to Dashboard page")
    public void userNavigatesToDashboardPage() {
        System.out.println("Dashboard page opened");
    }

    @When("User clicks on logout button")
    public void userClicksOnLogoutButton() {
        System.out.println("Logout button clicked");
    }

    @And("Clicks on logout confirmation pop up button")
    public void clicksOnLogoutConfirmationPopUpButton() {
        System.out.println("Logout confirmation pop up button clicked");
    }

    @Then("User should navigated to the Login page")
    public void userShouldNavigatedToTheLoginPage() {
        System.out.println("Login page opened");
    }
}
