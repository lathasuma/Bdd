package com.johnlewis.ecommerce.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.johnlewis.ecommerce.util.WebConnector;

public class GooglePagePO extends PageObject{
	private final static Logger LOG = Logger.getLogger(GooglePagePO.class);
	private static final WebConnector WC = WebConnector.getInstance();
	
	@FindBy(id = "lst-ib")
	@CacheLookup
	private WebElement search_textfield;
	
	@FindBy(className = "lsb")
	private WebElement search_button;
	
	@FindBy(xpath = "//ol[@id='rso']//li[@class='g']//div[@class='rc']//h3[@class='r']//a['http://www.johnlewis.com']")
	private WebElement johnlewis_link;
	
	public GooglePagePO searchTextField(String search)
			throws InterruptedException {

		WC.assertingWebElement(search_textfield);
		search_textfield.clear();
		search_textfield.sendKeys(search);
		return (GooglePagePO) WC.getPageObject(GooglePagePO.class);
	}
	
	public GooglePagePO clickOnSearchButton() {

		WC.assertingWebElement(search_button);
		search_button.click();
		return (GooglePagePO) WC.getPageObject(GooglePagePO.class);
	}
	
	public GooglePagePO clickOnSearchLink() {

		WC.assertingWebElement(johnlewis_link);
		WC.implicitwait();
		johnlewis_link.click();
		return (GooglePagePO) WC.getPageObject(GooglePagePO.class);
	}
}
