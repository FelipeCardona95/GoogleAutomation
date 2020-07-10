Feature: Google Homepage Search Suggestions

  Scenario Outline: User search on Google's Search Bar
    Given the user is on the google home page
    When the suggestion list shows by the user typing <searchWord> on the search bar
    And the user clicks the first suggestion
    And the user clicks the first result being <expectedResult>
    Then the user is gonna be redirect to the <expectedPageTitle> page

    Examples:
      | searchWord           | expectedResult                          | expectedPageTitle            |
      |The name of the w|El nombre del viento - Wikipedia, la enciclopedia libre|El nombre del viento - Wikipedia, la enciclopedia libre|


