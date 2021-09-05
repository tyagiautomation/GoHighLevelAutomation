package com.GHH.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.GHH.base.baseClass;
import com.GHH.pages.AppointmentsPage;
import com.GHH.pages.HomePage;
import com.GHH.pages.LoginPage;

public class HomePageTest extends baseClass {

	LoginPage loginPage;
	HomePage homePage;
	AppointmentsPage appointmentsPage;

	public HomePageTest() {
		super();
	}

	// test cases should be independent or separated
	@BeforeMethod
	public void setUp() {
		// initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		appointmentsPage = new AppointmentsPage();

		// homePage = loginPage.login(prop.getProperty("userName"), // if we need to run indepdent test
		// prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void Go_TO_Appointments_Screen() {

		homePage.clickOnAppointments();

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}
