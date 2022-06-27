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

'Open browser'
WebUI.openBrowser('')

'Navigate to main page'
WebUI.navigateToUrl(GlobalVariable.demoURL)
println("password:" + GlobalVariable.pass)
'Click on book appointement'
WebUI.click(findTestObject('Object Repository/Frontend/login page/a_Make Appointment'))

'Introduce username'
WebUI.setText(findTestObject('Object Repository/Frontend/login page/input_Username_username'), GlobalVariable.user)

'Introduce passsword'
WebUI.setEncryptedText(findTestObject('Object Repository/Frontend/login page/input_Password_password'), 
    GlobalVariable.pass)
println("password:" + GlobalVariable.pass)

'Click on login'
WebUI.click(findTestObject('Object Repository/Frontend/login page/button_Login'))
WebUI.delay(1)

'Verify that we login correctly'
WebUI.verifyTextNotPresent('Login failed! Please ensure the username and password are valid.', false)
