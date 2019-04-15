@SignUp
@txn
Feature: SignUp

  Rule:
  -username , password , email reqiered
  -password length must be min 3
  -email must contains '@' character

  Scenario: SignUp successfully
    When I try to sign-up with following
      | username | password | email      |
      | erman    | 123      | erman@logo |
    Then Sign-up completed successfully

  Scenario: SignUp with invalid password
    When I try to sign-up with following
      | username | password | email      |
      | erman    | 12       | erman@logo |
    Then Sign-up completed unsuccessfully with message "invalid password"

  Scenario: SignUp with invalid email
    When I try to sign-up with following
      | username | password | email     |
      | erman    | 123      | ermanlogo |
    Then Sign-up completed unsuccessfully with message "invalid email"

