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
@MakeAppointment02
Feature: Make Appointment

  @MakeAppointment0101
  Scenario Outline: Make Appointment with valid input
    Given User open Healthcura web with link https://katalon-demo-cura.herokuapp.com/
    When User click button Make Appointment 
    Then User will be redirect to Login Page 
    
    When User input <username> and <password>
    And User click button Login
    
    When User select <facility>, check <hospitalReadmission>, choose <program>, input <visitDate>, and input <comment>  
    And User click button Book Appointment
    Then User will be redirect to page Appointment Confirmation
    And User can see appointment information  

    Examples: 
      | username  | password | facility | hospitalReadmission | program | visitDate | comment | 
      | John Doe | ThisIsNotAPassword | 2 | yes | Medicaid | 22/09/2023 | Check up |
      | John Doe | ThisIsNotAPassword | 1 | no | Medicare | 12/09/2023 | Check up routine |
      | John Doe | ThisIsNotAPassword | 0 | yes | None | 19/04/2023 | Check up routine |