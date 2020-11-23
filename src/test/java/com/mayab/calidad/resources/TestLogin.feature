Feature: Test user login

  Scenario Outline: User logins succesfully with credentials
    Given Browser is open
    And user is in login page
    When user enters <username> and <password>
    When user clicks login button
    Then website shows main page
  
  Examples:
	|username||password|
	|Miguel||12345|
	|Juan||12345|
    

