Feature: Login feature fos OpenCart Application

  Scenario: Validate Login scenario with valid username and password.
    Given User is on the Login page
    When User enters a valid username and password
    And User clicks on Login button
    Then User should be logged in successfully

  Scenario Outline: Validate Login scenario with invalid username and password
    Given User is on the Login page
    When User enters a invalid "<username>" and "<password>"
    And User clicks on Login button
    Then User should be see "<WarningMsg>"

    Examples:
      | username | password    | WarningMsg                                            |
      | Ranjan12 | Test1213    | Warning: No match for E-Mail Address and/or Password. |
      | Raj212   | Test1221234 | Warning: No match for E-Mail Address and/or Password. |

  @Ranjan
  Scenario: Validate Forgot password link on Login page.
    Given User is on the Login page
    When User verifies the Forgot password
    When User clicks on Forgot Password link
    Then User should navigate to Forgot password page