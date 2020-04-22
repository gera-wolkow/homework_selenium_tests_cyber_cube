Feature: View Vacancies List
  As a visitor
  I want to open vacancies list page
  In order to interact with page

  Background: Visitor navigates to vacancies list page
    Given Visitor is on the "Job Vacancies | CyberCube" page on URL "https://www.cybcube.com/careers/vacancies/"

    Scenario Outline:
      Then Visitor should see "<menuList>" buttons
      Examples:
      |menuList|
      |Products & Solutions, About, Resources|

    Scenario:
      Then Visitor should see "Request More Information" navigate button

    Scenario:
      Then Visitor should see Search button

    Scenario:
      Then Visitor should see "Job Vacancies" text topic

    Scenario Outline:
      Then Visitor should see "<listOfSections>" section
      Examples:
      |listOfSections|
      |Analytics, Client Services, Sales & Business Development, Engineering, Operations, Executive Leadership|

    Scenario Outline:
      Then Every element in "<section>" should have "<attribute>" team attribute
      Examples:
      |section|attribute|
      |Analytics|Analytics|
      |Client Services|Client Services|
      |Sales & Business Development|Sales & Business Development|
      |Engineering|Engineering|
      |Operations|Operations|
      |Executive Leadership|Executive Leadership|
