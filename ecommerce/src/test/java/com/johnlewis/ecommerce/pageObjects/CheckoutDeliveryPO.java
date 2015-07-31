package com.johnlewis.ecommerce.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.johnlewis.ecommerce.util.WebConnector;

public class CheckoutDeliveryPO extends PageObject {
	
	private final static Logger LOG = Logger.getLogger(GooglePagePO.class);
	private static final WebConnector WC = WebConnector.getInstance();
	
	@FindBy(xpath = "//div[@id='content']/div[2]/div[1]/div/h1")
	@CacheLookup
	private WebElement checkout_delivery_page;
	
	@FindBy (id = "ukDeliveryButton")
	private WebElement deliveryButton;
	
	@FindBy (id="uk-title-postcode-lookup")
	private WebElement title_textfield;
	
	@FindBy (id = "uk-firstname-postcode-lookup")
	private WebElement firstname_textfield;
	
	@FindBy (id = "uk-surname-postcode-lookup")
	private WebElement lastname_textfield;
	
	@FindBy (id = "uk-postcode-postcode-lookup")
	private WebElement postcode_textfield;
	
	@FindBy (xpath = "//fieldset[@id='uk-deliver-where']//div[@class='wrap-submit']//input[@name='findAddress']")
	private WebElement findaddress_button;
	
	@FindBy (xpath="//*[@id='sel-address']//option[6]")
	private WebElement select_address;
	
	@FindBy (xpath = "//fieldset[@id='uk-select-address']/div[6]/input['btn find-address find-address-select-address']")
	private WebElement click_selectaddress_button;
	
	@FindBy (xpath = "//fieldset[@id='delivery-options']/div/fieldset/div/section[1]")
	private WebElement select_standard_button;
	
	@FindBy (id="contact-no-UK")
	private WebElement mobile_number_textfield;
	
	@FindBy (id= "submit-delivery-choices-UK")
	private WebElement continue_payment_button;
	
	@FindBy (xpath="//div[@id='content']/div[2]/div/h1")
	private WebElement review_pay_page;
	
	public CheckoutDeliveryPO verifyDeliveryPage() {
		WC.assertingWebElement(checkout_delivery_page);
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	
	public CheckoutDeliveryPO deliveryButton() {
		WC.assertingWebElement(deliveryButton);
		deliveryButton.click();
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	
	public CheckoutDeliveryPO titleTextField() {
		WC.assertingWebElement(title_textfield);
		title_textfield.sendKeys("Mrs");
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	
	public CheckoutDeliveryPO firstnameTextField() {
		WC.assertingWebElement(firstname_textfield);
		firstname_textfield.sendKeys("Suma");
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	public CheckoutDeliveryPO lastnameTextField() {
		WC.assertingWebElement(lastname_textfield);
		lastname_textfield.sendKeys("latha");
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	public CheckoutDeliveryPO postcodeTextField() {
		WC.assertingWebElement(postcode_textfield);
		postcode_textfield.sendKeys("HA2 9EF");
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	public CheckoutDeliveryPO findaddressbutton() {
		WC.assertingWebElement(findaddress_button);
		findaddress_button.click();
		WC.implicitwait();
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	public CheckoutDeliveryPO selectaddress() {
		WC.assertingWebElement(select_address);
		select_address.click();
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	public CheckoutDeliveryPO clickselectaddressbutton() {
		WC.implicitwait();
		WC.assertingWebElement(click_selectaddress_button);
		click_selectaddress_button.click();
		
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}

	public CheckoutDeliveryPO selectdeliverybutton() {
		WC.implicitwait();
		WC.assertingWebElement(select_standard_button);
		select_standard_button.click();
		
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	
	public CheckoutDeliveryPO mobilenumbertextfield() {
		WC.implicitwait();
		WC.assertingWebElement(mobile_number_textfield);
		mobile_number_textfield.sendKeys("07459896568");
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	
	public CheckoutDeliveryPO continuePayment() {
		continue_payment_button.click();
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
	
	public CheckoutDeliveryPO verifyReviewPayPage() {
		WC.implicitwait();
		WC.assertingWebElement(review_pay_page);
		return (CheckoutDeliveryPO) WC.getPageObject(CheckoutDeliveryPO.class);
	}
}
