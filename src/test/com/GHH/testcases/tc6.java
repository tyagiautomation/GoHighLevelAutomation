package com.GHH.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tc6 {
	
	@Test
	public void test01() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://app.gohighlevel.com/");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("er.sumit193@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test123!");
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		String t1 = driver.getTitle(); 
		String logo = driver.findElement(By.xpath("//a[@class='hl_navbar--logo']/img[1]")).getText();
		
		System.out.println(logo);
		System.out.println(t1);
		driver.findElement(By.xpath("//span[normalize-space()='Scheduling']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Appointments']")).click();
		driver.findElement(By.xpath("//span[@click='closeAlert']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println("last");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='pg-appt__btn--appt-add']")));
		wait.until(ExpectedConditions.e(By.xpath("//button[@id='pg-appt__btn--appt-add']")));
		WebElement loginbtn = driver.findElement(By.xpath("//button[@id='pg-appt__btn--appt-add']"));
		js.executeScript("arguments[0].click();", loginbtn);
		js.executeScript("arguments[0].click();", loginbtn);
		
		
		WebElement drop1 = driver.findElement(By.name("slot"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("slot")));
		Select s = new Select(drop1);	System.out.println("last1");
		
		s.selectByVisibleText("10:30 am");
		System.out.println("last");
		
	WebElement timeZone =	driver.findElement(By.xpath("//select[@name='timezone']"));
	//timeZone.click();
	Select selectTimeZone = new Select(timeZone);
	selectTimeZone.selectByValue("Australia/Canberra");
	
	driver.findElement(By.xpath("//input[@name='appointmentTitle']")).sendKeys("Title1");
	
	//input[@name='customerName']
	driver.findElement(By.xpath("//input[@name='customerName']")).sendKeys("Contact1");
	//input[@name='msgsndr_email']
	driver.findElement(By.xpath("//input[@name='msgsndr_email']")).sendKeys("email@yopmail.com");
	//input[@name='msgsndr_phone']
	driver.findElement(By.xpath("//input[@name='msgsndr_phone']")).sendKeys("9911001100");
	//textarea[@placeholder='Notes']
	driver.findElement(By.xpath("//textarea[@placeholder='Notes']")).sendKeys("Note1");
	
	
	//button[@data-id='cmp-apt-modal__sel--apt-status']
	driver.findElement(By.xpath("//button[@data-id='cmp-apt-modal__sel--apt-status']")).click();
	//button[@data-id='cmp-apt-modal__sel--apt-status']//following-sibling::div//descendant::span[text()='Confirmed']
	driver.findElement(By.xpath("//button[@data-id='cmp-apt-modal__sel--apt-status']//following-sibling::div//descendant::span[text()='Confirmed']")).click();
	
	driver.findElement(By.xpath("//input[@name='msgsndr_address']")).sendKeys("War Room");
	
	driver.findElement(By.xpath("//button[@data-id='cmp-apt-modal__sel--status']")).click();
	driver.findElement(By.xpath("//button[@data-id='cmp-apt-modal__sel--status']//following-sibling::div//descendant::span[text()='Free']")).click();
	
	//button[@data-id='cmp-apt-modal__sel--status']//following-sibling::div//descendant::span[text()='Free']
	
	
		
}}