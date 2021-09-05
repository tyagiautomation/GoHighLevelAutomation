package com.GHH.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GHH.utility.Xls_Reader;

public class tc03 {
	Xls_Reader excelReader;

	
	  @DataProvider(name="getAppointmentData2") 
	  public Object[][] getAppointmentData1() {
			
			//excelReader.path ="./testData/collectionrunner.xls";
			
			Object data[][] = excelReader.getTestData("sheet1");
			return data;
			
		}
	  
	  
	  
	  @Test(dataProvider = "getAppointmentData2") 
	  public void verifyAddEmp2(String Day, String DOB) 
	  { System.out.println("a2"); System.out.println("s1");
	  String[] output = DOB.split(" ");
		String year = output[2];
		System.out.println(year);
		String month = output[0];
		System.out.println(month);
		String day = output[1].replace(",", "");
		System.out.println(day);
	  System.out.println(Day); System.out.println("s2"); System.out.println(DOB);
	 
	  
	  
	  }
	 
	
}
