package com.mazdausa.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject 
{
	private final WebDriver driver;
	private String pageUrlProd ;
	private String pageUrlNonProd ;
	private List<By> pageElements;
	
	// Constructor
	public PageObject(WebDriver driver)
	{
		// Instantiate the Selenium WebDriver
		this.driver = driver;
	}
	
	public List<WebElement> getAllWebElements()
	{
		List allWebElements = new ArrayList();
		
		return allWebElements;
		
	}
}
