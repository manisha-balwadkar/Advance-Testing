Feature: To Test MakeMyTrip application
  As a user I should able to login into makemytrip with valid invalid details

@InvalidScenario
Scenario: I register with invalid credential
Given Open Chrome Browser and enter url of appln
When enter mobilenumber with invalid value
Then Register and login
    
    
@ValidScenario    
Scenario: I register and login with valid credential
Given Open Chrome Browser and enter url of appln
When enter mobilenumber with valid value
Then Register and login  

@SearchFlight
Scenario: I search for flight
Given Open Chrome Browser and enter search url of appln
When enter data for flight search
Then search  