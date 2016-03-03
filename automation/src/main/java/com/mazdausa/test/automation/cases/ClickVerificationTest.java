package com.mazdausa.test.automation.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickVerificationTest extends BaseTest {
	
	private WebElement element;
	
	public ClickVerificationTest(WebDriver webDriver){
		this.setDriver(webDriver);
	}
	
	public Boolean test(SearchContext searchContext){
		
		element = getWebElement(searchContext);
		
		try{
			
			element.click();
			
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			testResult = false;
		}
		
		return testResult;
	}
	
	public Boolean test(int searchContext, String contextValue){
		SearchContext context = new SearchContext(searchContext, contextValue);
		return test(context);
	}

}
