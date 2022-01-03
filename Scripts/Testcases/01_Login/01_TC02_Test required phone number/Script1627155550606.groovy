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

//Skip the phone number and click next
WebUI.focus(findTestObject('LoginP1/phone-number'))

WebUI.click(findTestObject('LoginP1/NextBtn'))

//Verify Nex button is NOT clickable if the Phone number is empty and required-error visible

if (WebUI.verifyElementNotClickable(findTestObject('LoginP1/NextBtn'))&& WebUI.verifyElementVisible(findTestObject('LoginP1/required-error'))
)
{
	
	log.logInfo("Passed, Next Button not clickable and required-error visible")
}
else {
	log.logInfo("Failed")
	
}

WebUI.closeBrowser()