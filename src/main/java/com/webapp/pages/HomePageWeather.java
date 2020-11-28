package com.webapp.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.webapp.baseLibrary.GenericWrappers;

public class HomePageWeather extends GenericWrappers{

	public HomePageWeather(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;

	}
	
	public HomePageWeather clickOnSideMenu() {
		clickByXpath(prop.getProperty("NoThanks"));
		clickByXpath(prop.getProperty("SubMenu"));
		return this;
	}
	
	public WeatherPage clickOnWeather() {
		clickByXpath(prop.getProperty("WeatherButton"));
		return new WeatherPage(driver, test);
	}
	
	
}
