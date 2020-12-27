@crm
Feature: CRM Project

@crm_1
Scenario: Counting Dashlets on Home Page
    Given User is on CRM Login Page
    When User logs in to CRM with username "admin" and password "pa$$w0rd"
    Then Count the Dashlets
    And Print the title of each dashlet
    And Close the browser
	
@crm_2
Scenario Outline: Add multiple lead accounts
		Given User is on CRM Login Page
    When User logs in to CRM with username "admin" and password "pa$$w0rd"
    Then Navigate to Create Lead Page under Sales Leads
    And Add Lead Information as follows
    |	First Name	|	<First Name>	|
    |	Last Name		|	<Last Name>		|
    |	Email				|	<Email>				|
    And Save the Lead
    And Navigate to View Leads Page
    And See the Results
    And Close the browser
Examples:
	|	First Name	|	Last Name	|	Email						|
	|	FNTest1			|	LNTest1		|	test1@mail.com	|
	|	FNTest2			|	LNTest2		|	test2@mail.com	|
	|	FNTest3			|	LNTest3		|	test3@mail.com	|

@crm_3
Scenario Outline:  Schedule a meeting and invite at least 3 employees
		Given User is on CRM Login Page
    When User logs in to CRM with username "<Username>" and password "<Password>"
    Then Navigate to Schedule Meeting Page under Activities Meetings
    And Add Meeting Details as follows
		|	Subject			|	Test Meeting				|
		|	Duration		|	1 hour							|
		|	Description	|	Invite 3 attendees	|
		And Add invitees "<Attendee1>","<Attendee2>","<Attendee3>" by searching
    And Save the Meeting
    And Navigate to View Meetings Page
    And Confirm the Meeting is Created with duartion "1h 0m"
    And Close the browser
Examples:
	|	Username	|	Password	|	Attendee1		|	Attendee2	|	Attendee3	|
	|	admin			|	pa$$w0rd	|	test1 Lead1	|	DBDB			|	ZZE				|
    
@crm_4
Scenario Outline:  Adding Products
		Given User is on CRM Login Page
    When User logs in to CRM with username "admin" and password "pa$$w0rd"
    Then Navigate to Create Product Page under All Products
    And Enter Product details as follows
    | Product Name 	|	<Product Name>	|
    | Price					|	<Price>					|
		| Description		|	<Description>		|
    And Save the Product
    And Go to View Products Page
    And See all the Products listed on the Page
    And Close the browser    
Examples:
	|	Product Name	|	Price	|	Description					|
	|	Example				|	200		|	Testing Add Product	|