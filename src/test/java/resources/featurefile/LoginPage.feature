
#Create a project using Java to navigate to our website 'https://www.heartbingo.co.uk'
#and create test(s) in relation to login.
#
#e.g. Test that the error message appears and is displayed correctly with invalid credentials,
#or any other scenarios like website loads or login page opens successfully or any other elements
#you can assert.

Feature: Check Login functionality

  Scenario: User can open login popup successfully
    Given   User enters website URL on browser
    When    User clicks on log in button from top right corner of the page
    Then    User can see log in popup

  Scenario Outline: User cannot login with invalid credentials
    When    User clicks on log in button from top right corner of the page
    And     User enters "<username>" and "<password>"
    And     User clicks on 'Log in' button
    Then    User can see 'The username or password you entered is incorrect.' error message
    Examples:
      | username     | password |
      | Abcdefg      | abC123   |
      | jj@gmail.com | Abc123$  |
      | 123456       | 123456   |






