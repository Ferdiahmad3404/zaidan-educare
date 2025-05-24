Feature: User Login
  Scenario: Login with valid credentials as bendahara
    Given User open the browser
    And User navigates to Login page
    When User enters username "bendahara"
    And Enters password "admin123"
    And Clicks on login button
    Then User should login successfully

  Scenario: Login with invalid credentials
    Given User open the browser
    And User navigates to Login page
    When User enters username "indra"
    And Enters password "admin123"
    And Clicks on login button
    Then User should get a warning message "Username atau password salah"
