import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.testng.Assert as Assert
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//'Define Custom Path where file needs to be downloaded'
String downloadPath = 'C:/Users/user/Downloads'

//'Verifying the file is download in the Set Path'
Assert.assertTrue(isFileDownloaded(downloadPath, GlobalVariable.SheetName), 'Failed to download Expected document')

boolean isFileDownloaded(String downloadPath, String fileName) {
    boolean flag = false

    File dir = new File(downloadPath)

    File[] dir_contents = dir.listFiles()

    System.out.println('Total Files Available in the folder are :  ' + dir_contents.length)

    for (int i = 0; i < dir_contents.length; i++) {
        //println('File Name at 0 is : ' + dir_contents[i].getName())

        if (dir_contents[i].getName().equals(fileName)) {
            return flag = true
			System.out.println('Successfully')
        }
    }
    
    return flag
}