Feature: Login Functionality for OpenCart E-Commerce Website

  As a user of the OpenCart website
  I want to be able to log in with my account
  So i can access my account-related features  and manage my orders

  Background:
    Given i am on the OpenCart login page

  Scenario: successful login with valid credentials
    Given i have entered a valid username and password
    When i click on the login button
    Then i should be logged in successfully

  Scenario Outline: unsuccessful login with invalid or empty credentials
    Given i have entered invalid "<username>" and "<password>"
    When i click on the login button
    Then i should see an error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message                                                                                    |
      | invalid@email.com | invalidPassword | Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour. |
      | abcdefg           | validPassword   | Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour. |
      | valid@email.com   | abccc           | Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour. |

  Scenario: Navigate to forgotten password page
    When i click on the "forgot password" link
    Then i should be redirected to the password reset page