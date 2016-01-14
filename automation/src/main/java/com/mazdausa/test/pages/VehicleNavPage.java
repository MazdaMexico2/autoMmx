package com.mazdausa.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class VehicleNavPage 
{
	private final WebDriver driver;
	private String pageUrl ;
	private List<By> navElements;
	
	// Constructor
	public VehicleNavPage(WebDriver driver)
	{
		// Instantiate the Selenium WebDriver
		this.driver = driver;
	}

	// The Vehicle Landing Page contains several HTML elements that will be represented as WebElements.
	// The locators for these elements should only be defined once.
    By overviewNavLinkLocator = By.id("landing");
    By specsNavLinkLocator = By.id("subnav-specs-link");
    
    //System.out.println("Overview Nav Link = " + overviewNavLinkLocator);
    
    /* Commented out for now because the Search Inventory nav link does not yet have an ID attribute. */
    // By searchInventoryNavLinkLocator = By.id("subnav-inventory-link");

    By shopNavLinkLocator = By.id("nav-shop");
        
    
    
	/* ********************************************************************************** */
	/* Go through the list of nav elements, click, and check to make sure page displayed. */
    
	/**
	 * Test the Overview link in the VLP sub nav.
	 * @return
	 */	
/*
    public OverviewPage clickOverviewLink()
	{
		driver.findElement(overviewNavLinkLocator).click();
		
		
		// Create a new instance of the Overview page class and initialize any WebElement fields in it.
		OverviewPage page = PageFactory.initElements(driver, OverviewPage.class);
		return page;
	}
	
	/**
	 * Test the Specs link in the VLP sub nav.
	 * @return
	 */
   
	public SpecsPage clickSpecsLink()
	{
		WebElement specs = driver.findElement(specsNavLinkLocator);
		specs.click();
		
		// Create a new instance of the Specs page class and initialize any WebElement fields in it.
		SpecsPage page = PageFactory.initElements(driver, SpecsPage.class);
		return page;		
	}
	
	
	public List<By> getNavElements() {
		return navElements;
	}

	public void setNavElements(List<By> navElements) {
		this.navElements = navElements;
	}


	public String getPageUrl() {
		return pageUrl;
	}


	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

/*
	public WebElement getVehiclesNav() {

//		WebElement vehiclesNav = this.driver.findElement("vehicles");
		return vehiclesNav;
		
	}
*/	
}
