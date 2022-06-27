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

import cucumber.api.java.en.Then
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

	'Execute endpoint  Create user'
	def response = WS.sendRequestAndVerify(findTestObject("Object Repository/BDD/POST a new user",
			["age": age, "username": username, "password": password, "gender": gender]))
	
	
	'Verify if the response from "REST_Status Codes/POST_200" object returns the 200 status code'
	WS.verifyResponseStatusCode(response, 200)

	'Extract filed value id and store it in global variable globalId'
	JsonSlurper jsonSlurper = new JsonSlurper()
	def jsonResponse = jsonSlurper.parseText(response.getResponseText())
	def name = jsonResponse.username;
	GlobalVariable.globalId = jsonResponse.id;
	println("response1:" + jsonResponse + " [id1:" + GlobalVariable.globalId + " ,username1:" + username +"]")
	
	'Execute endpoint  Get user by ID'
	def response2 = WS.sendRequestAndVerify(findTestObject("Object Repository/BDD/GET user by id",
			["age": age, "username": username, "password": password, "gender": gender]))

	'Verify if the response from "REST_Status Codes/POST_200" object returns the 200 status code'
	WS.verifyResponseStatusCode(response2, 200)
	
	
	JsonSlurper jsonSlurper2 = new JsonSlurper()
	def jsonResponse2 = jsonSlurper2.parseText(response2.getResponseText())
	String id = jsonResponse2.id;
	String name2 = jsonResponse2.username;
	println("response2:" + jsonResponse2 + " [id2:" + id + " ,username2:" + username +"]") 

	
	