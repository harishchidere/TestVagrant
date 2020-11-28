package com.webapp.utilities;

import java.io.IOException;

import org.openqa.selenium.OutputType;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporter {

	public static ExtentHtmlReporter extent;
	public static ExtentReports report;
	public ExtentTest test, suiteTest;
	public String testCaseName, testCaseDescription, testCaseAuthor, testCaseCateogeory;
	
	public void startReport(String TCName){
		String reportName = TCName+"_"+System.currentTimeMillis();
		extent = new ExtentHtmlReporter("./ExecutionReports/"+TCName+"/"+reportName+".html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	public void startTest(String testName, String description){
		
		suiteTest = report.createTest(testName, description);
		test = 	suiteTest.createNode(testName);
		test.assignAuthor(testCaseAuthor);
		test.assignCategory(testCaseCateogeory);
	}
	
	public void logStatus(String desc, String status, boolean flag){
		
		if(flag){
		
			long number = takeSnap();
			
			try {
				if(status.equalsIgnoreCase("pass")){
					test.log(Status.PASS, desc, MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/reports/screenshot/image"+number+".jpg").build());
				}else if(status.equalsIgnoreCase("fail")){
					test.log(Status.FAIL, desc, MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/reports/screenshot/image"+number+".jpg").build());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
			
		}else{
			if(status.equalsIgnoreCase("pass")){
				test.log(Status.PASS, desc);
			}else if(status.equalsIgnoreCase("fail")){
				test.log(Status.FAIL, desc);	
			}
		}
		
	}
	
	

	public void endReport(){
		report.flush();
	}
	
	
	public abstract long takeSnap();
		
	
}