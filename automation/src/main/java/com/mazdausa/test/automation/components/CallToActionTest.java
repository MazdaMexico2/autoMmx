package com.mazdausa.test.automation.components;

public class CallToActionTest extends BaseTest 
{
	private String copy;
	private String color;
	private int height;
	private int width;
	private String targetName;
	private String targetUrl;
	private String hoverAction;
	private String hoverColor;
	private String type;

	/** Test a click on this Call To Action element. */
	public void doClick( )
	{

	}
	
	/** Test a hover over this Call To Action element. */
	public void doHover( )
	{
		
	}
		
	/** Test to if click event occurred. */
	public boolean wasClicked()
	{
		boolean wasClickEvent = false;
		
		return wasClickEvent;
	}

	/** Test to if hover event occurred. */
	public boolean didHover()
	{
		boolean didHoverEvent = false;
		
		return didHoverEvent;
	}	
	
	
	/* Getter / Setter Methods */
	public String getCopy() {
		return copy;
	}
	public void setCopy(String copy) {
		this.copy = copy;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public String getHoverAction() {
		return hoverAction;
	}
	public void setHoverAction(String hoverAction) {
		this.hoverAction = hoverAction;
	}
	public String getHoverColor() {
		return hoverColor;
	}
	public void setHoverColor(String hoverColor) {
		this.hoverColor = hoverColor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
