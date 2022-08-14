@Login
Feature: Login Feature

  As a user, I want to login to Cura System
  so that I can make an appointment.

  @Valid
  Scenario Outline: Login with a valid credential
    Given I navigate to Alami
    When I enter email <email> and password <password>
    And I click Login
    Then I should be able to login successfully

    Examples: 
      | email 										| password    |
      | eldaoktaviani5@gmail.com 	| TestTest123.|

  @InValid
  Scenario Outline: Login with an invalid credential
    Given I navigate to Alami
    When I enter an invalid email <email> and password <password>
    And I click Login
    Then I should NOT be able to login successfully

    Examples: 
      | email 					| password |
      | elda@gmail.com  | test		 |