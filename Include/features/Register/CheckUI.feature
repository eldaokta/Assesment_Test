@CheckUI
Feature: Check UI page

  @tag1
  Scenario: Daftar Pemberi Dana
    Given I navigate to Alami
    When I click Daftar disini
    Then I click Pemberi Dana

  @tag2
  Scenario: Check all buttons, radio button, dropdown by clicking on all buttons and see if they are working or not.
    Given I navigate to Alami Register Pemberi Dana
    When I verify label Individual
    And I verify label Institusi
    And I verify dropdown register Referral
    And I verify Lanjutkan button
    Then I verify text masuk
