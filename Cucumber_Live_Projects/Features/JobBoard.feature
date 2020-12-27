@job_board
Feature: Job Board Project

@job_board_1
Scenario Outline: Creating a new job board user
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
	
@job_board_2
Scenario: Searching for jobs and applying to them using XPath
    Given User is on Job Board Home Page
    When User navigates to Jobs page
    Then Enter Keywords in the input field
    And Search for Jobs with the Keywords
    And Filter Job Type to show only Full Time jobs
    And Click on a Job Listing
    And Print the Job Listing Title
    And Click on Apply for job button
    And Close the browser
    
@job_board_3
Scenario:  Post a job using details passed from the Feature file
    Given User is on Job Board Home Page
    When User navigates to Post a Job page
    Then Fill in the following Job Information details
		|	Email				|	example_test@sdet.com												|
		|	Job Title		|	SDET Full Time													|
		|	Job Type		|	Full Time																|
		|	Description	|	Test																		|
		|	URL					|	https://training-support.my.webex.com/	|
		|	Company			|	IBM																			|
    And Submit the Job
    And Go To Jobs Page
    And Search for the Submitted Job "SDET Full Time"
    And Confirm the "SDET Full Time" Job is present
    And Close the browser
    
@job_board_4
Scenario Outline:  Post a job using details passed from the Examples Table
    Given User is on Job Board Home Page
    When User navigates to Post a Job page
    Then Fill in the following Job Information details
		|	Email				|	<Email>				|
		|	Job Title		|	<Job Title>		|
		|	Job Type		|	<Job Type>		|
		|	Description	|	<Description>	|
		|	URL					|	<URL>					|
		|	Company			|	<Company>			|
    And Submit the Job
    And Go To Jobs Page
    And Search for the Submitted Job "<Job Title>"
    And Confirm the "<Job Title>" Job is present
    And Close the browser
    
Examples:
|	Email									|	Job Title				|	Job Type		|	Description	|	Company	|	URL																			|
|	test_example@sdet.com	|	SDET Full Time	|	Full Time		|	Test				|	IBM			|	https://training-support.my.webex.com/	|