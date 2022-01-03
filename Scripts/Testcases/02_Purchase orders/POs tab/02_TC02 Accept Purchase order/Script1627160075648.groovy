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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.configuration.RunConfiguration

//view the PO order details
//WebUI.callTestCase(findTestCase('Testcases/02_Purchase orders/POs tab/02_TC01 View PO details'), [:], FailureHandling.STOP_ON_FAILURE)

//Click on Accept btn
WebUI.click(findTestObject('POs/Buttons/OrderAcceptBtn'))


//Assertion on confirmation Msg
WebUI.callTestCase(findTestCase('Test Cases/Assertion/AssertOnAcceptConfirmationMsg'), null, FailureHandling.STOP_ON_FAILURE)

//Accepted Confirm
WebUI.click(findTestObject('POs/Buttons/confirmBtn'))

//Assertion on Accepted Order Status Notification
WebUI.verifyElementVisible(findTestObject('POs/ConfirmOrderNotification'))

WebUI.verifyElementText(findTestObject('POs/ConfirmOrderNotification'), ExpNotifAr, FailureHandling.STOP_ON_FAILURE)

