package stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.Keys

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class StepDefinition {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I navigate to Alami")
	def navigateToAlami() {
		WebUI.openBrowser("https://dev.p2p.alamisharia.co.id/")
		//WebUI.waitForPageLoad(30)
	}

	// Given blabla open url "url"
	@Given("I open browser")
	def openWeb(){
		WebUI.openBrowser('')
		WebUI.takeScreenshot()
	}

	@Given("I navigate to Alami Register Pemberi Dana")
	def navigateRegister() {
		WebUI.navigateToUrl("https://dev.p2p.alamisharia.co.id/register/funder/")
		WebUI.takeScreenshot()
	}
	
	@Given("I navigate to Alami Verifikasi Akun")
	def navigateVerifikasi() {
		WebUI.navigateToUrl("https://dev.p2p.alamisharia.co.id/register/funder/success/")
		WebUI.takeScreenshot()
	}

	@When("I click Daftar disini")
	def clickDaftardisini() {
		WebUI.click(findTestObject('Page_Register_Pemberi Dana/a_Daftar disini'))
		WebUI.takeScreenshot();
	}

	@And("I click Pemberi Dana")
	def clickPemberiDana(){
		WebUI.click(findTestObject('Page_Register_Pemberi Dana/img'))
		WebUI.takeScreenshot();
	}

	@And("I verify label Individual")
	def verifyIndividual() {
		WebUI.verifyElementClickable(findTestObject('Page_Register_Pemberi Dana/label_Individual'))
		WebUI.takeScreenshot();
	}

	@And("I verify label Institusi")
	def verifyInstitusi() {
		WebUI.verifyElementClickable(findTestObject('Page_Register_Pemberi Dana/label_Institusi'))
		WebUI.takeScreenshot();
	}

	@And("I verify dropdown register Referral")
	def verifyReferral() {
		WebUI.verifyElementClickable(findTestObject('Page_Test_alami/registerReferal'))
		WebUI.takeScreenshot();
	}

	@When("I verify Lanjutkan button")
	def verifyLanjutkanButton() {
		WebUI.verifyElementClickable(findTestObject('Page_Test_alami/button_Lanjutkan'))
		WebUI.takeScreenshot();
	}

	@And("I verify text masuk")
	def verifyTextMasuk() {
		WebUI.verifyElementClickable(findTestObject('Page_Test_alami/a_masuk'))
		WebUI.takeScreenshot();
	}

	@And("I click Lanjutkan button")
	def clickLanjutkan() {
		WebUI.click(findTestObject('Page_Test_alami/button_Lanjutkan'))
//		WebUI.delay(5)
		WebUI.takeScreenshot();
	}
	
	@And("I click Ok")
	def clickOk() {
		WebUI.click(findTestObject('Page_Test_alami/button_OK'))
		WebUI.takeScreenshot();
	}

	@And("I verify label Bagian ini harus diisi")
	def verifyHarusDiisi() {
		WebUI.verifyTextPresent("Bagian ini harus diisi", true)
		WebUI.takeScreenshot();
	}
	
	@And("I verify label Email Sudah digunakan")
	def verifyExistingEmail() {
		WebUI.verifyTextPresent("Email Sudah digunakan", true)
		WebUI.takeScreenshot();
	}
	
	@And("I verify label silakan isi email dengan format yang benar")
	def verifyEmail() {
		WebUI.verifyTextPresent("silakan isi email dengan format yang benar", true)
		WebUI.takeScreenshot();
	}
	
	@And("I verify email popup")
	def verifyEmailPopup() {
		WebUI.verifyTextPresent("Silahkan isi email yang valid", false)
		WebUI.takeScreenshot();
	}
	
	@And("I verify Minimum 8 karakter")
	def verifyMinChar() {
		WebUI.verifyTextPresent("Minimum 8 karakter", false)
		WebUI.takeScreenshot();
	}
	
	
	@When("I input nama lengkap")
	def inputNamaLengkap() {
		WebUI.setText(findTestObject('Page_Register_Pemberi Dana/input_Nama Lengkap_name'), 'Elda Oktaviani')
		WebUI.takeScreenshot();
	}
	
	@When("I input email")
	def inputEmail() {
		WebUI.setText(findTestObject('Page_Register_Pemberi Dana/input_Email_email'), 'liwoj92177@upshopt.com')
		WebUI.takeScreenshot();
	}
	
	@When("I input email without @")
	def inputInvalidEmail() {
		WebUI.setText(findTestObject('Page_Register_Pemberi Dana/input_Email_email'), 'eldaoktaviani5gmail.com')
		WebUI.takeScreenshot();
	}
	
	@When("I input email without .")
	def inputInvalidEmail2() {
		WebUI.setText(findTestObject('Page_Register_Pemberi Dana/input_Email_email'), 'eldaoktaviani5@gmailcom')
		WebUI.takeScreenshot();
	}
	
	@When("I input existing email")
	def inputExistingEmail() {
		WebUI.setText(findTestObject('Page_Register_Pemberi Dana/input_Email_email'), 'test@gmail.com')
		WebUI.takeScreenshot();
	}
	
	@When("I input no hp")
	def inputNoHp() {
		WebUI.setText(findTestObject('Page_Register_Pemberi Dana/input_No. Handphone_phone'), '089653028626')
		WebUI.takeScreenshot();
	}
	
	@When("I input less password")
	def inputLessPassword() {
		WebUI.setText(findTestObject('Page_Register_Pemberi Dana/input_Password_password'), '12345')
		WebUI.takeScreenshot();
	}
	
	@When("I input password")
	def inputPassword() {
		WebUI.setText(findTestObject('Page_Register_Pemberi Dana/input_Password_password'), 'TestTest123.')
		WebUI.takeScreenshot();
	}
	
	@When("I select individual")
	def selectIndividual() {
		WebUI.check(findTestObject('Page_Register_Pemberi Dana/label_Individual'))
		WebUI.takeScreenshot();
	}
	
	@When("I input referral")
	def inputreferral() {
		WebUI.setText(findTestObject('Page_Register_Pemberi Dana/input_Kode Referral (Opsional)_relamiCodeReferral'), 'A123')
		WebUI.takeScreenshot();
	}
	
	@When("I input tahu Alami dari Facebook")
	def selectTahuAlami() {
		WebUI.selectOptionByLabel(findTestObject('Page_Test_alami/registerReferal'), 'Facebook', true)
	}
	
	@When("I scroll kebijakan dan privasi")
	def scrollElement() {
		WebUI.scrollToElement(findTestObject('Page_Test_alami/h5_KONTAK DAN MEDIA SOSIAL ALAMI'), 7)
	}
	
	@And("I verify Kebijakan Privasi & Ketentuan Pengguna")
	def verifyHeaderKebijakan() {
		WebUI.verifyTextPresent("Kebijakan Privasi & Ketentuan Pengguna", false)
		WebUI.takeScreenshot();
	}

	@When("I click Saya sudah membaca")
	def clickSayaSudahMembaca() {
		WebUI.click(findTestObject('Page_Test_alami/input_Saya sudah membaca dan setuju dengan'))
		WebUI.takeScreenshot();
	}
	
	@When("I click Saya tertarik")
	def clickSayaTertarik() {
		WebUI.click(findTestObject('Page_Test_alami/input_Saya tertarik update info terbaru ALAMI'))
		WebUI.takeScreenshot();
	}
	
	@And("I click Lanjutkan Step Two button")
	def clickLanjutkanStepTwo() {
		WebUI.click(findTestObject('Page_Test_alami/button_Lanjutkan2'))
//		WebUI.delay(5)
		WebUI.takeScreenshot();
	}
	
	@And("I verify Terima Kasih!")
	def verifyTerimaKasih() {
		WebUI.verifyTextPresent("Terima Kasih!", false)
		WebUI.takeScreenshot();
	}
	
	@And("I verify text Alhamdulillah!")
	def verifyAlhamdulillah() {
		WebUI.verifyTextPresent("Alhamdulillah!", false)
		WebUI.takeScreenshot();
	}
	
	@When("I click Masuk Ke Akun Saya")
	def clickMasukAkun() {
		WebUI.click(findTestObject('Page_Daftar Sebagai Pemberi Dana  ALAMI Peer-to-Peer Lending Syariah/a_Masuk Ke Akun Saya'))
		WebUI.takeScreenshot();
	}
	
	@When("I click Login")
	def clickLogin() {
		WebUI.click(findTestObject('Page_Login  ALAMI Peer-to-Peer Lending Syariah/a_Masuk Ke Akun Saya'))
		WebUI.delay(5)
		WebUI.takeScreenshot();
	}
	
	@When("I enter email (.*) and password (.*)")
	def EnterValidEmailPassword(String email, String password) {

		WebUI.setText(findTestObject('Page_Login  ALAMI Peer-to-Peer Lending Syariah/input_Assalamualaikum_username'), email)
		WebUI.setText(findTestObject('Page_Login  ALAMI Peer-to-Peer Lending Syariah/input_Assalamualaikum_password'), password)
	}
	
	@Then("I should be able to login successfully")
	def LoginSuccessfully() {
		WebUI.verifyElementPresent(findTestObject('Page_Alami - Dashboard/h4_Lengkapi Profilmu Untuk Aktivasi Akun dan RDF (Rekening Dana Funder)'), 3)
		WebUI.closeBrowser()
	}
 

	@And("I enter an invalid email (.*) and password (.*)")
	def EnterInvalidEmailPassword(String email, String password) {

		WebUI.setText(findTestObject('Page_Login  ALAMI Peer-to-Peer Lending Syariah/input_Assalamualaikum_username'), email)
		WebUI.setText(findTestObject('Page_Login  ALAMI Peer-to-Peer Lending Syariah/input_Assalamualaikum_password'), password)
	}

	@Then("I should NOT be able to login successfully")
	def LoginUnsuccessfully() {
		WebUI.verifyTextPresent('Email atau kata sandi kamu salah', false)
		WebUI.closeBrowser()
	}
	
}