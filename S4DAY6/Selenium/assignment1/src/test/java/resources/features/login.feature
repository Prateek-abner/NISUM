Feature: User Login
  As a user
  I want to log in to the application
  So that I can access my dashboard

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "user@example.com" and password "password123"
    And I click the login button
    Then I should be redirected to the dashboard
    And I should see a welcome message

  Scenario Outline: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see an error message "<errorMessage>"

    Examples:
      | username            | password    | errorMessage                   |
      | invalid@example.com | wrong       | Invalid username or password   |
      | user@example.com   |             | Password is required           |
      |                    | password123 | Username is required           |
