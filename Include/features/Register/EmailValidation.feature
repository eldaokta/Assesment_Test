@CheckingEmailValidation
Feature: Checking Email Validation

  @tag1
  Scenario: Enter invalid emails & existing email and then click signup
    Given I navigate to Alami
    When I click Daftar disini
    And I click Pemberi Dana
    And I input email without @
    And I click Lanjutkan button
    And I verify label silakan isi email dengan format yang benar
    And I input email without .
    And I input nama lengkap
    And I input no hp
    And I input password
    And I select individual
    And I click Lanjutkan button
    And I verify email popup
    And I click Ok
    And I input existing email
    And I click Lanjutkan button
    And I verify label Email Sudah digunakan
    
    
 
    

    