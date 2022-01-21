Feature: Check homepage functionality


  Scenario: User can open login popup successfully
    Given   User enters website URL on browser
    When    User clicks on log in button from top right corner of the page
#    Then    User can see log in popup

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







