package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import util.ExtentReporter;
import util.Utilities;

public class MyListeners implements ITestListener
{
	
	ExtentReports report;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		
		//System.out.println(result.getName()+"test has started execution");
		
	 extentTest = report.createTest(result.getName());
	 extentTest.log(Status.INFO, result.getName()+"test execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		//System.out.println(result.getName()+"test has passed");
		
		extentTest.log(Status.PASS, result.getName() +"test got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	//	System.out.println(result.getName()+"test has failed");
		
		extentTest.log(Status.FAIL, result.getName()+"test got failed");
		WebDriver driver=null;
		try {
		  driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String screenshotFilePath = Utilities.takesScreenShot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(screenshotFilePath);
		extentTest.log(Status.INFO, result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		//System.out.println(result.getName()+"test has skipped");
		extentTest.log(Status.SKIP, result.getName()+"test got skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		
	//	System.out.println("Test Execution of all tests has started");
		
	 report = ExtentReporter.getExtentReport();
	 
	}

	@Override
	public void onFinish(ITestContext context) {
		
		//System.out.println("Test Execution of all tests has ended ");
		report.flush();
		String extentReportPath = System.getProperty("user.dir")+"\\target\\reports\\TNExtentReport.html";
	    File extentReportFile=new File(extentReportPath);
	    try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
