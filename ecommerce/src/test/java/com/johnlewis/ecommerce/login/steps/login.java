package com.johnlewis.ecommerce.login.steps;

import org.apache.log4j.Logger;




import org.junit.Assert;

import com.johnlewis.ecommerce.constants.Constants;
import com.johnlewis.ecommerce.pageObjects.HomePagePO;
import com.johnlewis.ecommerce.util.WebConnector;
import com.johnlewis.ecommerce.util.WebConnector.Browsers;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login {
	private HomePagePO homePagePO;
	private static final WebConnector WC = WebConnector.getInstance();
	private final static Logger LOG = Logger.getLogger(login.class);
	
	@Given("^I navigate to John Lewis home page on \"(.*?)\"$")
	public void i_navigate_to_John_Lewis_home_page_on(String browser) throws Throwable {
	    WC.openBrowsers(Browsers.valueOf(browser));
	    WC.navigate();
	}

	@And("^I click on the Sign In link$")
	public void i_click_on_the_Sign_In_link() throws Throwable {
		homePagePO = WC.getPageObject(HomePagePO.class);
		homePagePO.clickOnSignInLink();
		LOG.debug("I click on the Sign In link");
	    
	}

	@Then("^I should see Sign in overlay$")
	public void i_should_see_Sign_in_overlay() throws Throwable {
		homePagePO.verifyLoginOverlay();
		LOG.debug("I should see Sign in overlay");
	}

	@When("^I type my valid email address as \"(.*?)\"$")
	public void i_type_my_valid_email_address_as(String emailId) throws Throwable {
		
		homePagePO.enterEmailIdTextbox(emailId);
		LOG.debug("I type my valid email address as");
	   
	}

	@And("^I type my valid password as \"(.*?)\"$")
	public void i_type_my_valid_password_as(String pswd) throws Throwable {
		
		homePagePO.enterPswdTextField(pswd);
		LOG.debug("I type my valid password as");
	}

	@And("^I click on Sign In button$")
	public void i_click_on_Sign_In_button() throws Throwable {
		
		homePagePO.clickOnSignInButton(); 
		LOG.debug("I click on Sign In button");
	}

	@Then("^I should get \"(.*?)\"$")
	public void i_should_get(String expectedResult) throws Throwable {
		/*homePagePO.verifyGreetingMessage();
		
		LOG.debug("I should get Hello suma");*/
		
		System.out.println("Login - "+ expectedResult);
		boolean result=WC.isElementPresent(Constants.GreetingMessage);
		String actualResult=null;
		
		if(result)
			actualResult="Success";
		
		else
			actualResult="Failure";
		
		Assert.assertEquals(expectedResult, actualResult);
		Thread.sleep(5000L);
		homePagePO.clickOnSignOutUser();
	}
	
	@After("@login")
	 public static void close() {

	  WC.quitbrowser();
	 }
	
	
	

}
