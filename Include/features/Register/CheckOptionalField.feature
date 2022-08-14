@CheckOptionalField
Feature: Registrasi Pemberi Dana feature
  As a Funder I want to be able to register at Alami Syaria web
  So that I can login

  @tag1
  Scenario: Check all optional fields by entering the data
    Given I navigate to Alami
    When I click Daftar disini
    And I click Pemberi Dana
    And I input nama lengkap
    And I input email
    And I input no hp
    And I input password
    And I select individual
    And I input referral
    And I input tahu Alami dari Facebook
    Then I click Lanjutkan button

    