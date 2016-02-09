package com.mazdausa.test.automation.panels;

import java.util.List;

import com.mazdausa.test.automation.components.Component;

public interface Panel {
	
	public String getTitle();
	
	public String getEnclosingPageName();
	public String getLocationUrl();
	public String getXPath();
	public List<Component> getComponents();
	
	public void setEnclosingPageName(String enclosingPageName);
	public void setLocationUrl(String locationUrl);
	public void setXPath(String xPath);	
	public void set(List<Component> components);
	

}
