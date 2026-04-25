package stepDefinations;

import org.openqa.selenium.WebDriver;

import Context.TestContext;
import Managers.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExtentTestManager;

public class LoginPageStep {
	TestContext tc;
	PageObjectManager objM;
	public LoginPageStep(TestContext tc) {
		this.tc=tc;
		this.objM=new PageObjectManager(tc.getDriver());
	}
	ConfigReader cr=new ConfigReader();
	
	@Given("User opens the application")
	public void user_opens_the_application() {
	    //url is opened by hooks class
		ExtentTestManager.getTest().info("Opening website");
	}

	@Given("user clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
	    objM.getLoginPage().clickOpenLoginPage();
	    ExtentTestManager.getTest().info("Clicking on login button");
	}

	@Given("enters valid username and password")
	public void enters_valid_username_and_password() {
	    objM.getLoginPage().enterUsername(cr.getUsername());
	    objM.getLoginPage().enterPassword(cr.getPassword());
	    ExtentTestManager.getTest().info("entering credentials");
	}

	@Given("clicks on login button")
	public void clicks_on_login_button() {
	    objM.getLoginPage().clickSignInBtn();
	    ExtentTestManager.getTest().info("clicking on login button");
	}

	@Then("login page loads successfully")
	public void login_page_loads_successfully() {
		ExtentTestManager.getTest().info("page loaded successfully");
	}




}
