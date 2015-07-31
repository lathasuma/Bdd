package com.johnlewis.ecommerce.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.johnlewis.ecommerce.util.WebConnector;

public class IPadPO extends PageObject{
	
	private final static Logger LOG = Logger.getLogger(GooglePagePO.class);
	private static final WebConnector WC = WebConnector.getInstance();
	
	@FindBy(xpath="//nav[@id='results-header-nav']/div[1]/form/select")
	@CacheLookup
	private WebElement high_low_price;

	@FindBy (xpath="//a[@id='669395-product-link']/img")
	private WebElement highest_ipad;
	
	public IPadPO clickOnPriceButton() {
		WC.implicitwait();
		WC.assertingWebElement(high_low_price);
		high_low_price.click();
		return (IPadPO) WC.getPageObject(IPadPO.class);
	}
	
	public IPadPO clickOnHighestIpad() {		
		WC.assertingWebElement(highest_ipad);
		highest_ipad.click();
		WC.implicitwait();
		return (IPadPO) WC.getPageObject(IPadPO.class);
	}
}
