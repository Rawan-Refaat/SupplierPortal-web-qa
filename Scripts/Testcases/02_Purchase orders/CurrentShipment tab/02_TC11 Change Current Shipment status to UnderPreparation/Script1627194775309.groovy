import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

WebUI.callTestCase(findTestCase('Testcases/02_Purchase orders/CurrentShipment tab/02_TC07 View current shipment details'), 
    [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('POs/Status/ComfirmStatusBtn'))
WebUI.click(findTestObject('POs/Status/OrderStatusList'))

WebUI.click(findTestObject('POs/Status/UnderPreparationStatusBtn'))

GlobalVariable.Status = WebUI.getText(findTestObject('POs/Status/UnderPreparationStatus'))
//Assertion on confirmation Msg
WebUI.callTestCase(findTestCase('Assertion/AssertOnChangeShipmentConfirmationMsg'), [:], FailureHandling.STOP_ON_FAILURE)

//Confirm
WebUI.click(findTestObject('POs/Buttons/confirmBtn'))

//Assertion on Rejection Order Status Notification
WebUI.callTestCase(findTestCase('Assertion/AssertOnCurrentShipmentStatusNotification'), null, FailureHandling.STOP_ON_FAILURE)