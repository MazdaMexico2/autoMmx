package com.mazdausa.test.automation.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTest {
	
	protected WebDriver driver;
	protected String url;
	protected Boolean testResult = true; 

	
	protected WebElement getWebElement(SearchContext context){
		WebElement element = null;
		
		if (driver != null) {
			switch (context.getContext()){	
				case SearchContext.XPATH: 
					element = driver.findElement(By.xpath(context.getContextValue()));
					break;
				
				case SearchContext.NAME:
					element = driver.findElement(By.name(context.getContextValue()));
					break;
				
				case SearchContext.ID:
					element = driver.findElement(By.id(context.getContextValue()));
					break;
			}
		}
		return element;
		
	}
	
	
	protected Boolean test(){		
		
		try {
			if (driver != null && !url.isEmpty()){
				driver.get(url);
			}
		} catch (Exception ex){
			testResult = false;
			System.out.println(ex.getMessage());
		}
		return testResult;
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
