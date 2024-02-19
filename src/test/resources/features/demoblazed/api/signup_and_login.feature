@SignupAndLogin
Feature: Signup and log in

  @Signup
  Scenario: Create a new user
    When Buyer tries to create a new user that does not exist in demoblaze
    Then he should see that the user was created correctly
    But he tries to create a user that already exists
    Then he should see that it is not possible to create the user because it already exists

  @Login
  Scenario: Log in to platform
    When Buyer tries to log in with a valid username
    Then he should see a successful login
    But he tries to log in with incorrect information
    Then he should see that the login was not successful