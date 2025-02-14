package co.morsum.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import co.morsum.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String screenshotPath;	
	public static String screenshotname;
	public static void captureScreenshot() throws IOException {
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotname = d.toString().replace(":", "_").replace(" ", "_")+".png";
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/target/surefire-reports/html/"+screenshotname));
		
		
	}
	
	public static boolean isTestRunnable(String testName, ExcelReader excel) {
		
		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);
		
		for(int rNum=2; rNum<=rows;rNum++) {
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			if(testCase.equalsIgnoreCase(testName)) {
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				
				if(runmode.equalsIgnoreCase("Y")) 
					
			     return true;
				
				 else 
					 
			     return false;
					
				}
				
			}
		
		return false;	
	}
		
		
		
		
		
}
	
	
