package com.mazdausa.test.automation;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

//import com.mazdausa.test.automation.components.CopyTest;
import com.mazdausa.test.pages.VehicleNavPage;
import com.mazdausa.test.util.TestUtil;

import org.openqa.selenium.WebElement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) 
	{
		System.out.println("Hello Tester!");		
		
		// Open the configuration file which will point to all vehicle config files.
		TestUtil util = new TestUtil();
		
		util.getConfigProperties("cars.properties");

		// Open the vehicle properties config files
        Properties props = util.getConfigProperties("cars.properties");
        
        String environment = null;
        String homePageUrlProd = null;
        String homePageUrlNonProd = null;
        String vlpProdPageUrl = null;
        String vlpNonProdPageUrl = null;
        
        // Test to see if i read the props
        if(props != null)
        {
        	// all is good, lets read some properties
        	environment = props.getProperty("musa_environment");
        	homePageUrlProd = props.getProperty("musa_homepage_url_prod");
        	homePageUrlNonProd = props.getProperty("musa_homepage_url_" + environment);
        	vlpProdPageUrl = props.getProperty("m3h_vlp_url_prod");
        	vlpNonProdPageUrl = props.getProperty("m3h_vlp_url_" + environment);
        	
        	System.out.println("Props loaded successfully. Size = " + props.size());
        	System.out.println("Props Environment = " + environment);
        	System.out.println("MUSA Homepage URL Production = " + homePageUrlProd);
        	System.out.println("MUSA Homepage URL Test Environment = " + homePageUrlNonProd);
        	
        }
        else
        {
        	// no bueno.  Properties did not get loaded
        	System.out.println("No bueno.  Properties did not get loaded");
        }

	
		
		// Create a new instance of a driver
        WebDriver prodDriver = new HtmlUnitDriver();
        prodDriver.get(vlpProdPageUrl);

        WebDriver approvalDriver = new HtmlUnitDriver();
        approvalDriver.get(vlpNonProdPageUrl);
        
        // Get the URL to the homepage from properties
//        driver.get(props.getProperty("musa_homepage"));  
        
		System.out.println("Prod Current URL = " + prodDriver.getCurrentUrl() ) ;
		System.out.println("Prod Title = " + prodDriver.getTitle() ) ;
		System.out.println("Non Prod Current URL = " + approvalDriver.getCurrentUrl() ) ;
		System.out.println("Non Prod Title = " + approvalDriver.getTitle() ) ;
		
		// Test getting a list of specific tag types
		List<org.openqa.selenium.WebElement> options = prodDriver.findElements(By.tagName("div"));

        if(options != null && options.size() > 0)
        {
        	WebElement element = null;
        	String elementName = null;
        	for (int i = 0; i < options.size(); i++)
        	{
        		element = options.get(i);
        		elementName = element.toString();
        		
        		System.out.println("Element ToString = " + elementName);
        		
        	}
        		
        }

        System.out.println("----------------------------------------------------------------------");
        
        String xpathExpression = props.getProperty("m3h_vlp_overview_nav");
        
        // Let's get the nav buttons
    	WebElement overviewNavLink = prodDriver.findElement(By.xpath(xpathExpression));	
    	if(overviewNavLink != null) 
    	{
    		System.out.println("Overview Nav = " + overviewNavLink.toString());

    	}
    
        /* Create a new instance of the VLP Nav page class
         and initialise any WebElement fields in it.
         */

       // VehicleNavPage page = PageFactory.initElements(driver, VehicleNavPage.class);

        //page.setPageUrl(vlpPageUrl);
        
        // Get Vehicles nav
        //page.getVehiclesNav();
        
        // Check the car title to see if it matches what we expect.  
        //page.clickSpecsLink();
        
     // Lets check out what elements are found on the page:       

		
	    // Get Panel names
    	
	    // Get Overview panel
	    	
	    // Get headline copy
	    	
	    // Get disclaimer        
        
        
        
        
        
   		
		
		
		
		

		
		// Test Homepage
		
		
		// Test Mazda 6 VLP


		// Test Copy

		// Test Disclaimer

		// Test 360 Rotation		
		
	}
}
