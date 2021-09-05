package com.GHH.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GHH.base.baseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class HomePage extends baseClass {
	
	ExtentReports reports;
	ExtentTest logger;
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	@FindBy(xpath = "//span[normalize-space()='Launch Pad']")
	@CacheLookup
	WebElement Launch_Pad;

	@FindBy(xpath = "//span[normalize-space()='Dashboard']")
	WebElement Dashboard;
	
	@FindBy(xpath = "//span[normalize-space()='Conversations']")
	WebElement Conversations;
	
	// WebElements of under the Scheduling sections
	@FindBy(xpath = "//span[normalize-space()='Scheduling']")
	WebElement Scheduling;
	
	@FindBy(xpath = "//a[normalize-space()='Calendar']")
	WebElement Calendar;
	
	@FindBy(xpath = "//a[normalize-space()='Appointments']")
	WebElement Appointments;
	
	
	@FindBy(xpath = "//span[normalize-space()='Settings']")
	WebElement Settings;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	//Method to Click on Appointments on the Menu Navigation
	public AppointmentsPage clickOnAppointments(){
		logger = com.GHH.utility.ExtentTestManager.getTest();
		wait.until(ExpectedConditions.visibilityOf(Settings));
		
		Scheduling.click();
		logger.log(Status.INFO, "Click on Settings Button");
		Appointments.click();
		logger.log(Status.INFO, "Click on Appointments Button");
		return new AppointmentsPage();
	}
	
	// Method to get the currentUrl of the HomePage
	public String validateHomePageUrl(){
		wait.until(ExpectedConditions.urlContains("app.gohighlevel.com/location"));
		return driver.getCurrentUrl();
		
	}
	// Method to click on Settings on Home Page Menu
public SettingsPage clickOnContactsLink(){
		
		Settings.click();
		return new SettingsPage();
	}
	

}
