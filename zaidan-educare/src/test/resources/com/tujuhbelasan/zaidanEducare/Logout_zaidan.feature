Feature: User Logout
  Scenario: Logout from applicaton/website
    Given User open the browser
    And User navigates to Login page
    And User login as bendahara
    And User navigates to Dashboard page
    When User clicks on logout button
    And Clicks on logout confirmation pop up button
    Then User should navigated to the Login page
