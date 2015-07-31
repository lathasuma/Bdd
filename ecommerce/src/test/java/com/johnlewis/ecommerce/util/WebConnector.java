package com.johnlewis.ecommerce.util;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import com.johnlewis.ecommerce.constants.Constants;
import com.johnlewis.ecommerce.pageObjects.PageObject;
import com.thoughtworks.selenium.webdriven.JavascriptLibrary;

public final class WebConnector

{

	Properties Config = null;

	public WebDriver driver;

	WebDriver ie = null;
	private String prevWindowHandle = "";
	private final static Logger LOG = Logger.getLogger(WebConnector.class);
	private static WebConnector w;
	private Map<Browsers, WebDriver> drivers = new HashMap<Browsers, WebDriver>();

	/** Browser to be used */
	public enum Browsers {
		Firefox, Chrome, InternetExplorer, Android, Ipad, Iphone, Opera, Safari, RemoteFirefox, RemoteChrome, RemoteInternetExplorer7, RemoteInternetExplorer8, RemoteInternetExplorer9, RemoteInternetExplorer10, RemoteInternetExplorer11
	};

	private LoadProperties loadPropertiesObj;

	private WebConnector() {
		init();
	}

	// Selenium servers
	private String chromeDriverExeLocation;
	private String ieDriverExeLocation;
	private String remoteWebDriverLocation;
	private Properties configProperties;

	/**
	 * Initial method, loads properties
	 */
	private void init() {
		loadPropertiesObj = new LoadProperties();
		loadPropertiesObj.init();
		configProperties = loadPropertiesObj.getConfigProperties();

		if (configProperties != null) {
			chromeDriverExeLocation = configProperties
					.getProperty(Constants.CHROMER_DRIVER_LOCATION);
			ieDriverExeLocation = configProperties
					.getProperty(Constants.IE_DRIVER_LOCATION);
			remoteWebDriverLocation = configProperties
					.getProperty(Constants.REMOTE_WEB_DRIVER_LOCATION);
		}
	}

	/**
	 * Opens the specific browser and points to the URL
	 * 
	 * @param browser
	 * @param url
	 */
	public void openBrowsers(Browsers browser) {
		try {
			openBrowser(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception ex) {
			LOG.error("Error while opening the Browser/URL, aborting test: ",
					ex);
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Opens the specific browser
	 * 
	 * @param browser
	 */
	public void openBrowser(Browsers browser) {
		try {
			switch (browser) {
			case Firefox:
				LOG.debug("Firefox Browser");

				if (drivers.get(Browsers.Firefox) == null) {
					LOG.debug("--New Firefox Browser");
					DesiredCapabilities capabilities = DesiredCapabilities
							.firefox();
					capabilities.setPlatform(Platform.ANY);
					capabilities.setJavascriptEnabled(true);
					drivers.put(Browsers.Firefox, new FirefoxDriver(
							capabilities));
				}
				driver = drivers.get(Browsers.Firefox);
				break;
			case Chrome:
				LOG.debug("Chrome Browser");
				if (drivers.get(Browsers.Chrome) == null) {
					LOG.debug("--New Chrome Browser");
					drivers.put(Browsers.Chrome, openChromeBrowser());
				}
				driver = drivers.get(Browsers.Chrome);
				break;
			case InternetExplorer:
				LOG.debug("Internet explorer Browser");
				if (drivers.get(Browsers.InternetExplorer) == null) {
					LOG.debug("--New IE Browser");
					drivers.put(Browsers.InternetExplorer,
							openInternetExplorerBrowser());
					driver = drivers.get(Browsers.InternetExplorer);
				} else {
					driver = new InternetExplorerDriver();
				}
				break;
			case Safari:
				LOG.debug("Safari Browser");
				if (drivers.get(Browsers.Safari) == null) {
					LOG.debug("--New Safari Browser");
					drivers.put(Browsers.Safari, new SafariDriver());
				}
				driver = drivers.get(Browsers.Safari);
				break;
			case RemoteFirefox:
				LOG.debug("Firefox Remote Browser");
				if (drivers.get(Browsers.RemoteFirefox) == null) {
					LOG.debug("--New Remote Firefox Browser");
					FirefoxProfile fp = new FirefoxProfile();
					fp.setPreference("network.proxy.type",
							ProxyType.AUTODETECT.ordinal());
					DesiredCapabilities capabilities = DesiredCapabilities
							.firefox();
					capabilities.setCapability(FirefoxDriver.PROFILE, fp);
					capabilities.setJavascriptEnabled(true);
					drivers.put(Browsers.RemoteFirefox, new RemoteWebDriver(
							new URL(remoteWebDriverLocation), capabilities));
				}
				driver = drivers.get(Browsers.RemoteFirefox);
				break;
			case RemoteChrome:
				LOG.debug("Chrome Remote Browser");
				if (drivers.get(Browsers.RemoteChrome) == null) {
					LOG.debug("--New Remote Chrome Browser");
					DesiredCapabilities capabilities = DesiredCapabilities
							.chrome();
					capabilities.setJavascriptEnabled(true);
					drivers.put(Browsers.RemoteChrome, new RemoteWebDriver(
							new URL(remoteWebDriverLocation), capabilities));
				}
				driver = drivers.get(Browsers.RemoteChrome);
				break;

			case RemoteInternetExplorer7:
				LOG.debug("Internet Explorer Remote Browser");
				if (drivers.get(Browsers.RemoteInternetExplorer7) == null) {
					LOG.debug("--New Remote IE Browser 7");
					DesiredCapabilities capabilities = DesiredCapabilities
							.internetExplorer();
					capabilities.setJavascriptEnabled(true);

					capabilities.setCapability("version", "7");
					capabilities.setCapability("platform", Platform.WINDOWS);

					drivers.put(Browsers.RemoteInternetExplorer7,
							new RemoteWebDriver(
									new URL(remoteWebDriverLocation),
									capabilities));
				}
				driver = drivers.get(Browsers.RemoteInternetExplorer7);
				break;

			case RemoteInternetExplorer8:
				LOG.debug("Internet Explorer Remote Browser8");
				if (drivers.get(Browsers.RemoteInternetExplorer8) == null) {
					LOG.debug("--New Remote IE Browser 8");
					DesiredCapabilities capabilities = DesiredCapabilities
							.internetExplorer();
					capabilities.setJavascriptEnabled(true);

					capabilities.setCapability("version", "8");
					capabilities.setCapability("platform", Platform.WINDOWS);

					drivers.put(Browsers.RemoteInternetExplorer8,
							new RemoteWebDriver(
									new URL(remoteWebDriverLocation),
									capabilities));
				}
				driver = drivers.get(Browsers.RemoteInternetExplorer8);
				break;

			case RemoteInternetExplorer9:
				LOG.debug("Internet Explorer Remote Browser9");
				if (drivers.get(Browsers.RemoteInternetExplorer9) == null) {
					LOG.debug("--New Remote IE Browser9");
					DesiredCapabilities capabilities = DesiredCapabilities
							.internetExplorer();
					capabilities.setJavascriptEnabled(true);

					capabilities.setCapability("version", "9");
					capabilities.setCapability("platform", Platform.WINDOWS);

					drivers.put(Browsers.RemoteInternetExplorer9,
							new RemoteWebDriver(
									new URL(remoteWebDriverLocation),
									capabilities));
				}
				driver = drivers.get(Browsers.RemoteInternetExplorer9);
				break;

			case RemoteInternetExplorer10:
				LOG.debug("Internet Explorer Remote Browser10");
				if (drivers.get(Browsers.RemoteInternetExplorer10) == null) {
					LOG.debug("--New Remote IE Browse10r");
					DesiredCapabilities capabilities = DesiredCapabilities
							.internetExplorer();
					capabilities.setJavascriptEnabled(true);

					capabilities.setCapability("version", "10");
					capabilities.setCapability("platform", Platform.WINDOWS);

					drivers.put(Browsers.RemoteInternetExplorer10,
							new RemoteWebDriver(
									new URL(remoteWebDriverLocation),
									capabilities));
				}
				driver = drivers.get(Browsers.RemoteInternetExplorer10);
				break;

			case RemoteInternetExplorer11:
				LOG.debug("Internet Explorer Remote Browser11");
				if (drivers.get(Browsers.RemoteInternetExplorer11) == null) {
					LOG.debug("--New Remote IE Browser11");
					// System.setProperty("webdriver.ie.driver",
					// "C:\\Selenium\\BrowserDrivers\\IEDriverServer.exe");
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
					drivers.put(Browsers.RemoteInternetExplorer11,
							new RemoteWebDriver(
									new URL(remoteWebDriverLocation),
									capabilities));
				}
				driver = drivers.get(Browsers.RemoteInternetExplorer11);
				break;
			// if our browser is not listed, throw an error
			default:
				LOG.debug("Browser not understood: " + browser.toString());
				throw new RuntimeException("Browser not found");
			}

		} catch (Exception ex) {
			LOG.error("Error while opening the Browser", ex);
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Opens the IE Browser with the EXE server
	 */
	private WebDriver openInternetExplorerBrowser() {
		File file = new File(ieDriverExeLocation);
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		InternetExplorerDriverService service = InternetExplorerDriverService
				.createDefaultService();
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,
				"about:blank");
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,
				true);
		capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,
				true);
		capabilities.setCapability(
				InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		capabilities.setCapability(
				InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
		capabilities.setCapability(
				InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
		capabilities.setCapability("version", "11");
		return new InternetExplorerDriver(service, capabilities);
	}

	/**
	 * Opens the Chrome Browser with the EXE server
	 */
	private WebDriver openChromeBrowser() {
		
		// For Windows machine
		/*try {
			File file = null;
			String os = System.getProperty("os.name").toLowerCase();
			LOG.debug("OS Name =>" + os);
			if (os.indexOf("win") >= 0) {
				System.out.println("Executing Windows Chrome Driver");
				file = new File(chromeDriverExeLocation);
				//System.setProperty("webdriver.chrome.driver",
						//file.getAbsolutePath());
				System.setProperty("webdriver.chrome.driver","C:/Selenium/BrowserDrivers/chromedriver.exe");
				DesiredCapabilities capabilies = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type", "start-maximized",
						"no-default-browser-check");
				capabilies.setCapability(ChromeOptions.CAPABILITY, options);
				capabilies.setBrowserName("chrome");
				capabilies.setPlatform(Platform.ANY);
			} else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0
					|| os.indexOf("aix") > 0) {
				System.out.println("Executing Linux Chrome Driver");
				file = new File(System.getProperty("user.dir")
						+ chromeDriverExeLocation);
				System.setProperty("webdriver.chrome.driver",
						file.getAbsolutePath());
			}
		} catch (Exception e) {
			LOG.error("Error openning Chrome Browser", e);
		}
*/
		// For MAC
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:/Selenium/BrowserDrivers/chromedriver.exe"); DesiredCapabilities
		 * capabilies = DesiredCapabilities.chrome(); ChromeOptions options =
		 * new ChromeOptions(); options.addArguments("test-type",
		 * "start-maximized", "no-default-browser-check");
		 * capabilies.setCapability(ChromeOptions.CAPABILITY, options);
		 * capabilies.setBrowserName("chrome");
		 * capabilies.setPlatform(Platform.ANY);
		 * capabilies.setCapability("chrome.binary",
		 * "D:/Selenium/BrowserDrivers/chromedriver.exe");
		 */
		
		System.setProperty("webdriver.chrome.driver","C:/Selenium/BrowserDrivers/chromedriver.exe");
		return new ChromeDriver();
	}

	public void navigate() {

		driver.get("http://www.johnlewis.com");

	}

	public void switchToActiveElement() {
		driver.switchTo().activeElement();
	}

	public void switchToFramebyFrameWebElement(WebElement frameElement) {
		saveCurrentWindowHandle();
		driver.switchTo().frame(frameElement);
	}

	protected void saveCurrentWindowHandle() {
		try {
			prevWindowHandle = getCurrentWindowHandle();
		} catch (NoSuchWindowException ex) {
			LOG.warn("Window has been closed - Unable to save previous window handle");
		}
	}

	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	protected String getPreviousWindowHandle() {
		return prevWindowHandle;
	}

	public void assertingWebElement(WebElement element) {

		Assert.assertTrue("Is " + element + " displayed ========>",
				element.isDisplayed());
	}

	public void quitbrowser() {

		driver.quit();

	}

	public void maximize() {

		driver.manage().window().maximize();

	}

	public void implicitwait() {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	}

	public void sleep() throws InterruptedException {

		Thread.sleep(2000L);

	}

	public static WebConnector getInstance() {

		if (w == null)

			w = new WebConnector();

		return w;

	}
	
	public void javaScriptHoover(WebElement element){
		
		JavascriptLibrary jsLib = new JavascriptLibrary(); 
		jsLib.callEmbeddedSelenium(driver,"triggerMouseEventAt",element,"click", "3,1");
	}

	// Getters and Setters

	public Properties getConfigProperties() {
		return configProperties;
	}

	public void setConfigProperties(Properties configProperties) {
		this.configProperties = configProperties;
	}

	/**
	 * Retrieves the page object
	 * 
	 * @param className
	 *            name of the class to be instantiated
	 * @return page object
	 */
	public <T extends PageObject> T getPageObject(Class<T> className) {
		if (this.driver == null) {
			throw new RuntimeException("Trying create PageObject for ["
					+ className + "] " + "before the browser has been opened. "
					+ "\nThis is not allowed - OPEN THE BROWSER first.");
		}

		T retVal = PageFactory.initElements(this.driver, className);
		return retVal;
	}
	
	public boolean isElementPresent(String objectName){
		int count = driver.findElements(By.xpath((objectName))).size();
		if(count==0)
			return false;
		else
			return true;
	}
	public boolean isIDPresent(String objectName){
		int count = driver.findElements(By.id((objectName))).size();
		if(count==0)
			return false;
		else
			return true;
	}
	

public boolean isLoggedIn(){
		
		if(isElementPresent("searchText"))
			return true;
		else
			return false;
	}
	

}
