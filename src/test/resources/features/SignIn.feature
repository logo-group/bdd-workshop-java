@SignIn
@txn
Feature: SignIn

  Background:
    Given There are users
      | username | password | email      |
      | erman    | 123      | erman@logo |
      | oguz     | 1234     | oguz@logo  |

  Scenario: SignIn successfully
    When I try to sign-in with "erman", "123"
    Then Sign-in completed successfully

  Scenario: SignIn with wrong password
    When I try to sign-in with "erman", "12"
    Then Sign-in completed unsuccessfully with message "user not found"

  Scenario: Get user info
    When I try to sign-in with "erman", "123"
    Then Sign-in completed successfully
    And Following user obtained
      | username | password | email      |
      | erman    | 123      | erman@logo |
