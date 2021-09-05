package com.GHH.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GHH.base.baseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AppointmentsPage extends baseClass {

	ExtentReports reports;
	ExtentTest logger;
	public WebDriverWait wait = new WebDriverWait(driver, 30);

	@FindBy(xpath = "//button[@id='pg-appt__btn--appt-add']")
	WebElement Schedule_Appointment_btn;

	@FindBy(xpath = "//input[@name='appointmentTitle']")
	WebElement appointmentTitle_field;

	@FindBy(xpath = "//input[@name='customerName']")
	WebElement customerName_field;

	@FindBy(xpath = "//input[@name='msgsndr_email']")
	WebElement email_field;

	@FindBy(xpath = "//input[@name='msgsndr_phone']")
	WebElement phoneNo_field;

	@FindBy(xpath = "//textarea[@placeholder='Notes']")
	WebElement notes_filed;

	@FindBy(xpath = "//input[@name='msgsndr_address']")
	WebElement meetingLocation_field;

	@FindBy(xpath = "//button[@data-id='cmp-apt-modal__sel--apt-status']")
	WebElement Aptstatus_field;

	@FindBy(xpath = "//button[@data-id='cmp-apt-modal__sel--status']")
	WebElement status_field;

	@FindBy(xpath = "//button[@id='cmp-apt-modal__btn--save']")
	WebElement saveBtn;

	@FindBy(xpath = "//select[@name='timezone']")
	WebElement timrZone;

	@FindBy(name = "slot")
	WebElement slotOption;

	public AppointmentsPage() {
		PageFactory.initElements(driver, this);
	}

	// Method used for Adding a Appointment

	public void Add_Appointment() {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		try {
			// element to click on alert if present
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@click='closeAlert']")));
			driver.findElement(By.xpath("//span[@click='closeAlert']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='pg-appt__btn--appt-add']")));
		js.executeScript("arguments[0].click();", Schedule_Appointment_btn);
		// clicking on Schedule Appointment button
		js.executeScript("arguments[0].click();", Schedule_Appointment_btn);
		// Schedule_Appointment_btn.click();
		logger.log(Status.INFO, "Click on Schedule Appointment Button");
	}

	public void click_On_Schedule_Appointment() {
		logger = com.GHH.utility.ExtentTestManager.getTest();

		// Schedule_Appointment_btn.click();
		logger.log(Status.INFO, "Click on Schedule Appointment Button");
	}

	// Method to Set Appointment Title
	public void addAptTitle(String Apttitle) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='appointmentTitle']")));
		appointmentTitle_field.sendKeys(Apttitle);
		System.out.println("hi01");
		logger.log(Status.INFO, "Enter the Appointment Title --->" + Apttitle);
		System.out.println("hi02");
	}

	// Method to Set CustomerName
	public void addcustomerName(String customerName) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		System.out.println("hi03");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='customerName']")));
		customerName_field.sendKeys(customerName);
		logger.log(Status.INFO, "Enter the Customer Name -->" + customerName);
	}

	// Method to Set CustomerEmail
	public void addEmail(String email) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		email_field.sendKeys(email);
		logger.log(Status.INFO, "Enter the Email -->" + email);
	}

	// Method to Set CustomerMobileNumber
	public void addphoneNo(String phoneNo) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		phoneNo_field.sendKeys(phoneNo);
		logger.log(Status.INFO, "Enter the PhoneNo -->" + phoneNo);
	}

	// Method to Add Notes in Appointment
	public void addNotes(String notes) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		notes_filed.sendKeys(notes);
		logger.log(Status.INFO, "Enter the Notes -->" + notes);

	}

	// Method to Set Meeting Location
	public void addMeetingLocation(String mLocation) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		meetingLocation_field.sendKeys(mLocation);
		logger.log(Status.INFO, "Enter the Meeting Location -->" + mLocation);
	}

	// Method to Set Status
	public void addstatus(String status) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		status_field.click();
		driver.findElement(By.xpath(
				"//button[@data-id='cmp-apt-modal__sel--status']//following-sibling::div//descendant::span[text()='"
						+ status + "']"))
				.click();
		logger.log(Status.INFO, "Select the Status -->" + status);
	}

	// Method to Set Appointment Status
	public void addAptStatus(String aptStatus) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		Aptstatus_field.click();
		driver.findElement(By.xpath(
				"//button[@data-id='cmp-apt-modal__sel--apt-status']//following-sibling::div//descendant::span[text()='"
						+ aptStatus + "']"))
				.click();
		logger.log(Status.INFO, "Select the Appointment Status -->" + aptStatus);
	}

	// Method to Set TimeZone
	public void addTimeZone(String tzName) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		Select selectTimeZone = new Select(timrZone);
		selectTimeZone.selectByValue(tzName);
		logger.log(Status.INFO, "Select the TimeZone -->" + tzName);
	}

	// Method to Click on Save Button
	public void clickOnSaveBtn() {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		saveBtn.click();
		logger.log(Status.INFO, "Click on Save Button");
	}

	// Method to Select the Appointment Slots
	public void selectSlots(String slot) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		Select slot_option = new Select(slotOption);
		slot_option.selectByVisibleText(slot);
		logger.log(Status.INFO, "Select the Slots -->" + slot);
	}

	// Method to Select the DateOfBirth
	public void DOB(String dob) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		// DOB -> "December 6, 2021";

		System.out.println(dob);
		String[] output = dob.split(" ");
		String year = output[2];
		System.out.println(year);
		String month = output[0];
		System.out.println(month);
		String day = output[1].replace(",", "");

		driver.findElement(By.xpath("//input[@name='dateOfBirth']")).click();
		// Getting the Current element of the Calendar Year
		String yr = driver.findElement(By.xpath(
				"//*[@id=\"book-appointment\"]/descendant::div[@class='vdp-datepicker__calendar'][4]/header/span[2]"))
				.getText();

		int yearDiff = Integer.parseInt(yr.substring(0, 4)) - Integer.parseInt(year);
		// If Year difference is greater than Zero then we have to go back to previous
		// year
		if (yearDiff >= 0) {
			// If year difference is 21 %2 = 2.1 then running for loop to go the prevous
			// year
			if (yearDiff % 10 != 0) {
				for (int i = 1; i <= yearDiff / 10 + 1; i++) {
					System.out.println("Greater Year Diff->");

					driver.findElement(By.xpath(
							"//*[@id=\"book-appointment\"]/descendant::div[@class='vdp-datepicker__calendar'][4]/header/span[1]"))
							.click();

				}
			} else if (yearDiff % 10 == 0) {
				for (int i = 1; i <= (yearDiff + 1) / 10; i++) {

					driver.findElement(By.xpath(
							"//*[@id=\"book-appointment\"]/descendant::div[@class='vdp-datepicker__calendar'][4]/header/span[1]"))
							.click();

				}

			}
			// Selecting the year from calendar
			driver.findElement(By.xpath("//span[@class='cell year' and text()='" + year + "']")).click();
			// Selecting the month from calendar
			driver.findElement(By.xpath("//span[@class='cell month' and text()='" + month + "']")).click();
			// Selecting the day from calendar
			driver.findElement(By.xpath(
					"//div[@class='vdp-datepicker']/parent::div[@class='form-group']//span[@class='cell day' and text()='"
							+ day + "']"))
					.click();
			logger.log(Status.INFO, "Select the Date Of Birth -->" + dob);
		}

	}

	// Method to select the Appointment Date
	public void selectAppointmentDate(String aptDate) {
		logger = com.GHH.utility.ExtentTestManager.getTest();
		// apt = -> "December 6, 2021";
		String[] output = aptDate.split(" ");
		String year = output[2];
		String month = output[0];
		String day = output[1].replace(",", "");
		String monthYear = month.substring(0, 3) + " " + year;
		System.out.println(output);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@type='text' and @placeholder='Select date']")));
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='Select date']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='day__month_btn']")));
		String mnthyrstxt = driver.findElement(By.xpath("//span[@class='day__month_btn']")).getText();
		System.out.println(mnthyrstxt);
		// If Given AppointmentDate is not matching the currentdate then go to the next monthYear
		 
		while (!mnthyrstxt.matches(monthYear)) {
			{
				driver.findElement(By.xpath(
						"//input[@type='text' and @placeholder='Select date']//ancestor::div[@class='vdp-datepicker']//span[@class='next']"))
						.click();
				mnthyrstxt = driver.findElement(By.xpath("//span[@class='day__month_btn']")).getText();
			}
		}
		// Select the Appointment Day from the calendar
		driver.findElement(By.xpath(
				"//div[@class='vdp-datepicker']/parent::div[@class='form-group mb-0']//span[@class='cell day' and text()='"
						+ day + "']"))
				.click();
		logger.log(Status.INFO, "Select the AppointmentDate -->" + aptDate);
	}
}
