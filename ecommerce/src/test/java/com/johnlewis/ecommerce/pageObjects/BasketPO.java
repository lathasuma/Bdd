package com.johnlewis.ecommerce.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.johnlewis.ecommerce.util.WebConnector;

public class BasketPO extends PageObject {
	
	private final static Logger LOG = Logger.getLogger(GooglePagePO.class);
	private static final WebConnector WC = WebConnector.getInstance();
	
	@FindBy (xpath = "//form[@id='basketForm']/div[3]/div[1]/div[1]/h1")
	@CacheLookup
	private WebElement basket_page;
	
	@FindBy (xpath = "//input[@id='qty232690607']")
	private WebElement change_quantity;
	
	@FindBy (xpath = "//form[@id='basketForm']/div[3]/div[1]/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div/input[3]")
	private WebElement update_link;
	
	@FindBy (xpath = "//form[@id='basketForm']//div[@class='basket-ajax']//div[@class='basket-inner clear']//div[@class='col-16-header']//input[@name='continue-securely']")
	private WebElement continue_securely;
	
	public BasketPO verifyBasketPage() {
		WC.assertingWebElement(basket_page);
		WC.implicitwait();
		return (BasketPO) WC.getPageObject(BasketPO.class);
	}
	
	public BasketPO changeQuantity() {
		WC.implicitwait();
		change_quantity.clear();
		change_quantity.sendKeys("1");
		return (BasketPO) WC.getPageObject(BasketPO.class);
	}
	
	public BasketPO updateLink() {
		WC.assertingWebElement(change_quantity);
		change_quantity.click();
		WC.implicitwait();
		return (BasketPO) WC.getPageObject(BasketPO.class);
	}
	
	public BasketPO continueSecurelyButton() {
		WC.assertingWebElement(continue_securely);
		continue_securely.click();
		WC.implicitwait();
		return (BasketPO) WC.getPageObject(BasketPO.class);
	}
	
}
