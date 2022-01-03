import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.logging.KeywordLogger

KeywordLogger log = new KeywordLogger()

WebUI.callTestCase(findTestCase('General/OpenBrowser'), [:], FailureHandling.STOP_ON_FAILURE)


//Verify starts-with-error is visible if the phone number is not started with 05
WebUI.verifyElementVisible(findTestObject('LoginP1/length-error'))

WebUI.setText(findTestObject('LoginP1/phone-number'), '010620619')

WebUI.click(findTestObject('LoginP1/NextBtn'))

//Verify starts-with-error is visible if the phone number is not started with 05
WebUI.verifyElementVisible(findTestObject('LoginP1/starts-with-error'))
WebUI.verifyElementVisible(findTestObject('LoginP1/length-error'))

WebUI.closeBrowser()
