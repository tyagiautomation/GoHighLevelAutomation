package com.GHH.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.GHH.base.baseClass;




public class getScreenShot extends baseClass{
	 static String destination;
	public static String takeScreenshotAtEndOfTest()  {
//		 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String currentDir = System.getProperty("user.dir");
//		
//		try {
//			FileUtils.copyFile(scrFile, new File(currentDir + ".//screenshots/" + System.currentTimeMillis() + ".png"));
//			//FileUtils.copyFile(scrFile, new File(".//screenshots//homePageScreenshot.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  destination = System.getProperty("user.dir") + "/screenshots/"+ "screenShot_" +TestUtil.datestamp().toString()+".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destination;
	}

	

	

}
