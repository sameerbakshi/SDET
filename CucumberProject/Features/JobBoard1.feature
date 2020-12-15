@job_board_1
Feature: Create a new job board user

Scenario Outline: Creating a new user and generating html report
    Given User is on Job Board Login Page
    When User logs in to Job Board system with "<Username>" and "<Password>"
    Then Choose Users option from menu
    And Navigate to Add New User page
    And Fill the details
    And Add new Job Board user
    And Verify new Job Board user is created
    And Close the browser
    
Examples:
	|	Username	|	Password	|
	|	root			|	pa$$w0rd	|