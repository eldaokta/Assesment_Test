import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class NewTestListener {
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	//@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)
		println testSuiteContext.getTestSuiteId()
	}

	//@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		WebUI.callTestCase(findTestCase('Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)
		println testCaseContext.getTestCaseId()
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	//@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
	}

	//@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		/*
		 * statusID is a parameter TestRail Result 1 for pass, 5 for failed
		 * tc_final is an array list for all test run id
		 * tc_ids will get name of test case that contains Test Run ID TestRail and
		 * next process will extract that ID to be passed into TestRail POST_TestRail
		 */	

		//WebUI.callTestCase(findTestCase('Logout'), [:], FailureHandling.CONTINUE_ON_FAILURE)
		ArrayList<String> tc_ids = testCaseContext.getTestCaseId().split("/")
		String prep = tc_ids[tc_ids.size() - 1]
		ArrayList<String> preps = prep.split(" ")
		String prepis = preps.pop()
		String replaceAllChars = preps.toString().replace(",", " ").replace("[", "").replace("]", "").replace("T", "")
		ArrayList<String> tc_final = replaceAllChars.split(" ")
		def tc_result = testCaseContext.getTestCaseStatus()
		def statusID
		for (def n : (0 .. tc_final.size() - 1)) {
			if( tc_result == 'PASSED'){
				println tc_final[n]
				statusID='1'
				def responseWS = WS.sendRequest(findTestObject('POST_TestRail', [('urlTestRail'): GlobalVariable.urlTestRail, ('idTC'): tc_final[n].replace("T", ""), ('stsID'): statusID, ('comment'): testCaseContext.getTestCaseId() ]))
				println("*************-------"+responseWS.getStatusCode())
				println("*************-------"+GlobalVariable.urlTestRail)
				if (responseWS.getStatusCode() == 200){
					KeywordUtil.markPassed("Test Case is PASSED will set the result in TestRail as PASSED")
				}else{
					KeywordUtil.markFailed("Test Case Result is Not Generated " + responseWS.getResponseText() + " Caused By :"+ responseWS.getStatusCode())
				}
			}
			else{
				statusID='5'
				def responseWS = WS.sendRequest(findTestObject('POST_TestRail', [('urlTestRail'): GlobalVariable.urlTestRail, ('idTC'): tc_final[n].replace("T", ""), ('stsID'): statusID, ('comment'): testCaseContext.getTestCaseId()]))
				if (responseWS.getStatusCode() == 200){
					KeywordUtil.markPassed("Test Case is FAILED will set the result in TestRail as FAILED")
				}else{
					KeywordUtil.markFailed("Test Case Result is Not Generated " + responseWS.getResponseText() + " Caused By :"+ responseWS.getStatusCode())
				}
			}
		}
	}
}