Feature: User Logout
  Scenario: Check logout is successful with valid credentials as role "Bendahara"
    Given User open the browser
    And User navigates to Login page
    And User enters username "bendahara"
    And Enters password "admin123"
    And Clicks on login button
    And User navigates to Dashboard page
    When User clicks on logout button
    And Clicks on logout confirmation pop up button
    Then User should navigated to the Login page
