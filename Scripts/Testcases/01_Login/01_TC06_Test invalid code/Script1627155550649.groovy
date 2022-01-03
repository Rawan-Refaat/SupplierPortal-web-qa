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

WebUI.callTestCase(findTestCase('General/OpenBrowser'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('LoginP1/phone-number'), '0509876543')

WebUI.click(findTestObject('LoginP1/NextBtn'))

WebUI.verifyElementVisible(findTestObject('LoginP1/NumberAccepted'))

WebUI.setText(findTestObject('LoginP2/Code-1'), '1')
WebUI.setText(findTestObject('LoginP2/Code-2'), '1')
WebUI.setText(findTestObject('LoginP2/Code-3'), '1')
WebUI.setText(findTestObject('LoginP2/Code-4'), '1')
WebUI.setText(findTestObject('LoginP2/Code-5'), '1')

WebUI.verifyElementVisible(findTestObject('LoginP2/Code-not-valid'))

WebUI.closeBrowser()

