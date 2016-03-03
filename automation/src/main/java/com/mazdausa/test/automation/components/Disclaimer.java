package com.mazdausa.test.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Disclaimer extends BaseComponent {


	private String asteriskColor;
	private String targetUrl;
	private String overlayWidth;
	private String overlayHeight;
	private String overlayColor;
	private String copyColor;
	private String copy;
	
	/**
	 * 
	 * @param driver
	 */
	public Disclaimer(WebDriver driver) 
	{
		super(driver);
	}
	
	/** 
	 * Open the Disclamer and validate that the popup did display.
	 * The returned boolean indicates if the Disclaimer opened successfully. 
	 * 
	 */
	public boolean openDisclaimer(String xpath)
	{
		boolean didOpen = false;
		
		// Find the WebElement that opens the Disclaimer
		WebElement openDisclaimer = driver.findElement(By.xpath(xpath));
		
		// Click to open the Disclaimer 
		openDisclaimer.click();

		// Validate that the Disclaimer did open and set didOpen appropriately
		
		return didOpen;		
	}
	
	/** */
	public void scrollDisclaimer()
	{
		
	}

	/** */
	public void closeDisclaimer()
	{
		
	}

	/** */
	public boolean doesCopyMatchProd()
	{
		boolean doesCopyMatch = false;
		
		return doesCopyMatch;
	}

	
	
	/* Getter / Setter Methods */
	public String getAsteriskColor() {
		return asteriskColor;
	}
	public void setAsteriskColor(String asteriskColor) {
		this.asteriskColor = asteriskColor;
	}
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public String getOverlayWidth() {
		return overlayWidth;
	}
	public void setOverlayWidth(String overlayWidth) {
		this.overlayWidth = overlayWidth;
	}
	public String getOverlayHeight() {
		return overlayHeight;
	}
	public void setOverlayHeight(String overlayHeight) {
		this.overlayHeight = overlayHeight;
	}
	public String getOverlayColor() {
		return overlayColor;
	}
	public void setOverlayColor(String overlayColor) {
		this.overlayColor = overlayColor;
	}
	public String getCopyColor() {
		return copyColor;
	}
	public void setCopyColor(String copyColor) {
		this.copyColor = copyColor;
	}
	public String getCopy() {
		return copy;
	}
	public void setCopy(String copy) {
		this.copy = copy;
	}	
	
}
