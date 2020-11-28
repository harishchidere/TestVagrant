package com.webapp.baseLibrary;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.webapp.utilities.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenericWrappers extends Reporter {
	
	public RemoteWebDriver driver;
	
	public static Properties prop;
	
	/*
	 * public GenericWrappers(){ loadObjects(); cprop = new Properties(); try {
	 * cprop.load(new FileInputStream(new
	 * File("./src/test/java/config/Config.properties")));
	 * env=cprop.getProperty("Execution_Env"); System.out.println(env);
	 * if(env.equalsIgnoreCase("live")) { sUrl = cprop.getProperty("Live_Url");
	 * }else if(env.equalsIgnoreCase("dev")) { sUrl = cprop.getProperty("Dev_Url");
	 * }else if(env.equalsIgnoreCase("test")) { sUrl =
	 * cprop.getProperty("Test_Url"); } System.out.println(sUrl); sHubUrl =
	 * cprop.getProperty("HubUrl"); sHubPort = cprop.getProperty("HubPort");
	 * 
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * 
	 * } }
	 */
	public void loadObjects(){
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/test/java/object.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	public void unloadObjects(){
		prop=null;
	}
	
	
	
	
	public void invokeApp(String url) {
	try {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			logStatus("The given URL '" + url + "' is launched in '" + "Chrome" + "' browser successfully.", "pass", true);
		} catch (TimeoutException e) {
			logStatus("The specified time got expired. Unable to launch the URL with all webelements.", "fail", false);
		} catch (WebDriverException e) {
			logStatus("The given URL '" + url + "' is not launched in '" + "Chrome" + "' browser successfully.", "fail", false);
		}
	}
	
		
	public void enterByXpath(String xpathValue, String data) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathValue)));
			driver.findElementByXPath(xpathValue).sendKeys(data);
			logStatus("The webelement with the XPATH: '" + xpathValue
					+ "' is identified and entered with the data '" + data + "' successfully.", "pass", true);
		} catch (NoSuchElementException e) {
			logStatus("The webelement with the XPATH: '" + xpathValue + "' is not found.", "fail", true);
		} catch (ElementNotVisibleException e) {
			logStatus("The webelement with the XPATH: '" + xpathValue + "' is not visible.", "fail", true);
		} catch (ElementNotInteractableException e) {
			logStatus("The webelement with the XPATH '" + xpathValue + "' is not enabled.", "fail", true);
		} catch (WebDriverException e) {
			logStatus("The application got crashed for unknown error.", "fail", false);
		}
	}
	
	
	public void clickByXpath(String xpathVal) {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathVal)));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			driver.findElementByXPath(xpathVal).click();
			logStatus("The webelement with the XPATH: '" + xpathVal + "' is identified and clicked successfully.", "pass", true);
		} catch (NoSuchElementException e) {
			logStatus("The webelement with the XPATH: '" + xpathVal + "' is not found.", "fail", true);
		} catch (ElementNotVisibleException e) {
			logStatus("The webelement with the XPATH: '" + xpathVal + "' is not visible.", "fail", true);
		} catch (ElementNotInteractableException e) {
			logStatus("The webelement with the XPATH: '" + xpathVal + "' is not enabled.", "fail", true);
		} catch (WebDriverException e) {
			logStatus("The application got crashed for unknown error.", "fail", false);
		} 
		
	}
	
	public void verifyIfitIsUncheckedAndThenSelect(String cityName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='"+cityName+"']/input")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='"+cityName+"']/input")));
			String text = driver.findElementByXPath("//label[@for='"+cityName+"']/input").getAttribute("checked");
			System.out.println(text);
			if(text.equalsIgnoreCase("true")) {
				
			}else {
				driver.findElementByXPath("//label[@for='"+cityName+"']/input").click();
			}
			logStatus("The webelement with the XPATH: '" + "//label[@for='"+cityName+"']/input" + "' is identified and clicked successfully.", "pass", true);
		} catch (NoSuchElementException e) {
			logStatus("The webelement with the XPATH: '" + "//label[@for='"+cityName+"']/input" + "' is not found.", "fail", true);
		} catch (ElementNotVisibleException e) {
			logStatus("The webelement with the XPATH: '" + "//label[@for='"+cityName+"']/input" + "' is not visible.", "fail", true);
		} catch (ElementNotInteractableException e) {
			logStatus("The webelement with the XPATH: '" + "//label[@for='"+cityName+"']/input" + "' is not enabled.", "fail", true);
		} catch (WebDriverException e) {
			logStatus("The application got crashed for unknown error.", "fail", false);
		} 
		
	}
	
	
	public String getTextByXpath(String xpath) {
		String strTextAct=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			strTextAct = driver.findElementByXPath(xpath).getText().trim().replaceAll("[\r\n]+", " ");
			
				logStatus("Able to get Text from UI '" + strTextAct + "' from the XPATH: '" + xpath
						+ ".", "pass", true);
				System.out.println("Expected Text :-"+strTextAct);
			
		} catch (NoSuchElementException e) {
			logStatus("The webelement with the XPATH: '" + xpath + "' is not found.", "fail", true);
		} catch (ElementNotVisibleException e) {
			logStatus("The webelement with the XPATH: '" + xpath + "' is not visible.", "fail", true);
		} catch (WebDriverException e) {
			logStatus("The application got crashed for unknown error.", "fail", false);
		} 
		return strTextAct;
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String strTextAct = driver.findElementByXPath(xpath).getText().trim().replaceAll("[\r\n]+", " ");
			if (strTextAct.contains(text)) {
				logStatus("The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath
						+ "' partially matches with the Expected Text '" + text + "'.", "pass", true);
			} else {
				logStatus("The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath
						+ "' doesn't partially matches with the Expected Text '" + text + "'.", "fail", true);
			}
		} catch (NoSuchElementException e) {
			logStatus("The webelement with the XPATH: '" + xpath + "' is not found.", "fail", true);
		} catch (ElementNotVisibleException e) {
			logStatus("The webelement with the XPATH: '" + xpath + "' is not visible.", "fail", true);
		} catch (WebDriverException e) {
			logStatus("The application got crashed for unknown error.", "fail", false);
		} 
	}

	
		
	public long takeSnap() {
		
		long snapNumber = 100000l;
		
		
		try {			
			 snapNumber = (long) Math.floor(Math.random()*1000000+100000l);
			 File tmpFile = driver.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./reports/screenshot/image"+snapNumber+".jpg");
			FileUtils.copyFile(tmpFile, destFile);
			
		}  catch (IOException e) {
			System.err.println("IOException");
		} catch (Exception e) {
			System.err.println("Exception");
		}
		
		
		return snapNumber;
	}

	
	
	
	
	public void closeBrowser() {
		try {
			driver.close();
			//logStatus("The active browser is closed successully.", "pass", false);
		} catch (WebDriverException e) {
			logStatus("The application got crashed for unknown error.", "fail", false);
		} 
	}

	public void closeAllBrowsers() {
		try {
			
				driver.quit();
				logStatus("All the browsers are closed successully.", "pass", false);
		} catch (Exception e) {
			logStatus("The application got crashed for unknown error.", "fail", false);
		} 
	}


		
	public void verifyMultpleTextByXpath(String xpath, List<String> text) {
		String strTextAct = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElementsByXPath(xpath)));
			List<WebElement> webelemnt = driver.findElementsByXPath(xpath);
			int i=0;
			for(WebElement ele : webelemnt) {
				
				strTextAct=ele.getText().trim().replaceAll("[\r\n]+", " ");
			if (strTextAct.equals(text.get(i))) {
				logStatus("The Actual Text '" + strTextAct + "' from the ID: '" + xpath
						+ "' matches with the Expected Text '" + text.get(i) + "'.", "pass", true);
				System.out.println("ActualText :-"+text.get(i)+" and Expected Text :-"+strTextAct);
			} else {
				logStatus("The Actual Text '" + strTextAct + "' from the ID: '" + xpath
						+ "' doesn't matches with the Expected Text '" + text.get(i) + "'.", "fail", true);
				System.out.println("ActualText :-"+text.get(i)+" and Expected Text :-"+strTextAct);
			}
			i++;
			}
		} catch (NoSuchElementException e) {
			logStatus("The webelement with the ID: '" + xpath + "' is not found.", "fail", true);
		} catch (ElementNotVisibleException e) {
			logStatus("The webelement with the ID '" + xpath + "' is not visible.", "fail", true);
		} catch (WebDriverException e) {
			logStatus("The application got crashed for unknown error.", "fail", false);
		} 
	}
	
	
	
	
	public List<String> convertIntoList(String text, String split) {
		List<String> list = null;
		
		try {
			list = new ArrayList<String>();
			String[] a = text.split(split);
			
			for (String string : a) {
				list.add(string);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public String getTempFromAPI(String cityName) {
		String temp=null;
		try {
		
		RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
		
		RequestSpecification requestSpecification = RestAssured.given().request();
		requestSpecification.queryParameters("q", cityName);
		requestSpecification.queryParameters("appid", "7fe67bf08c80ded756e598d6f8fedaea");
		Response resp = requestSpecification.get();
	
		resp.prettyPrint();
		
		JSONObject obj = new JSONObject(resp.asString());
		
		
		Map<String, Object> map = JsonFlattener.flattenAsMap(obj.toString());
		System.out.println(map);
		temp = map.get("main.temp").toString();
	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
		}
	
	public void verifyAPIText(String cityName, String degree) {
		
		String[] str = degree.split(":");
		String actD = str[1].trim();
		
		String a = getTempFromAPI(cityName);
		float b = (float) (Float.parseFloat(actD) + 273.15);
		if(b==Float.parseFloat(a)) {
			logStatus("Expected And"+b+" Actual Text"+a+" are matching", "pass", true);
		}else {
			logStatus("Expected And"+b+" Actual Text"+a+" are not matching", "pass", true);
		}
	}
	
		
}
