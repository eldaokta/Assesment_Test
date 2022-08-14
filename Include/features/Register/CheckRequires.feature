@CheckRequires
Feature: Check Require Fields

  @tag1
  Scenario: Check the required fields by not filling any data
    Given I navigate to Alami
    When I click Daftar disini
    And I click Pemberi Dana
    And I click Lanjutkan button
  	And I verify label Bagian ini harus diisi
