package com.webapp.baseLibrary;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ProjectWrappers extends GenericWrappers{

	
	public boolean launchMobileApp =false;
	public boolean launchOnlyMobileApp =false;
	public String appName;

	@BeforeSuite
	public void beforeSuite() {
		loadObjects();
	}
	
	@BeforeClass
	public void beforeClass() {
		startReport(testCaseName);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		startTest(testCaseName, testCaseDescription);
		invokeApp("https://www.ndtv.com/");
		}
	
	@AfterMethod
	public void afterMethod() {
		closeAllBrowsers();
		
	}
	
	@AfterClass
	public void afterClass() {
		endReport();
	}
	
	@AfterSuite
	public void afterSuite() {
		unloadObjects();
	}
	
}
