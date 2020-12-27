@hrm
Feature: HRM Project

@hrm_1
Scenario: Creating a job vacancy for DevOps Engineer
    Given User is on HRM Login Page
    When User logs in to HRM with "orange" and "orangepassword123"
    Then Navigate to Recruitment page
    And Navigate to Vacancies page
    And Open Add Job Vacancy Form
    And Enter details as follows
    | Job Title 			|	DevOps Engineer	|
    | Vacancy Name		|	DevOps Vacancy	|
		| Hiring Manager	|	Hello Tester		|
    And Save the Vacancy
    And Verify "DevOps Resource" Vacancy was created
    And Close the browser
	
@hrm_2
Scenario: Add information about a candidate for recruitment
    Given User is on HRM Login Page
    When User logs in to HRM with "orange" and "orangepassword123"
    Then Navigate to Recruitment page
    And Add Candidate Information
    And Upload a Resume
    And Save the Information
    And Navigate Back to Recruitments page
    And Confirm Candidate Entry
    And Close the browser

@hrm_3
Scenario Outline:  Add multiple employees
    Given User is on HRM Login Page
    When User logs in to HRM with "orange" and "orangepassword123"
    Then Navigate to PIM page
    And Add New Employee
    And Check Login Details
    And Enter Employees Details as follows
		|	First Name	|	<First Name>	|
		|	Last Name		|	<Last Name>		|
		|	User Name		|	<User Name>		|
		And Save the New Employee
    And Verify "<First Name>" "<Last Name>" employee has been created
    And Close the browser
Examples:
	|	First Name	|	Last Name	|	User Name	|
	|	Test				|	SDET1			|	TestSDET1	|
	|	Test				|	SDET2			|	TestSDET2	|
	|	Test				|	SDET3			|	TestSDET3	|
    
@hrm_4
Scenario Outline: Creating multiple job vacancies
    Given User is on HRM Login Page
    When User logs in to HRM with "<Username>" and "<Password>"
    Then Navigate to Recruitment page
    And Navigate to Vacancies page
    And Open Add Job Vacancy Form
    And Enter details as follows
    | Job Title 			|	<Job Title>			|
    | Vacancy Name		|	<Vacancy Name>	|
		| Hiring Manager	|	<Manager>				|
    And Save the Vacancy
    And Verify "<Vacancy Name>" Vacancy was created
    And Close the browser    
Examples:
	|	Username	|	Password					|	Job Title									|	Vacancy Name				|	Manager				|
	|	orange		|	orangepassword123	|	Android Developer					|	Android Vacancy			|	Hello Tester	|
	|	orange		|	orangepassword123	|	Automation Test Engineer	|	Automation Vacancy	|	Hello Tester	|
	|	orange		|	orangepassword123	|	Java Developer						|	Java Vacancy				|	Hello Tester	|
	|	orange		|	orangepassword123	|	Rust Engineer							|	Rust Vacancy				|	Hello Tester	|