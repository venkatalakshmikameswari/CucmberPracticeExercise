Feature:Google Search

Scenario: Validate google search text field
Given I open a browser
When I navigate to google page
And I Entered the text in search field
Then I validate the search text field

 Scenario Outline: Simple Google searches
    Given a web browser is on the Google page
    When the search phrase "<input>" is entered
    Then results for "<output>" are shown
  Examples:
    |input 	 |output 	|
    |rest    |rest    |
    |Coin    |Coin    |
    |Space   |Space   |
   