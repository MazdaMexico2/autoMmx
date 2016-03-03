package com.mazdausa.test.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mazdausa.test.automation.panels.Panel;

public class BasePageObject implements PageObject
{
	protected String pageUrl ;
	protected List<By> pageElements;
	protected String title;
	protected String environment;
	protected List<Panel> panels;
	
	
	/**
	 * 
	 * @return
	 */
	public List<WebElement> getAllWebElements()
	{
		List allWebElements = new ArrayList();
		
		return allWebElements;
		
	}

	/**
	 * 
	 * @return
	 */
	public String getPageUrl() {
		return pageUrl;
	}

	/**
	 * 
	 * @param pageUrl
	 */
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	/**
	 * 
	 * @return
	 */
	public List<By> getPageElements() {
		return pageElements;
	}

	/**
	 * 
	 * @param pageElements
	 */
	public void setPageElements(List<By> pageElements) {
		this.pageElements = pageElements;
	}

	public WebElement getWebElementByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement getWebElementByXPath(String xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
