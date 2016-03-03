package com.mazdausa.test.automation.components;

public class Copy extends BaseComponent 
{
	private String copy;
	private String type;
	private String color;
	private int size ;
	private String alignment;
	
	
	public boolean doesCopyMatchProd()
	{
		boolean doesCopyMatch = false;
		
		// Check copy against prod or other control
		
		return doesCopyMatch;
	}
	
	/* Getter / Setter Methods */
	
	public String getCopy() {
		return copy;
	}
	public void setCopy(String copy) {
		this.copy = copy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	
	
}
