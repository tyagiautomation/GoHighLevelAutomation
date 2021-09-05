package com.GHH.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tc04 {
	
	@Test
	public void test01() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
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
		Thread.sleep(2000);	System.out.println("last");
		WebElement loginbtn = driver.findElement(By.xpath("//button[@id='pg-appt__btn--appt-add']"));
		js.executeScript("arguments[0].click();", loginbtn);
		js.executeScript("arguments[0].click();", loginbtn);
		Thread.sleep(2000);
		WebElement drop1 = driver.findElement(By.name("slot"));
		Thread.sleep(2000);
		Select s = new Select(drop1);	System.out.println("last1");
		s.selectByVisibleText("10:30 am");
		System.out.println("last");
		
		String dateTime ="1993-10-9";
		String[] output = dateTime.split("-");
		String year = output[0];
		String month = output[1];
		String day = output[2];
		String[] day1 = day.split("");
		
		Object months[] = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December"};
		System.out.println(months[Integer.parseInt(month)+1]);
		
		
		driver.findElement(By.xpath("//input[@name='dateOfBirth']")).click();
		
		String yr =driver.findElement(By.xpath("//*[@id=\"book-appointment\"]/descendant::div[@class='vdp-datepicker__calendar'][4]/header/span[2]")).getText();
		System.out.println(yr.substring(0, 4));
		
		int yearDiff = Integer.parseInt(yr.substring(0, 4))-Integer.parseInt(year);
		System.out.println(yearDiff);
		
		//if (givenyr less than current year)
		//{ --yeardifference %10==0 }else +1{
//	}
	// if()
		
		

		//if(yearDiff>=9){
        if(yearDiff<=0){
        	 
        	
                 System.out.println("Greater Year Diff->");

                 driver.findElement(By.xpath("//*[@id=\"book-appointment\"]/descendant::div[@class='vdp-datepicker__calendar'][4]/header/span[1]")).click();
                 yr =driver.findElement(By.xpath("//*[@id=\"book-appointment\"]/descendant::div[@class='vdp-datepicker__calendar'][4]/header/span[2]")).getText();  
                 yearDiff = Integer.parseInt(yr.substring(0, 4))-Integer.parseInt(year);
        	
        	
        	
        }
            
             if(yearDiff<0){
            	//next button
            	

                    System.out.println("Less Year Diff->");

                    driver.findElement(By.xpath("//*[@id=\"book-appointment\"]/descendant::div[@class='vdp-datepicker__calendar'][4]/header/span[3]")).click();
                    yr =driver.findElement(By.xpath("//*[@id=\"book-appointment\"]/descendant::div[@class='vdp-datepicker__calendar'][4]/header/span[2]")).getText();
                    yearDiff = Integer.parseInt(yr.substring(0, 4))-Integer.parseInt(year);
            	}
            	
             else {
            	 System.out.println("sum");
             }
            	
                
	//	}


		driver.findElement(By.xpath("//span[@class='cell year' and text()='"+year+"']")).click();
		driver.findElement(By.xpath("//span[@class='cell month' and text()='"+(months[Integer.parseInt(month)+1])+"']")).click();
		driver.findElement(By.xpath("//div[@class='vdp-datepicker']/parent::div[@class='form-group']//span[@class='cell day' and text()='"+day+"']")).click();

}
}