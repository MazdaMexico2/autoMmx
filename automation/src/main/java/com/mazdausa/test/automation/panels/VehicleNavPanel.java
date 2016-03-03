package com.mazdausa.test.automation.panels;

import org.openqa.selenium.WebElement;

import com.mazdausa.test.automation.components.Disclaimer;

public class VehicleNavPanel extends BasePanelObject 
{
	private WebElement vehicleTitle;
	private WebElement msrpCopy;
	private WebElement priceDisclaimer;
	private WebElement overviewLink;
	private WebElement specsLink;
	private WebElement searchInvLink;
	private WebElement requestQuoteLink;
	private WebElement buildPriceLink;
	private WebElement shopLink;


	/**
	 * Get the specific Pricing Disclaimer on the Vehicle Landing Page.
	 * @param xPath
	 * @return
	 */
	public Disclaimer getPriceDisclaimer(String xPath)
	{
		/* EXAMPLE HTML:
		 * <span class="tooltip-disclaimer-link"
		 * 	data-disclaimer-id="#topNavPriceDisclaimerM3H" 
		 * 	data-disclaimer-desktop-parent-id="body">*</span>
		 * 
		 * EXAMPLE XPATH:
		 * //*[@id=\"garage-subnav-container\"]/div/div[1]/h3/span
		 */

		Disclaimer priceDisclaimer = new Disclaimer(this.getDriver());
		priceDisclaimer.setWebElement(priceDisclaimer.getWebElementByXPath(xPath));
		
		System.out.println("Price Disclaimer = " + priceDisclaimer.getWebElement().toString());
		System.out.println("Price Disclaimer Class = " + priceDisclaimer.getWebElement().getClass());
		
		priceDisclaimer.setName(this.priceDisclaimer.getAttribute("data-disclaimer-id"));
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
		//System.out.println("Overview Item: " + overview.toString());
		//overview.click();
	}
	
	/**
	 * Test the Specs link in the VLP sub nav.
	 */
	public void clickSpecsLink()
	{
		//specs.click();	
	}

	public WebElement getVehicleTitle() {
		return vehicleTitle;
	}

	public void setVehicleTitle(WebElement vehicleTitle) {
		this.vehicleTitle = vehicleTitle;
	}

	public WebElement getMsrpCopy() {
		return msrpCopy;
	}

	public void setMsrpCopy(WebElement msrpCopy) {
		this.msrpCopy = msrpCopy;
	}

	public WebElement getPriceDisclaimer() {
		return priceDisclaimer;
	}

	public void setPriceDisclaimer(WebElement priceDisclaimer) {
		this.priceDisclaimer = priceDisclaimer;
	}

	public WebElement getOverviewLink() {
		return overviewLink;
	}

	public void setOverviewLink(WebElement overviewLink) {
		this.overviewLink = overviewLink;
	}

	public WebElement getSpecsLink() {
		return specsLink;
	}

	public void setSpecsLink(WebElement specsLink) {
		this.specsLink = specsLink;
	}

	public WebElement getSearchInvLink() {
		return searchInvLink;
	}

	public void setSearchInvLink(WebElement searchInvLink) {
		this.searchInvLink = searchInvLink;
	}

	public WebElement getRequestQuoteLink() {
		return requestQuoteLink;
	}

	public void setRequestQuoteLink(WebElement requestQuoteLink) {
		this.requestQuoteLink = requestQuoteLink;
	}

	public WebElement getBuildPriceLink() {
		return buildPriceLink;
	}

	public void setBuildPriceLink(WebElement buildPriceLink) {
		this.buildPriceLink = buildPriceLink;
	}

	public WebElement getShopLink() {
		return shopLink;
	}

	public void setShopLink(WebElement shopLink) {
		this.shopLink = shopLink;
	}
	
}
