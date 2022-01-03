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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import java.text.SimpleDateFormat

SimpleDateFormat sdf = new SimpleDateFormat('YYYY-MM-dd');
Calendar c = Calendar.getInstance();
c.setTime(new Date()); //Use today’s date
//c.add(Calendar.DATE, 2); //Adds # of days
String currentDate = sdf.format(c.getTime());

GlobalVariable.SheetName=('invoices-sary'+currentDate+'.xlsx')
System.out.println(GlobalVariable.SheetName);

WebUI.callTestCase(findTestCase('Testcases/01_Login/01_TC01_Test valid credentials'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('SideMenu/POsTab'))

WebUI.verifyElementNotClickable(findTestObject('POs/Buttons/DownloadCSVBtn'))

WebUI.click(findTestObject('POs/FilterOptions/AllFilter'))

WebUI.click(findTestObject('POs/FilterOptions/TodayFilter'))

def ElementChecked(TestObject testObject) {
	WebDriver driver = DriverFactory.getWebDriver()
	//WebElement element = WebUI.findWebElement(testObject, 5)
	WebElement msg = WebUI.findWebElement('POs/Msgs/NoOrdersMsg')
	
if (msg.displayed)
{
	System.out.println('The order not found!')
}
else 
{
	WebUI.verifyElementClickable(findTestObject('POs/Buttons/DownloadCSVBtn'))
	WebUI.click(findTestObject('POs/Buttons/DownloadCSVBtn'))
	WebUI.callTestCase(findTestCase('Test Cases/Assertion/AssertOnFileDownloaded'), [:], FailureHandling.STOP_ON_FAILURE)
}
}
