Feature: TrendyolSearchApi Scenarios

  Scenario: Checking is searchingApi successfully working without parameters
    When Perform get operation for SEARCH with empty parameter
    Then Checking response status code is successfull

  Scenario: Checking is searchingApi successfully working
    When Perform get operation for SEARCH with "çanta" keyword
    Then Checking response status code is successfull
    
   Scenario: Checking is searchingApi response time is matches with given milisecond parameter
     When Perform get operation for SEARCH with "çanta" keyword
     Then Checking response time is lower than with keyword and "1500" milisecond

  Scenario: Checking is searchingApi title matches with keyword
    When Perform get operation for SEARCH with "çanta" keyword
    And Checking response title is match with "çanta" keyword

  Scenario: Checking is searchingApi cookies not empty
    When Perform get operation for SEARCH with "çanta" keyword
    And Checking response cookie is not empty

  Scenario: Checking is searchingApi running true server
    When Perform get operation for SEARCH with "çanta" keyword
    And Checking api server running with "cloudflare"

  Scenario: Checking is searchingApi language true
    When Perform get operation for SEARCH with "çanta" keyword
    And Checking response language matches with "tr-TR" countrycode
