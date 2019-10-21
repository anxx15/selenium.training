package gluecode;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.ReadExcel;

public class StepDefs {
	public static WebDriver driver;
	public static Map<String, String> dataMap = null;
	
	@After
	public void afterScenario(Scenario scenario) {
//		scenario.write(dataMap.get("URL"));
		driver.close();
	}
	
	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
	}

	
	@When("^I enter username and password thru list:$")
	public void i_enter_username_and_password_thru_list(DataTable credentials) throws Throwable {
		List<List<String>> data = credentials.raw();
		data.get(0).get(0);
		data.get(0).get(1);
		System.out.println("User Name::-->" + data.get(0).get(0));
		System.out.println("Password::-->" + data.get(0).get(1));
	}

	@Then("^I enter username and password thru map:$")
	public void i_enter_username_and_password_thru_map(Map<String, String> credentials) throws Throwable {
		System.out.println("User Name::-->" + credentials.get("username"));
		System.out.println("Password::-->" + credentials.get("password"));
	}
	
	@Given("^some other precondition \"([^\"]*)\"$")
	public void some_other_precondition(String TCID) throws Throwable {
		dataMap = ReadExcel.getExcelData("./src/test/resources/data/DataProvider.xlsx", "TestData", TCID);
		System.out.println("Excel data:" + dataMap.get("URL"));
	}

	@When("^I complete action$")
	public void i_complete_action() throws Throwable {
	    
	}

	@When("^some other action$")
	public void some_other_action() throws Throwable {
	   
	}

	@When("^yet another action$")
	public void yet_another_action() throws Throwable {
	    
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {
	   
	}

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
	  
	}


}
