@CheckingPasswordValidation
Feature: Checking Password Validation

  @tag1
  Scenario: Check Password Validation
    Given I navigate to Alami
    When I click Daftar disini
    And I click Pemberi Dana
    And I input less password
    And I click Lanjutkan button
    And I verify Minimum 8 karakter
    