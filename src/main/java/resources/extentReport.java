package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	
	public static ExtentReports getTestReport() 
	{		
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Result");
	//to keep the documented name 
	reporter.config().setDocumentTitle("Test Results");
	
	//this is responsible for bringing all the test results
	ExtentReports extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Anmol Tiwary");
	return extent;
	
}

}
