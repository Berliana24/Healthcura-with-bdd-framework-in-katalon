#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@login01
Feature: Login

  @login0101
  Scenario Outline: Login with valid cridential
    Given User open Healthcura web with link https://katalon-demo-cura.herokuapp.com/
    When User click button Make Appointment
    Then User will be redirect to Login Page 
    
    When User input <username> and <password>
    And User click button Login
    Then User will be redirect to page Make Appointment

    Examples: 
      | username  | password | 
      | John Doe | ThisIsNotAPassword |
      
   
  @login0102
  Scenario Outline: Login with invalid cridential
    Given User open Healthcura web with link https://katalon-demo-cura.herokuapp.com/
    When User click button Make Appointment
    Then User will be redirect to Login Page 
    
    When User input <username> and <password>
    And User click button Login
    Then Invalid username and password message will be display

    Examples: 
      | username  | password | 
      | John Doe | Password |
      | John Doee | ThisIsNotAPassword |

  @login0103
  Scenario Outline: Login with empty username and password
    Given User open Healthcura web with link https://katalon-demo-cura.herokuapp.com/
    When User click button Make Appointment
    Then User will be redirect to Login Page 
    
    And User click button Login
    Then Invalid username and password message will be display

      