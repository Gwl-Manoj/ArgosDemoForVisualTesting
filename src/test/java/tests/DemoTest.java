package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.ReportLoger;
import utils.WebDriverBase;
import utils.WebDriverBase.ElementType;

public class DemoTest 
{
	
	// This line used to create object for driver base class
		WebDriverBase webDB = new WebDriverBase();
		static ReportLoger log = new ReportLoger();
		boolean flag;
		// This line used to create object for commonFunction class
		static commonFunctions.CommonFunctions commonFunction = new commonFunctions.CommonFunctions();
		
		
		/**
		 * This method used to open browser before test start
		 */
		@BeforeTest
		public void browser_Setup() throws FileNotFoundException, IOException, Exception {
			webDB.Setup(System.getProperty("Platform"));
			
				
//			commonFunction.setBrowserResolution(390, 844); // For mobile view
			commonFunction.setBrowserResolution(1600, 1200); // For tablet view
		}
		
		/**
		 * This method used to perform customer login
		 */
		@BeforeMethod
		public void customer_Login() throws InterruptedException
		{
			// This line used to get data from config properties
			String PageUrl = webDB.getDataFromProperties("url");
			// This line used to navigate the url in browser
			webDB.enterURL(PageUrl);
			Thread.sleep(2000);
			webDB.clickAnElement("//a[@id='wt-cli-accept-btn']", ElementType.Xpath);
			Thread.sleep(1500);

		}

		@Test(description = "Captured full page screenshot")
		public void check_AutoDoc_H1Heading() throws InterruptedException
		{
			commonFunction.capturescreenshot();
		}
		
		@AfterTest
		public void browser_Close()
		{
			webDB.tearDown();
		}

}
