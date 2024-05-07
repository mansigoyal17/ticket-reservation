package com.tktres.utilities;

//listener class to generate extent reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tktres.pageObjects.BaseClass;

public class Reporting extends TestListenerAdapter {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // timeStamp
		String repName = "Test-Report-" + timeStamp + ".html";
		//htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);
		htmlReporter = new ExtentSparkReporter("D:/app/ticket-reservation/reports/" + repName);
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Mansi");

		htmlReporter.config().setDocumentTitle("Ticket Reservation Project");
		htmlReporter.config().setReportName("Functional Test Report");
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult tr) {

		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr) {

		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

	    try {
			String screenShotPath = captureScreen(BaseClass.driver, tr.getName());
			File f = new File(screenShotPath);
			if (f.exists()) {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenShotPath));
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public void onTestSkipped(ITestResult tr) {

		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	
public String captureScreen(WebDriver driver, String tname) throws IOException{
		
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String target = "D:/app/ticket-reservation/screenshots/"+tname+"_"+dateName+".png";
		
		File finalLocation = new File(target);
		
		FileUtils.copyFile(source, finalLocation);
		
		return target;
		
	}
}
