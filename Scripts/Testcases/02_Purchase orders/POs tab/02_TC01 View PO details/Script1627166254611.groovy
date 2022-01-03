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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger


//Removed Code
//Call Login TC 
//WebUI.callTestCase(findTestCase('Testcases/01_Login/01_TC01_Test valid credentials'), [:], FailureHandling.STOP_ON_FAILURE)

//Navigate to PO Page from side menu 
//WebUI.click(findTestObject('SideMenu/POsTab'))
//WebUI.callTestCase(findTestCase('General/SideMenu/OpenPages/Open Purchase Page'), [:], FailureHandling.STOP_ON_FAILURE)

//Call Search TC and get the result of search
//(WebUI.callTestCase(findTestCase('General/Purchase Order/SearchOnPOs'), [:], FailureHandling.STOP_ON_FAILURE))

System.out.println(GlobalVariable.Result)

if (GlobalVariable.Result == true)
	{
		WebUI.click(findTestObject('POs/POSearchResult'))
		//Assert On URL with Order ID
		String URL = (WebUI.getUrl()).toString()
		assert URL.contains(orderID);
	}
else
{
	System.out.println("Order with ID "+orderID+" Not Found!")
}
	

