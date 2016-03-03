package com.mazdausa.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface PageObject {
	
	public List<WebElement> getAllWebElements();
	public WebElement getWebElementByName(String name);
	public WebElement getWebElementByXPath(String xpath);
	
	public String getPageUrl();
	public void setPageUrl(String pageUrl);
	
	public List<By> getPageElements();
	public void setPageElements(List<By> pageElements);
	

}
