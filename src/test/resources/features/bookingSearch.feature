Feature: Booking search tests

  Background:
  Given I am at booking.com page

  Scenario Outline: Search for Booking
    When I set "<searchValue>" into search bar
    And I click on Search button
    Then "<expectedResult>" should be present in first search result title
    Examples:
      |searchValue |expectedResult|
      |Royalton New York|Royalton New York|
      |The Newbury Boston|The Newbury Boston|




