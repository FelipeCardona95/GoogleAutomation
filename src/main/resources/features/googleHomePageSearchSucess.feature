Feature: Google Homepage Search

  Scenario Outline: User search on Google's Search Bar
    Given the user is on the google home page
    When the user searches for <bookName> in the Search Bar
    And the results page shows
    And the user clicks the first result being <expectedResult>
    Then the user is gonna be redirect to the <expectedPageTitle> page

    Examples:
      | bookName             | expectedResult                          | expectedPageTitle            |
      |The name of the wind|El nombre del viento - Wikipedia, la enciclopedia libre|El nombre del viento - Wikipedia, la enciclopedia libre|





