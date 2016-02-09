package com.mazdausa.test.pages;

import com.mazdausa.test.automation.components.*;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class VehicleLandingPage extends BasePageObject
{	
	private String vehicleCode;
	
	/* Future dynamic navigation items for flexibility. */
	//private List navNameList;
	//private Map navNamesXpathMap;
	
	private WebDriver driver;

	@FindBy(how=How.ID, using="landing")
	private WebElement overview;
	
	@FindBy(how=How.ID, using="subnav-specs-link")
	private WebElement specs;

	@FindBy(how=How.ID, using="nav-shop")
	private WebElement shop;	
	
	//m3h_header_copy=//*[@id='overview']/div[1]/div/h3
	@FindBy(how=How.XPATH, using="//*[@id='overview']/div[1]/div/h3")
	private WebElement headerCopy;	
			
	//m3h_disclaimer_copy=html/body/footer/div/div[2]/div/div/div
	//*[@id="garage-subnav-container"]/div/div[1]/h3/span
	@FindBy(how=How.XPATH, using="//*[@id=\"garage-subnav-container\"]/div/div[1]/h3/span")
	private WebElement priceDisclaimerWebElement;				
	
    /* Commented out for now because the Search Inventory nav link does not yet have an ID attribute. */
    //@FindBy(how=How.ID, using="search-inventory")
    //private WebElement searchInventory;

    //@FindBy(how=How.ID, using="build-and-price")
    //private WebElement build;


	/**
	 * Constructor.  Initializes WebElements on pageUrl.
	 * @param driver
	 * @param pageUrl
	 */
	public VehicleLandingPage(WebDriver driver, String pageUrl) 
	{
		this.driver = driver;
		this.pageUrl = pageUrl;
		driver.get(this.pageUrl);
		
		System.out.println("PageUrl = " + this.pageUrl);
				
		//Initialize Elements
	    PageFactory.initElements(driver, this);
	    
	    System.out.println("Current URL = " + this.driver.getCurrentUrl());

	}	
	

	public Disclaimer getPriceDisclaimer()
	{
		/* EXAMPLE:
		 * <span class="tooltip-disclaimer-link"
		 * 	data-disclaimer-id="#topNavPriceDisclaimerM3H" 
		 * 	data-disclaimer-desktop-parent-id="body">*</span> 
		 */
		
		
		
		Disclaimer priceDisclaimer = new Disclaimer();
		System.out.println("Price Disclaimer = " + this.priceDisclaimerWebElement.toString());
		System.out.println("Price Disclaimer Class = " + this.priceDisclaimerWebElement.getClass());
		
		priceDisclaimer.setName(this.priceDisclaimerWebElement.getAttribute("data-disclaimer-id"));
		System.out.println("Price Disclaimer Name = " + priceDisclaimer.getName());
		
		return priceDisclaimer;
	}
	
	/* ********************************************************************************** */
	/* Go through the list of nav elements, click, and check to make sure page displayed. */
    
	/**
	 * Test the Overview link in the VLP sub nav.
	 * @return
	 */	
	public void clickOverviewLink()
	{
		System.out.println("Getting ready to click Overview Link...");
		System.out.println("Overview Item: " + overview.toString());
		overview.click();
	}
	
	/**
	 * Test the Specs link in the VLP sub nav.
	 */
	public void clickSpecsLink()
	{
		specs.click();	
	}
	
	
}
