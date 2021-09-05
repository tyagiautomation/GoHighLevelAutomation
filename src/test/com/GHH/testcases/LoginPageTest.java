package com.GHH.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GHH.base.baseClass;
import com.GHH.pages.HomePage;
import com.GHH.pages.LoginPage;
import com.GHH.utility.Xls_Reader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

@Listeners(com.GHH.base.TestListners.class)

public class LoginPageTest extends baseClass {

	// Logger log = Logger.getLogger(com.freecrm.testcases.LoginPageTest.class);
	LoginPage loginPage;
	HomePage homePage;
	ExtentReports reports;
	ExtentTest logger;
	Xls_Reader excelReader;

	// to call the super class constructor
	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		// initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	// Using dataProvider for reading the data from excel sheet
	@DataProvider
	public Object[][] getLoginData() {

		// excelReader.path ="./testData/collectionrunner.xls";
		Object data[][] = excelReader.getTestData("LoginData");
		return data;

	}

	@Test(priority = 1)
	public void Verify_loginPage_Title() {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		String title = loginPage.validateLoginPageTitle();
		// reading the values from config files
		logger.log(Status.INFO, "open the url ----->" + prop.getProperty("url"));

		logger.log(Status.INFO, "Actual Title of the page---->" + title);
		logger.log(Status.INFO, "Expected Title of the page----> Login");
		Assert.assertEquals(title, "Login");
	}

	@Test(priority = 2, dataProvider = "getLoginData")
	public void LoginTest_With_invalid_Credentials(String userName, String Password) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		logger.log(Status.INFO, "Enter the Invalid userName----->" + userName);
		logger.log(Status.INFO, "Enter the Invalid password------>" + Password);
		System.out.println(userName);
		System.out.println(Password);
		loginPage.login(userName, Password);
		logger.log(Status.INFO, "Click on sign-In Button");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login");
		logger.log(Status.INFO, "Actual Error Message--->" + loginPage.VerifyErrorMessage());
		logger.log(Status.INFO, "Expected Error Message--->" + "User does not exist");
		Assert.assertEquals(loginPage.VerifyErrorMessage(), "User does not exist");
	}

	@Test(priority = 3)
	public void LoginTest_With_Valid_Crdenetials() {
		logger = com.GHH.utility.ExtentTestManager.getTest();

		logger.log(Status.INFO, "Enter the Valid userName--->" + prop.getProperty("userName"));
		logger.log(Status.INFO, "Enter the Valid password------->" + prop.getProperty("password"));
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		logger.log(Status.INFO, "Click on sign-In Button");
		System.out.println("Actual Title of the Page ----->" + homePage.validateHomePageUrl());
		logger.log(Status.INFO, "Actual Url of the Page ----->" + homePage.validateHomePageUrl());

		logger.log(Status.INFO, "Expected Url of the Page should contain ----->" + "app.gohighlevel.com/location");
		// Assert.assertNotEquals(homePage.validateHomePageUrl(), "login");

		if (homePage.validateHomePageUrl().contains("app.gohighlevel.com/location")) {

			Assert.assertTrue(true);
		} else {

			Assert.assertTrue(false);
		}

	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}

}
