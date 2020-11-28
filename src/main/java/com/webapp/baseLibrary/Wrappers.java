package com.webapp.baseLibrary;


public interface Wrappers {
	
	/**
	 * This method will launch the given browser and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author - Harish Chidere   
	 * @param browser - The browser of the application to be launched
	 * @param url - The url with http or https
	 * @param boolean - Pass it as true to run testcases in remote machine
	 * @throws Exception 
	 * 
	 */
	public void invokeApp(String browser,String url, boolean bRemote);

	/**
	 * This method will enter the value to the text field using xpath attribute to locate
	 * 
	 * @param id - idvalue of the webelement
	 * @param value - The data to be sent to the webelement
	 * @author - Harish Chidere   
	 * @throws Exception 
	 */
	public void enterById(String idValue, String data);
	
	/**
	 * This method will enter the value to the text field using xpath attribute to locate
	 * 
	 * @param name - namevalue of the webelement
	 * @param value - The data to be sent to the webelement
	 * @author - Harish Chidere   
	 * @throws Exception 
	 */
	public void enterByName(String nameValue, String data);
	
	/**
	 * This method will enter the value to the text field using xpath attribute to locate
	 * 
	 * @param xpathValue - xpathValue of the webelement
	 * @param value - The data to be sent to the webelement
	 * @author - Harish Chidere   
	 * @throws Exception 
	 */
	public void enterByXpath(String xpathValue, String value);

	/**
	 * This method will click the element using xpath as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author - Harish Chidere   
	 * @throws Exception 
	 */
	public void clickById(String idVal);
	
	/**
	 * This method will click the element using xpath as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author - Harish Chidere   
	 * @throws Exception 
	 */
	public void clickByName(String nameVal);
	
	
	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author - Harish Chidere   
	 * @throws Exception 
	 */
	public void clickByXpath(String xpathVal);
	
	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author - Harish Chidere   
	 * @throws Exception 
	 */
	public void clickByXpathNoSnap(String xpathVal);
	
	/**
	 * This method will select the drop down visible text using id as locator
	 * @param id - The id (locator) of the drop down element
	 * @param Value - The value to be selected (Visible Text) from the dropdown  
	 * @author - Harish Chidere   
	 * @throws Exception 
	 */
	public void selectVisibleTextById(String idVal, String value);
	
	/**
	 * This method will select the drop down visible text using id as locator
	 * @param name - The name (locator) of the drop down element
	 * @param Value - The value to be selected (Visible Text) from the dropdown  
	 * @author - Harish Chidere   
	 * @throws Exception 
	 */
	public void selectVisibleTextByName(String nameVal, String value);
	
	/**
	 * This method will select the drop down visible text using id as locator
	 * @param xpath - The XPath (locator) of the drop down element
	 * @param Value - The value to be selected (Visible Text) from the dropdown  
	 * @author - Harish Chidere   
	 * @throws Exception 
	 */
	public void selectVisibleTextByXpath(String xpath, String value);
	
	/**
	 * This method will perform mouse hover action on the element using Xpath as Locator
	 * @param - ID - The idVal(locator) of the element
	 * @author - Harish Chidere   
	 * @return 
	 * @throws Exception 
	 */
	public void mouseHoverById( String idVal);
	
	/**
	 * This method will perform mouse hover action on the element using Xpath as Locator
	 * @param - Name - The nameVal(locator) of the element
	 * @author - Harish Chidere   
	 * @return 
	 * @throws Exception 
	 */
	public void mouseHoverByName( String nameVal);
	

	/**
	 * This method will perform mouse hover action on the element using Xpath as Locator
	 * @param - Xpath - The Xpath(locator) of the element
	 * @author - Harish Chidere   
	 * @return 
	 * @throws Exception 
	 */
	public void mouseHoverByXpath( String xpathValue);
	
	/**
	 * This method will upload files using Xpat as the Locator
	 * @param - Xpath - Xpath of the Upload file button
	 * @param - path - path of the image
	 * @author - Harish Chidere   
	 * @return 
	 * @throws Exception 
	 */
	public void uploadFileByXpath(String Xpath,String Path);

	/**
	 * This method will perform keyboard actions like tab, pagedown, pageup.
	 * @param Keyword - action to be perform(TAB, PAGE DOWN)
	 * @param Xpath - The Xpath is the locator of an element
	 * @author - Harish Chidere   
	 * @return 
	 * @throws Exception 
	 */
	public void keyBoardActionByXpath(String keyword, String xpathValue);

	
	
	/**
	 * This method will switch to the parent Window
	 * @author - Harish Chidere   
	 */
	public void switchToParentWindow();
	
	/**
	 * This method will move the control to the last window
	 * @author - Harish Chidere   
	 */
	public void switchToLastWindow();
	
	/**
	 * This method will move the control to the required window based on user input
	 * @author - Harish Chidere   
	 */
	public void switchToCustomWindow(int windowNumber);
	

	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author - Harish Chidere   
	 */
	public void verifyTitle(String title);
	
	/**
	 * This method will verify the given text from an Alert
	 * @param text  - The text to be verified
	 * @author - Harish Chidere   
	 */
	public void verifyAlertText(String text);
	
	/**
	 * This method will verify the given text with exact match
	 * @param xpath - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author - Harish Chidere   
	 */
	public void verifyTextByXpath(String xpath, String text);
	
	/**
	 * This method will verify the given text with partial match
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author - Harish Chidere   
	 */
	public void verifyTextContainsByXpath(String xpath, String text);


	

	/**
	 * This method will get the text of the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element 
	 * @author - Harish Chidere   
	 */
	public String getTextFromUi(String locator);

	
	/**
	 * This method will accept the alert opened
	 * @author - Harish Chidere   
	 */
	public void acceptAlert();
	
	/**
	 * This method will dismiss the alert opened
	 * @author - Harish Chidere   
	 */
	public void dismissAlert();
	
	/**
	 * This method will return the text of the alert
	 * @author - Harish Chidere   
	 */
	public String getAlertText();
	
	/**
	 * This method will take snapshot of the ui page
	 * @author - Harish Chidere   
	 *//*
	public long takeSnap();*/
		
	/**
	 * This method will close the active browser
	 * @author - Harish Chidere   
	 */
	public void closeBrowser();
	
	
	/**
	 * This method will close all the browsers
	 * @author - Harish Chidere   
	 */
	public void closeAllBrowsers();
	/**
	 * This method will clear the value from the text field using xpath attribute to locate
	 * 
	 * @param xpahValue - xpath of the webelement
	 * @author - Harish Chidere    
	 * @return 
	 * @throws Exception 
	 */
	public void clearByXpath(String name);

	
	
}
