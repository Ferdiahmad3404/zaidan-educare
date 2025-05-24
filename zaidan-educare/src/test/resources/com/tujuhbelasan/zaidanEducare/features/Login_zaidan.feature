Feature: User Login
  Scenario: Check login is successful with valid credentials as role "bendahara"
    Given User open the browser
    And User navigates to Login page
    When User enters username "bendahara"
    And Enters password "admin123"
    And Clicks on login button
    Then User should login successfully

  Scenario: Check login is un-successful with invalid credentials. Its is username not registered
    Given User open the browser
    And User navigates to Login page
    When User enters username "indra"
    And Enters password "admin123"
    And Clicks on login button
    Then User should get a warning message "Username atau password salah"
