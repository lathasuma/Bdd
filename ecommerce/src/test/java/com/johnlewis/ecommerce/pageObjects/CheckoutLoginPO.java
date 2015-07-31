package com.johnlewis.ecommerce.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.johnlewis.ecommerce.util.WebConnector;

public class CheckoutLoginPO extends PageObject{
	
	private final static Logger LOG = Logger.getLogger(GooglePagePO.class);
	private static final WebConnector WC = WebConnector.getInstance();
	
	@FindBy (xpath = "//form[@id='theform']/div/h1")
	@CacheLookup
	private WebElement checkout_login;
	
	@FindBy(id = "txt-email")
	private WebElement email_textbox;
	
	@FindBy (name = "continue-1")
	private WebElement continue_button;
	
	public CheckoutLoginPO verifyCheckoutLogin() {
		WC.assertingWebElement(checkout_login);
		return (CheckoutLoginPO) WC.getPageObject(CheckoutLoginPO.class);
	}
	
	public CheckoutLoginPO emailTextBox(String emailid) {
		WC.assertingWebElement(email_textbox);
		email_textbox.clear();
		email_textbox.sendKeys(emailid);
		return (CheckoutLoginPO) WC.getPageObject(CheckoutLoginPO.class);
	}
	
	public CheckoutLoginPO continueButton() {
		WC.assertingWebElement(continue_button);
		continue_button.click();
		return (CheckoutLoginPO) WC.getPageObject(CheckoutLoginPO.class);
	}

}
