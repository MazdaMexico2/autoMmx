package com.mazdausa.test.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseWebObject
{
	protected WebDriver driver;
	protected WebElement webElement;
	protected List<WebElement> allWebElements;

	/** Constructor. */
	public BaseWebObject()
	{
	}

	/** Constructor. */
	public BaseWebObject(WebDriver driver)
	{
		this.setWebDriver(driver);
	}	
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public WebElement getWebElementByName(String name) 
	{
		WebElement element = driver.findElement(By.name(name));
		
		return element;
	}

	/**
	 * 
	 * @param xpath
	 * @return
	 */
	public WebElement getWebElementByXPath(String xpath) 
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		
		return element;
	}
	
	/**
	 * 
	 * @return
	 */
	public WebDriver getDriver()
	{
		return driver;
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void setWebDriver(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement getWebElement() {
		return webElement;
	}

	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}
	
}
