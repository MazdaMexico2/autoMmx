package com.mazdausa.test.util;

import java.io.InputStream;
import java.util.Properties;
import java.util.StringTokenizer;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


public class TestUtil 
{
	public Properties configProperties ;
	
	/**
	 * Get the default Configuration Properties
	 * @return
	 */
	public Properties getConfigProperties()
	{
		return configProperties;
	}
	
	/**
	 * Read a specified configuration file into a Properties object.  
	 * 
	 * @param configName
	 * @return Properties
	 * @throws IOException 
	 */

	public Properties getConfigProperties(String configName)
	{
		Properties configProps = new Properties();
		
		InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream(configName);
		
		try 
		{
			configProps.load(in);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.configProperties = configProps;

		return configProps;
	}
	
	/**
	 * Tokenizes a pipe-delimited String of property values. 
	 * Each String token is added to the returned List .
	 * 
	 * @param propertyName
	 * @return List<String>
	 */
	public List<String> getStringTokens(String propertyName)
	{
		String delimitedTokens = this.configProperties.getProperty(propertyName);
		StringTokenizer tokenizer = new StringTokenizer(delimitedTokens);
		List<String> tokensList = new ArrayList<String>();
		
		String token = null;
		while(tokenizer.hasMoreTokens())
		{
			token = tokenizer.nextToken("|");
			tokensList.add(token);
		}
		
		return tokensList;
	}
	
	
	
	//IMAGES

	public void imagePresentXpath(WebDriver driver, String xpath, String testValue, String message){
		WebElement image1 = driver.findElement(By.xpath(xpath));
		String path = image1.getAttribute("src");
		Assert.assertEquals(path, testValue);
		System.out.println(message);
	}

	public void imagePresentClass(WebDriver driver, String className, Object object, String message){
		WebElement image1 = driver.findElement(By.className(className));
		String path = image1.getAttribute("src");
		Assert.assertEquals(path, object);
		System.out.println(message);
	}
	

	// TEST LINK BROKEN	


	private String isLinkBroken(URL url) throws Exception

	{
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try
		{
			connection.connect();
			response = connection.getResponseMessage();	        
			connection.disconnect();
			return response;
		}
		catch(Exception exp)
		{
			return exp.getMessage();
		}  				
	}
	public void brokenLink(WebDriver driver){
		List<WebElement> elementList = new ArrayList<WebElement>();
		elementList = driver.findElements(By.tagName("a"));
		List<WebElement> finalList = new ArrayList<WebElement>(); ;
		for (WebElement element : elementList)
		{
			if(element.getAttribute("href") != null)
			{
				finalList.add(element);
			}		  
		}	
		for( WebElement element : finalList){
			try
			{
				System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
			}
			catch(Exception exp)
			{
				System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());	    		
			}
		}
	}


	// TEXT AND CONTENT

	//Find By Xpath

	public void textPresentXpath(WebDriver driver, String expected , String xpath) throws InterruptedException{
		final WebDriverException exception = new WebDriverException();
		try{
			if(driver.findElement(By.xpath(xpath)).getText().equals(expected)){
				System.out.println(expected +" ----Text is on  this page");
			}
			else{ 
				System.out.println(expected +" ----Text is NOT on  this page");
				throw new WebDriverException(exception.getMessage());
			}
		}
		catch (WebDriverException e) {
			throw new WebDriverException(e.getMessage());	
		}	
	}

	//	Find by Class
	
	public void textPresentClass(WebDriver driver, String expected , String className) throws InterruptedException{
		final WebDriverException exception = new WebDriverException();
		try{
			if(driver.findElement(By.className(className)).getText().equals(expected)){
				System.out.println(expected +" ----Text is on  this page");
			}
			else{ 
				System.out.println(expected +" ----Text is NOT on  this page");
				throw new WebDriverException(exception.getMessage());
			}
		}
		catch (WebDriverException e) {
			throw new WebDriverException(e.getMessage());	
		}	
	}

	// TIME 	

	

	public boolean waitForElementPresent(By how, WebDriver driver, int waitTime ) throws InterruptedException{

		for(int i=0; i < waitTime; i++) {
			if (!elementPresent(how,driver))
				Thread.sleep(1000);
			else
				return true;
		}
		return false;
	}

	// Take a Screenshot
	
	public void TakeScreenshot(WebDriver driver , String path) throws IOException{
	driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile, new File(path));
	}

	// Types of CLICK


	public void doubleClickElement(String text, WebDriver driver) {
		List<WebElement> options = driver.findElements(By.tagName("nobr"));
		for (WebElement temp : options) {
			if (temp.getText().equals(text)){
				temp.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", temp);
				break;
			}
		}
	}

	public void doubleClickElementSpan(String text, WebDriver driver) {
		List<WebElement> options = driver.findElements(By.tagName("span"));
		for (WebElement temp : options) {
			if (temp.getText().equals(text)){
				temp.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", temp);
				break;
			}
		}
	}

	public void doubleClickElementTD(String text, WebDriver driver) {
		List<WebElement> options = driver.findElements(By.tagName("td"));
		for (WebElement temp : options) {

			if (temp.getText().equals(text)){

				temp.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", temp);

				break;
			}
		}
	}

	public void highlightElement(String text, WebDriver driver) {
		List<WebElement> options = driver.findElements(By.tagName("nobr"));
		for (WebElement temp : options) {

			if (temp.getText().equals(text)){

				temp.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", temp);

				break;
			}
		}

	}

	public void highlightElementTD(String text, WebDriver driver) {
		List<WebElement> options = driver.findElements(By.tagName("td"));
		for (WebElement temp : options) {

			if (temp.getText().equals(text)){

				temp.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", temp);

				break;
			}
		}

	}

	public void highlightElementSpan(String text, WebDriver driver) {
		List<WebElement> options = driver.findElements(By.tagName("span"));
		for (WebElement temp : options) {

			if (temp.getText().equals(text)){

				temp.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", temp);

				break;
			}
		}

	}

	public void highlightElementOption(String text, WebDriver driver) {
		List<WebElement> options = driver.findElements(By.tagName("option"));
		for (WebElement temp : options) {

			if (temp.getText().equals(text)){

				temp.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", temp);

				break;
			}
		}

	}
	public void clickElement(String xpath, WebDriver driver) {
		WebElement options = driver.findElement(By.xpath(xpath));
		//options.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", options);

	}	

	public boolean searchElement(String text, String tag,  WebDriver driver) throws Exception {
		boolean returnable = false;
		List<WebElement> options = driver.findElements(By.tagName(tag));
		for(WebElement temp: options) {
			if (temp.getText().equals(text)){
				returnable = true;
				break;
			}
		}

		if (returnable == false) {
			throw new Exception("Text: "+text+" could not be found" );
		}
		return returnable;
	}


	public boolean elementPresent(By how, WebDriver driver) 
	{
		try {  
			driver.findElement(how);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	
}
