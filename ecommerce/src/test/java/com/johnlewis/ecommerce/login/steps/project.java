package com.johnlewis.ecommerce.login.steps;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.johnlewis.ecommerce.constants.Constants;
import com.johnlewis.ecommerce.pageObjects.BasketPO;
import com.johnlewis.ecommerce.pageObjects.CheckoutDeliveryPO;
import com.johnlewis.ecommerce.pageObjects.CheckoutLoginPO;
import com.johnlewis.ecommerce.pageObjects.GooglePagePO;
import com.johnlewis.ecommerce.pageObjects.HomePagePO;
import com.johnlewis.ecommerce.pageObjects.IPadPO;
import com.johnlewis.ecommerce.pageObjects.IpadMiniPO;
import com.johnlewis.ecommerce.pageObjects.MainPagePO;
import com.johnlewis.ecommerce.util.WebConnector;
import com.johnlewis.ecommerce.util.WebConnector.Browsers;








import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class project {
	
		private GooglePagePO googlePagePO;
		private MainPagePO mainPagePO;
		private IPadPO ipadpo;
		private IpadMiniPO ipadminipo;
		private BasketPO basketpo;
		private CheckoutLoginPO checkoutloginpo;
		private CheckoutDeliveryPO checkoutdeliverypo;
		
		private static final WebConnector WC = WebConnector.getInstance();
		private final static Logger LOG = Logger.getLogger(login.class);
		
	@Given ("^I navigate to Google Home Page on \"(.*?)\"$")
	public void i_navigate_to_Google_home_page_on(String browser) throws Throwable {
	    WC.openBrowsers(Browsers.valueOf(browser));
	    WC.navigate();
	}
	
	
	@And ("^I give John Lewis \"(.*?)\"$")
	public void i_give_John_Lewis(String search)throws Throwable {
		googlePagePO = WC.getPageObject(GooglePagePO.class);
		googlePagePO.searchTextField(search);
		LOG.debug("I give John Lewis");
		
	}
	
	
	@And ("^I click on search button$")
	public void i_click_on_search_button() throws Throwable {
		googlePagePO.clickOnSearchButton();
		LOG.debug("I click on Search Button");
	    
	}
	
	@And ("^I click on John Lewis link$")
	public void i_click_on_John_Lewis_link() throws Throwable{
		googlePagePO.clickOnSearchLink();
		LOG.debug("I click on John Lewis link");
	}
	@And ("^I mouse over on Electricals tab$")
	public void i_mouse_over_on_Electricals_tab() throws Throwable{
		mainPagePO = WC.getPageObject(MainPagePO.class);
		mainPagePO.mouseOverOnElectricalsTab();
		LOG.debug("I mouse over on Electricals tab");
	}
	
	@And ("^I click on iPad & Tablets$")
	public void i_click_on_iPad_Tablets() throws Throwable{
		mainPagePO = WC.getPageObject(MainPagePO.class);
		mainPagePO.clickOnIpadLink();
		LOG.debug("I click on iPad & Tablets");
	}
	@Then("^I should get ipad-Tablets Page$")
	public void i_should_get_ipad_Tablets() throws Throwable{
		mainPagePO.iPadPage();
		LOG.debug("I should get ipad-Tablets Page");
		
	}
	@And("^I click on iPad mini 2$")
	public void i_click_on_iPad_mini_2() throws Throwable{
		mainPagePO.iPadMiniPage();
		LOG.debug("I click on iPad mini 2");	
	}
	@Then ("^I should get all iPad images$")
	public void i_should_get_all_iPad_images() throws Throwable{
		mainPagePO.iPadImagePage();
		LOG.debug(" should get all iPad images");
	}
	
	@And ("^I should get all the iPad from Highest Price$")
	public void i_should_get_all_the_iPad_from_Highest_Price() throws Throwable{
		ipadpo = WC.getPageObject(IPadPO.class);
		ipadpo.clickOnPriceButton();
		LOG.debug("I click on Highest-Lowest Price");
	}
	
	@And ("^I click on highest iPad$")
	public void i_click_on_highest_iPad() throws Throwable{
		ipadpo.clickOnHighestIpad();
		LOG.debug("I click on Highest iPad");
	}
	@Then ("^I should get selected iPad detailed page$")
	public void i_should_get_selected_iPad_detailed_page() throws Throwable{
		ipadminipo = WC.getPageObject(IpadMiniPO.class);
		ipadminipo.ipadDetailedPage();
		LOG.debug("I should get selected iPad detailed page");
	}
	@And ("^I click on Silver color$")
	public void i_click_on_silver_color() throws Throwable{
		ipadminipo.ipadSilverColor();
		LOG.debug("I click on Silver color");
	}
	
	@Then("^I should change the Quantity$") 
	public void i_should_change_the_quantity() throws Throwable{
		ipadminipo.updateQuantity();
		LOG.debug("I should change the Quantity");
	}
	@And("^I click on Add to Basket$") 
	public void i_click_on_Add_to_basket() throws Throwable{
		ipadminipo.addBasketLink();
		LOG.debug("I click on Add to Basket");
	}
	@And ("^I click on View basket$")
	public void i_click_on_view_basket() throws Throwable{
		ipadminipo.viewBasketLink();
		LOG.debug("I click on View basket");
	}
	@Then ("^I should get basket page$")
	public void i_should_get_basket_page() throws Throwable{
		basketpo = WC.getPageObject(BasketPO.class);
		basketpo.verifyBasketPage();
		LOG.debug("I should get basket page");
	}
	@And ("^I changed the Quantity$") 
	public void i_changed_the_Quantity() throws Throwable{
		basketpo.changeQuantity();
		LOG.debug("I changed the Quantity");
	}
	@And ("^I clicked on update link$")
	public void i_clicked_on_update_link() throws Throwable{
		basketpo.updateLink();
		LOG.debug("I clicked on update link");
	}
	@And ("^I clicked on Continue securely$")
	public void i_clicked_on_continue_securely() throws Throwable{
		basketpo.continueSecurelyButton();
		LOG.debug("I clicked on continue securely");
	}
	@Then ("^I should get checkout Page$")
	public void i_should_get_checkout_page() throws Throwable{
		checkoutloginpo = WC.getPageObject(CheckoutLoginPO.class);
		checkoutloginpo.verifyCheckoutLogin();
		LOG.debug("I should get checkout page");
	}
	@Then ("^I give email address \"(.*?)\"$")
	public void i_give_email_address(String emailid) throws Throwable{
		checkoutloginpo.emailTextBox(emailid);
		LOG.debug("I give email address");
	}
	@And("^I click on Continue button$")
	public void i_click_on_continue_button() throws Throwable{
		checkoutloginpo.continueButton();
		LOG.debug("I click on continue button");
	}
	@Then ("^I should get checkout delivery details page$")
	public void i_should_get_checkout_delivery_details_page() throws Throwable{
		checkoutdeliverypo = WC.getPageObject(CheckoutDeliveryPO.class);
		checkoutdeliverypo.verifyDeliveryPage();
		LOG.debug("I should get checkout delivery details page");
	}
	@And ("^I click on UK delivery link$")
	public void i_click_on_UK_delivery_link() throws Throwable{
		checkoutdeliverypo.deliveryButton();
		LOG.debug("I click on UK delivery link");
	}
	@And ("^I give the Title$")
	public void i_given_the_title() throws Throwable{
		checkoutdeliverypo.titleTextField();
		LOG.debug(" given the Title");
	}
	@And ("^I give the First name$")
	public void i_give_the_firstname() throws Throwable{
		checkoutdeliverypo.firstnameTextField();
		LOG.debug("I give the firstname");
	}
	@And ("^I give the Last name$") 
	public void i_give_the_lastname() throws Throwable{
		checkoutdeliverypo.lastnameTextField();
		LOG.debug("I give the lastname");
	}
	
	@And ("^I give the Post code$")
	public void i_give_the_post_code() throws Throwable{
		checkoutdeliverypo.postcodeTextField();
		LOG.debug("I give the post code");
	}
	
	@And ("^I click on Find Address button$")
	public void i_click_on_Find_Address_button() throws Throwable{
		checkoutdeliverypo.findaddressbutton();
		LOG.debug("I click on find address button");
	}
	@And ("^I selected the address$")
	public void i_selected_the_address() throws Throwable{
		checkoutdeliverypo.selectaddress();
		LOG.debug("I selected the address");
	}
	
	@And ("^I click on select Address button$")
	public void i_click_on_select_address_button() throws Throwable{
		checkoutdeliverypo.clickselectaddressbutton();
		LOG.debug("I click on select address button");
	}
	@And("^I selected the standard delivery$") 
	public void i_selected_the_standard_delivery() throws Throwable{
		checkoutdeliverypo.selectdeliverybutton();
		LOG.debug("I selected the standard delivery");
	}
	@And ("^I enter the mobile number$")
	public void i_give_the_mobile_number() throws Throwable{
		checkoutdeliverypo.mobilenumbertextfield();
		LOG.debug("I give the mobile number");
	}
	@And ("^I click on Continue to payment$")
	public void i_click_on_continue_to_payment() throws Throwable{
		checkoutdeliverypo.continuePayment();
		LOG.debug("I click on continue to payment");
	}
	@Then ("^I should get Review & Pay Page \"(.*?)\"$")
	public void i_should_get_Review_Pay_Page(String expectedResult) throws Throwable{
		System.out.println("Review "+ expectedResult);
		boolean result=WC.isIDPresent(Constants.ReviewMessage);
		String actualResult=null;
		
		if(result)
			actualResult="Success";
		
		else
			actualResult="Failure";
		
		//Assert.assertEquals(expectedResult, actualResult);
		Thread.sleep(5000L);
		checkoutdeliverypo.verifyReviewPayPage();
		LOG.debug("I should get review & pay page");
	}
	@After("@project")
	 public static void close() {

	  WC.quitbrowser();
	 }

}
