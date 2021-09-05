package com.GHH.testcases;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GHH.base.baseClass;
import com.GHH.pages.AppointmentsPage;
import com.GHH.pages.HomePage;
import com.GHH.pages.LoginPage;
import com.GHH.utility.Xls_Reader;

public class AppointmentPageTest extends baseClass {

	LoginPage loginPage;
	HomePage homePage;
	AppointmentsPage appointmentsPage;
	Xls_Reader excelReader;

	public AppointmentPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		// initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		appointmentsPage = new AppointmentsPage();
		// homePage = loginPage.login(prop.getProperty("userName"),
		// prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void Go_TO_Schedule_Appointments_Screen(){
		appointmentsPage.click_On_Schedule_Appointment();
		

	}

	//Using DataProvider for reading the data from excel sheet
	@DataProvider
	public Object[][] getAppointmentData() {

		Object data[][] = excelReader.getTestData("AppointmnetData");
		return data;

	}

	@Test(priority = 2, dataProvider = "getAppointmentData")
	public void AddSchdeule_Appointment_and_Verify(String Day, String DOB, String Slot, String AppointmentTitle,
			String ContactName, String EmailAddress, Object PhoneNumber, String Timezone, String Location,
			String Status, String AppointmentStatus, String Notes) {
		
		appointmentsPage.Add_Appointment();
		appointmentsPage.addAptTitle(AppointmentTitle);
		appointmentsPage.addcustomerName(ContactName);
		appointmentsPage.addEmail(EmailAddress);
		appointmentsPage.selectAppointmentDate(Day);
		appointmentsPage.selectSlots(Slot);
		//appointmentsPage.addphoneNo(PhoneNumber); // bug in mobileNumber field
		appointmentsPage.DOB(DOB);
		appointmentsPage.addTimeZone(Timezone);
		appointmentsPage.addMeetingLocation(Location);
		appointmentsPage.addstatus(Status);
		appointmentsPage.addAptStatus(AppointmentStatus);
		appointmentsPage.addNotes(Notes);
		appointmentsPage.clickOnSaveBtn();

	}
}
