@job_board_2
Feature: Searching for jobs using XPath

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