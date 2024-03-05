Feature: User Login

  Scenario: Successful login with valid credentials
    Given I am on the homepage
    When I click the login button
    And I enter the username "zamirprueba999" and password "zamirprueba999"
    And I click the login modal button
    Then I should be logged in
