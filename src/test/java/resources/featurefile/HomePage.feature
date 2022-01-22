
#Create a project using Java to navigate to our website 'https://www.heartbingo.co.uk'
#and create test(s) in relation to login.
#
#e.g. Test that the error message appears and is displayed correctly with invalid credentials,
#or any other scenarios like website loads or login page opens successfully or any other elements
#you can assert.

Feature: Check homepage functionality


 Scenario Outline: User can click on top menu items
    When            User clicks on "<menuItem>" item
    Then            User is able to navigate to "<url>" for "<menuItem>"
    Examples:
      | menuItem | url                                         |
      | Bingo    | https://www.heartbingo.co.uk/en-gb/bingo    |
      | Jackpots | https://www.heartbingo.co.uk/en-gb/jackpots |
      | Slots    | https://www.heartbingo.co.uk/en-gb/slots    |
      | Casino   | https://www.heartbingo.co.uk/en-gb/casino   |
      | Promos   | https://www.heartbingo.co.uk/en-gb/offer    |







