package com.GHH.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tc7 {
	
public String datestamp() {
		
		
		
		Date date = new Date(System.currentTimeMillis());
        DateFormat format = new SimpleDateFormat("dd-MMM-yyyy_HHmmss");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String formattedDate = format.format(date);
        System.out.println("h1");
        return formattedDate;
}
	@Test
	public void mytest() {
		datestamp();
		System.out.println(datestamp().toString());
		String dw= ("Automation Report" + datestamp().toString());
		System.out.println(dw);
}}