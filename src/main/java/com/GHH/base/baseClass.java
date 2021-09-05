package com.GHH.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.GHH.utility.TestUtil;
import com.GHH.utility.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

/*--------created by Sumit Tyagi-------------------------------------
--------Date 9/2/21 11:10 PM-----------------------------------------*/

/**************************************** PURPOSE ********************************** - 
 * This class is the base class used for intializing the browsers and to perform the test on multiple browsers.
 * In this class constructor is created which is reading the properties of the browser from the config file.
 */

public class baseClass {

	public static WebDriver driver;
	public static Properties prop;

	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriverWait wait;

	public baseClass() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/GHH/" + "config/config.Properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//@Parameters("browserName")
	@BeforeTest
	// initialize a browser driver
	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		// used to maximize the browser
		driver.manage().window().maximize();

		// used to delete the previous cookies
		driver.manage().deleteAllCookies();

		// page load timeout of 30 seconds is defined
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		// implicit wait of 30 seconds is defined
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Used to open the UR which is passed in the config file
		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver, 30);
	}
}
