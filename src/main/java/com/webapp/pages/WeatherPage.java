package com.webapp.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.webapp.baseLibrary.GenericWrappers;

public class WeatherPage extends GenericWrappers {
	
	public WeatherPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;

	}
	
	public WeatherPage enterCityInSearchBox(String data) {
		enterByXpath(prop.getProperty("CitySearcBox"), data);
		verifyIfitIsUncheckedAndThenSelect(data);
		return this;
	}
	
	public WeatherPage getTemp(String data) {
		String TempInDegress="//span[contains(text(), '"+data+"')]/../following-sibling::span/b[contains(text(), 'Temp in Degrees')]";
		clickByXpath("//div[text()='"+data+"']");
		String text = getTextByXpath(TempInDegress);
		verifyAPIText(data, text);
		return this;
	}
	
	
	
	

}
