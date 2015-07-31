package com.johnlewis.ecommerce.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.johnlewis.ecommerce.util.WebConnector;

public class IpadMiniPO extends PageObject {
	
	private final static Logger LOG = Logger.getLogger(GooglePagePO.class);
	private static final WebConnector WC = WebConnector.getInstance();
	
	@FindBy (xpath="//h1[@id='prod-title']/span")
	@CacheLookup
	private WebElement ipad_mini;
	
	@FindBy (xpath="//div[@id='prod-product-colour']/ul/li[2]/a/img")
	private WebElement silver_ipad;
	
	@FindBy (id = "quantity")
	private WebElement update_quantity;
	
	@FindBy (xpath = "//div[@id='prod-add-to-basket']//div[@class='right btn-nerr']//span[@class='btn']//input[@class='btn-plrg-addtobasket button fn_sc_scAdd']")
	private WebElement add_basket;
	
	@FindBy (xpath = "//div[@id='prod-add-to-basket']//div[@class='items-checkout left']//a[@class='view-basket-link']")
	private WebElement view_basket;
	
	public IpadMiniPO ipadDetailedPage() {
		WC.assertingWebElement(ipad_mini);
		WC.implicitwait();
		return (IpadMiniPO) WC.getPageObject(IpadMiniPO.class);
	}
	
	public IpadMiniPO ipadSilverColor() {
		WC.assertingWebElement(silver_ipad);
		silver_ipad.click();
		WC.implicitwait();
		return (IpadMiniPO) WC.getPageObject(IpadMiniPO.class);
	}
	
	public IpadMiniPO updateQuantity() {
		WC.assertingWebElement(update_quantity);
		update_quantity.clear();
		update_quantity.sendKeys("2");
		return (IpadMiniPO) WC.getPageObject(IpadMiniPO.class);
	}
	
	public IpadMiniPO addBasketLink() {
		WC.implicitwait();
		WC.assertingWebElement(add_basket);
		add_basket.click();	
		return (IpadMiniPO) WC.getPageObject(IpadMiniPO.class);
	}
	
	public IpadMiniPO viewBasketLink() {
		WC.implicitwait();
		WC.assertingWebElement(view_basket);
		view_basket.click();
		return (IpadMiniPO) WC.getPageObject(IpadMiniPO.class);
	}

}
