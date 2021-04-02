Feature: HomePage

  Scenario: Verify the Temperature
    Given User will be on home page
    When User delete the location box
    And User enter the location
    And Click the search button
    Then Verify the lowest and highest temp is displayed correctly


