@RegistrasiStepTwo
Feature: Registrasi Step Two
  

  @tag1
  Scenario: Check Registrasi until step two
    Given I navigate to Alami
    When I click Daftar disini
    And I click Pemberi Dana
    And I input nama lengkap
    And I input email
    And I input no hp
    And I input password
    And I select individual
    And I click Lanjutkan button
    And I verify Kebijakan Privasi & Ketentuan Pengguna
    And I scroll kebijakan dan privasi
    And I click Saya sudah membaca
    And I click Saya tertarik
    And I click Lanjutkan Step Two button
    And I verify Terima Kasih!
    
 
    

    