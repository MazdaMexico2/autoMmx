package com.mazdausa.test.automation.panels;

import com.mazdausa.test.automation.BaseWebObject;
import com.mazdausa.test.automation.components.*;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class BasePanelObject extends BaseWebObject implements Panel 
{
	
	private String title;
	private String enclosingPageName;
	private String locationUrl;
	private String xPath;
	private List<Component> components;

	public BasePanelObject()
	{

	}
	
		
	
	public BasePanelObject(WebDriver driver)
	{
		super.setWebDriver(driver);
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public String getEnclosingPageName() {
		return enclosingPageName;
	}
	public String getLocationUrl() {
		return locationUrl;
	}
	public String getXPath() {
		return xPath;
	}
	public List<Component> getComponents() {
		// TODO Auto-generated method stub
		return components;
	}
	public void setEnclosingPageName(String enclosingPageName) {
		// TODO Auto-generated method stub
		
	}
	public void setLocationUrl(String locationUrl) {
		// TODO Auto-generated method stub
		
	}
	public void setXPath(String xPath) {
		// TODO Auto-generated method stub
		
	}
	public void set(List<Component> components) {
		// TODO Auto-generated method stub
		
	}
	

}
