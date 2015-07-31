package com.johnlewis.ecommerce.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.johnlewis.ecommerce.constants.Constants;
import com.johnlewis.ecommerce.util.WebConnector;

public class HomePagePO extends PageObject {

	private final static Logger LOG = Logger.getLogger(HomePagePO.class);
	private static final WebConnector WC = WebConnector.getInstance();

	@FindBy(partialLinkText = "Sign In")
	@CacheLookup
	private WebElement SignInLink;

	@FindBy(id = "um-email")
	private WebElement EmailIdTextbox;

	@FindBy(id = "um-pwd")
	private WebElement PswdTextField;

	@FindBy(xpath = "//form[@id='loginUserForm']//input[@name='sign-in']")
	private WebElement SignInButton;

	@FindBy(id = "login-overlay-login")
	private WebElement login_overlay;

	@FindBy(xpath = "//li[@class='first greeting']/strong['Hello']")
	private WebElement greeting_page;

	@FindBy(id = "logoutUser")
	private WebElement logout_user;

	@FindBy(xpath = "//iframe[@id='login-overlay-iframe']")
	private WebElement login_iframe;
	
	@FindBy(css="#login-overlay-login > section:nth-child(1) > header > a")
	private WebElement close_panel;

	public HomePagePO clickOnSignInLink() {
		WC.assertingWebElement(SignInLink);
		WC.implicitwait();
		SignInLink.click();
		return (HomePagePO) WC.getPageObject(HomePagePO.class);
	}

	public HomePagePO verifyLoginOverlay() {
		WC.switchToFramebyFrameWebElement(login_iframe);
		WC.assertingWebElement(login_overlay);
		return (HomePagePO) WC.getPageObject(HomePagePO.class);
	}

	public HomePagePO enterEmailIdTextbox(String emailId)
			throws InterruptedException {

		WC.assertingWebElement(EmailIdTextbox);
		EmailIdTextbox.clear();
		EmailIdTextbox.sendKeys(emailId);
		return (HomePagePO) WC.getPageObject(HomePagePO.class);
	}

	public HomePagePO enterPswdTextField(String password) {
		WC.assertingWebElement(PswdTextField);
		PswdTextField.clear();
		PswdTextField.sendKeys(password);
		return (HomePagePO) WC.getPageObject(HomePagePO.class);
	}

	public HomePagePO clickOnSignInButton() {
		WC.assertingWebElement(SignInButton);
		SignInButton.click();
		return (HomePagePO) WC.getPageObject(HomePagePO.class);
	}

	public HomePagePO verifyGreetingMessage() {
		WC.assertingWebElement(greeting_page);
		return (HomePagePO) WC.getPageObject(HomePagePO.class);
	}

	public void clickOnSignOutUser() {
		try{
			WC.assertingWebElement(logout_user);
			logout_user.click();
		}
		catch(Exception ex)
		{
			close_panel.click();
		}
	}
	public void doDafaultLogin()
	{
		clickOnSignInLink();
		
		
	}
}
