package com.planit.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	/*
	 * @Description : This method will load the extend report when on start
	 * 
	 * @Return : void
	 * 
	 */

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "Test-Report-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Result/" + repName);// specify location
																										// of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "ansar");

		htmlReporter.config().setDocumentTitle("planit Project");
		htmlReporter.config().setReportName("Functional Test Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	/*
	 * @Description : This method update the status of test cases as pass in extent
	 * report
	 * 
	 * @Return : void
	 * 
	 */

	public void onTestSuccess(ITestResult testResult) {
		logger = extent.createTest(testResult.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));
	}

	/*
	 * @Description : This method update the status of test cases as fail in extent
	 * report
	 * 
	 * @Return : void
	 * 
	 */

	public void onTestFailure(ITestResult testResult) {
		logger = extent.createTest(testResult.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testResult.getName() + ".png";
		File file = new File(screenshotPath);
		if (file.exists()) {
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException message) {
				message.printStackTrace();
			}
		}

	}

	/*
	 * @Description : This method update the status of test cases as skip in extent
	 * report
	 * 
	 * @Return : void
	 * 
	 */

	public void onTestSkipped(ITestResult testResult) {
		logger = extent.createTest(testResult.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName(), ExtentColor.ORANGE));
	}

	/*
	 * @Description : This method flush extent report
	 * 
	 * @Return : void
	 * 
	 */

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
