package com.webapp.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webapp.baseLibrary.ProjectWrappers;
import com.webapp.pages.HomePageWeather;

public class BangaloreWeatherDetails extends ProjectWrappers{
	
	@BeforeTest
	public void preReq() {
			
			testCaseName = "Bangalore";
			testCaseDescription = "Bangalore Weather Details";
			testCaseAuthor="Harish";
			testCaseCateogeory="Regression";
			
		
	}
	
	@Test
	public void test() {
		
		new HomePageWeather(driver, test)
		.clickOnSideMenu()
		.clickOnWeather()
		.enterCityInSearchBox("Bengaluru")
		.getTemp("Bengaluru");
		
	}

}
