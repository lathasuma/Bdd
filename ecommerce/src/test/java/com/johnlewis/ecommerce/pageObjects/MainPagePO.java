package com.johnlewis.ecommerce.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.johnlewis.ecommerce.util.WebConnector;
import com.thoughtworks.selenium.webdriven.JavascriptLibrary;

public class MainPagePO extends PageObject{
	
	private final static Logger LOG = Logger.getLogger(GooglePagePO.class);
	private static final WebConnector WC = WebConnector.getInstance();
	private static WebDriver driver;
	
	@FindBy(xpath = "//nav[@id='nn-nav-menu']/ul/li[2]/a/span[2]")
	@CacheLookup
	private WebElement electricals_tab;
	
	@FindBy(xpath = "//nav[@id='nn-nav-menu']/ul/li[2]/div/div[2]/ul/li[1]/a" )
	private WebElement ipad_tablets;
	
	@FindBy(xpath="//div[@id='category-grid']/h1")
	private WebElement ipadtablets;
	
	@FindBy(xpath="//div[@id='view-orders']/div/div[1]/section/section[2]/div/ul/li[5]/a")
	private WebElement ipad_mini_2;
	
	@FindBy(xpath="//div[@id='search-results']/section/header/div[1]/h1")
	private WebElement ipad_images_page;
	
	public MainPagePO mouseOverOnElectricalsTab() {
		WC.assertingWebElement(electricals_tab);
		return (MainPagePO) WC.getPageObject(MainPagePO.class);
	}
	
	public MainPagePO clickOnIpadLink() {
		WC.javaScriptHoover(ipad_tablets);
		WC.implicitwait();
		return (MainPagePO) WC.getPageObject(MainPagePO.class);
	}
	
	public MainPagePO iPadPage() {
		WC.assertingWebElement(ipadtablets);
		WC.implicitwait();
		return (MainPagePO) WC.getPageObject(MainPagePO.class);
	}
	
	public MainPagePO iPadMiniPage() {
		WC.assertingWebElement(ipad_mini_2);
		WC.implicitwait();
		ipad_mini_2.click();
		return (MainPagePO) WC.getPageObject(MainPagePO.class);
	}
	
	public MainPagePO iPadImagePage() {
		WC.assertingWebElement(ipad_images_page);
		WC.implicitwait();
		return (MainPagePO) WC.getPageObject(MainPagePO.class);
	}
	

}
