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



class MakeAppointmentStepDefinition {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@When ("User select (.*), check (.*), choose (.*), input (.*), and input (.*)")
	def User_fill_the_form(String facility, String hospitalReadmission, String program, String visitDate, String comment){
		WebUI.selectOptionByIndex(findTestObject("Object Repository/Page_CURA Healthcare Service/select_facility"), facility)
		
		if(hospitalReadmission == 'yes') {
			WebUI.check(findTestObject("Object Repository/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospit_63901f"))
		}else {
			WebUI.uncheck(findTestObject("Object Repository/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospit_63901f"))
		}
		
		if(program == 'Medicare') {
			WebUI.click(findTestObject("Object Repository/Page_CURA Healthcare Service/input_Medicare_programs"))
		} else if(program == 'Medicaid') {
			WebUI.click(findTestObject("Object Repository/Page_CURA Healthcare Service/input_Medicaid_programs"))
		} else if (program == 'None') {
			WebUI.click(findTestObject("Object Repository/Page_CURA Healthcare Service/input_None_programs"))
		}
		
		WebUI.setText(findTestObject("Object Repository/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date"), visitDate)
		WebUI.setText(findTestObject("Object Repository/Page_CURA Healthcare Service/textarea_Comment_comment"), comment)
		
	}
	
	@And("User click button Book Appointment")
	def User_click_button_Book_Appointment() {
		WebUI.click(findTestObject("Object Repository/Page_CURA Healthcare Service/button_Book Appointment"))
	}

	@Then("User will be redirect to page Appointment Confirmation")
	def User_will_be_redirect_to_page_Appointment_Confirmation() {
		WebUI.verifyElementPresent(findTestObject("Object Repository/Page_CURA Healthcare Service/h2_Appointment Confirmation"), 0)
	}

	@And("User can see appointment information")
	def User_can_see_appointment_information () {
		WebUI.verifyElementPresent(findTestObject("Object Repository/Page_CURA Healthcare Service/div_Appointment Confirmation"), 0)
		WebUI.closeBrowser()
	}
}