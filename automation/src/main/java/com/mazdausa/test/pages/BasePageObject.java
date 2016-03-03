package com.mazdausa.test.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mazdausa.test.automation.BaseWebObject;
import com.mazdausa.test.automation.panels.Panel;

public class BasePageObject extends BaseWebObject 
{
	protected String pageUrl ;
	protected List<By> pageElements;
	protected String title;
	protected String environment;
	protected List<Panel> panels;
	
	/** Constructor. */
	public BasePageObject() 
	{
	}	
	
	/** Constructor. */
	public BasePageObject(WebDriver driver) 
	{
		super(driver);
	}
	
	/** Constructor. */
	public BasePageObject(WebDriver driver, String pageUrl) 
	{
		super(driver);
		this.setPageUrl(pageUrl);
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

}
