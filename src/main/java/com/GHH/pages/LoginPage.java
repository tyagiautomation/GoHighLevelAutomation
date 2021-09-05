package com.GHH.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import com.GHH.base.baseClass;

@Listeners(com.GHH.base.TestListners.class)
public class LoginPage extends baseClass {

	// PageFactory or ObjectReposiotry(OR:)
	@FindBy(xpath = "//input[@id='email']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	WebElement signIn_Btn;

	@FindBy(id = "forgotPasswordLink")
	WebElement forgotPasswordBtn;

	@FindBy(id = "//span[@class='error']")
	WebElement errorCode;

	// public WebDriverWait wait = new WebDriverWait(driver, 30);
	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	// Method to perform the Login operation
	public HomePage login(String un, String pwd) {
		// driver.navigate().refresh();
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		signIn_Btn.click();

		String errorMessage = driver.findElement(By.xpath("//span[@class='error']")).getText();
		// signIn_Btn.submit();
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", signIn_Btn);

		return new HomePage();
	}

	// Method to verify the Error Message
	public String VerifyErrorMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='error']")));
		String errorMessage = driver.findElement(By.xpath("//span[@class='error']")).getText();
		System.out.println(errorMessage);
		return errorMessage;
	}

}
