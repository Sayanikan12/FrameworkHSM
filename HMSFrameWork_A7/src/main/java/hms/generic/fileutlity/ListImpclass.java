package hms.generic.fileutlity;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListImpclass implements ITestListener, ISuiteListener {

	public ExtentReports report;
	//public static ExtentSparkReporter spark;
	 
	public static ExtentTest test;
	public static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	

	public void onStart(ISuite suite) {
		System.out.println("Report configuration");  
		
		// spark report config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);

				// add environment information and create test
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "Windows-11");
				report.setSystemInfo("BROWSER", "CHROME-100");

	}

	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("=====" + result.getMethod().getMethodName() + "===START===");
		test = report.createTest(result.getMethod().getMethodName());
		//UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"====Start====");
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("=====" + result.getMethod().getMethodName() + "===END===");
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName()+"====Completed====");
		
		
	}

public void onTestFailure(ITestResult result) {
	String srcFile = result.getMethod().getMethodName();
	TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
	 String filepath = ts.getScreenshotAs(OutputType.BASE64);
	 String time = new Date().toString().replace(" ", "_").replace(":", "_");
	 test.addScreenCaptureFromBase64String(filepath, srcFile+time);
	 extentTest.get().log(Status.FAIL, result.getMethod().getMethodName()+"====Failed====");
	 
	 extentTest.get().log(Status.FAIL, result.getThrowable());
	}
	
	/*WebDriverUtility wLib=new WebDriverUtility();
	String time = new Date().toString().replace(" ", "_").replace(":", "_");
	try {
		wLib.toTakeScreenshotofPage(BaseClass.sdriver, srcFile+time);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	*/
	
	
	
}


