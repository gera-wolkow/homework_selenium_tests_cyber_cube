Feature: View Vacancies List
  As a visitor
  I want to open vacancies list page
  In order to interact with page

  Background: Visitor navigates to vacancies list page
    Given Visitor is on the "Job Vacancies | CyberCube" page on URL "https://www.cybcube.com/careers/vacancies/"
    
    Scenario: 
      Then Visitor should see Logo
      
    Scenario: 
      When Visitor clicks on Logo
      Then Visitor navigates to URL "https://www.cybcube.com/"

    Scenario Outline:
      Then Visitor should see "<menuList>" buttons
      Examples:
      |menuList|
      |Products & Solutions, About, Resources|

    Scenario:
      Then Visitor should see "Request More Information" navigate button

    Scenario:
      When Visitor clicks on "Request More Information" navigate button
      Then Visitor navigates to URL "https://www.cybcube.com/contact/"

    Scenario:
      Then Visitor should see Search button

    Scenario:
      When Visitor clicks on Search button
      Then Search form appears

    Scenario:
      Then Visitor should see Trends Flag
      And Visitor should see Trends Title with "Understanding Ransomware Trends" text
      And Visitor should see Trends Download Button with "Download Report" text
      
    Scenario: 
      When Visitor clicks on Trends Download Button
      Then Visitor navigates to URL "https://insights.cybcube.com/en/understanding-ransomware-trends" in new tab

    Scenario:
      Then Visitor should see "Job Vacancies" text topic

    Scenario:
      Then Visitor should see "Location" filter title and "Team" filter title

    Scenario:
      Then Visitor should see Location drop-down and Team drop-down

    Scenario Outline:
      When Visitor select "<option>" in Location drop-down
      Then Visitor should see vacancies list with "<option>" locations or text "There are no jobs matching this criteria, please try resetting the filters above."
      Examples:
      |option|
      |San Francisco, CA|
      |London|
      |New York, NY|
      |United States|
      |Tallinn|

    Scenario Outline:
      When Visitor select "<option>" in Team drop-down
      Then Visitor should see vacancies list with "<option>" teams or text "There are no jobs matching this criteria, please try resetting the filters above."
      Examples:
      |option|
      |Analytics|
      |Client Services|
      |Sales & Business Development|
      |Engineering|
      |Operations|
      |Executive Leadership|

    Scenario Outline:
      Then Visitor should see "<listOfSections>" section
      Examples:
      |listOfSections|
      |Analytics, Client Services, Sales & Business Development, Engineering, Operations, Executive Leadership|

