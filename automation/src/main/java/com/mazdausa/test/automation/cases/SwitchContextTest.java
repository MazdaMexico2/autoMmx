package com.mazdausa.test.automation.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchContextTest extends BaseTest{
	
	private WebElement frame = null;
		
	public SwitchContextTest(WebDriver webDriver){
		this.setDriver(webDriver);
	}
	
	public Boolean changeContext(SearchContext searchContext){
		return changeContext(this.getWebElement(searchContext));
	}
	
	public Boolean changeContext(int searchContext, String contextValue){
		
		SearchContext context = new SearchContext(searchContext, contextValue);		
		return this.changeContext(context);
	}
	
	
	public Boolean changeContext(WebElement element){
		
		frame = element;
		try {
			driver.switchTo().frame(frame);		
			
			}catch(Exception ex){
				System.out.println(ex.getMessage());
				testResult = false;
			}		
		return testResult;
	}
	
	public Boolean backToDefault(){
		try {
		driver.switchTo().defaultContent();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			testResult = false;
		}
		return testResult;
	}
	

	
	

}
