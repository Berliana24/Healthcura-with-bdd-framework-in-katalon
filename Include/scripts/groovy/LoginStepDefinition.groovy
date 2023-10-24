import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginStepDefinition {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User open Healthcura web with link https://katalon-demo-cura.herokuapp.com/")
	def User_open_Healthcura_web() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl("https://katalon-demo-cura.herokuapp.com/")
	}

	@When("User click button Make Appointment")
	def User_click_button_Make_Appointment() {
		WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Make Appointment'))
		
	}

	@Then("User will be redirect to Login Page")
	def User_will_be_redirect_to_Login_Page() {
		WebUI.verifyElementPresent(findTestObject("Object Repository/Page_CURA Healthcare Service/h2_Login"), 0)
	}
	
	@When("User input (.*) and (.*)")
	def User_input_username_and_password(String username, String password){
		WebUI.setText(findTestObject("Object Repository/Page_CURA Healthcare Service/input_Username_username"), username)
		WebUI.setText(findTestObject("Object Repository/Page_CURA Healthcare Service/input_Password_password"), password)
	}
	
	@And("User click button Login")
	def User_click_button_Login(){
		WebUI.click(findTestObject("Object Repository/Page_CURA Healthcare Service/button_Login"))
	}
	
	@Then("User will be redirect to page Make Appointment")
	def User_will_be_redirect_to_page_Make_Appointment(){
		WebUI.verifyElementPresent(findTestObject("Object Repository/Page_CURA Healthcare Service/h2_Make Appointment"), 0)
	}
	
	@Then("Invalid username and password message will be display")
	def Invalid_username_and_password_message_will_be_display(){
		WebUI.verifyElementPresent(findTestObject("Object Repository/Page_CURA Healthcare Service/p_Login failed Please ensure the username and password are valid"), 0)
		WebUI.closeBrowser()
	}
}