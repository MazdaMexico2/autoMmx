package com.mazdausa.test.automation.components;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class VehicleRotation extends BaseComponent {

	private int frameCount;
	private List imageList; 
	private String dragDirection; 
	private String selectedColor;
	
	public VehicleRotation(WebDriver driver) 
	{
		super(driver);
	}	
	
	public void startDrag()
	{
		
	}
	
	public void endDrag()
	{
		
	}
	
	public boolean isImagePresentAtFrame()
	{
		boolean isImagePresent= false;
		
		return isImagePresent;
	}
	
	/* Getter / Setter Methods */
	
	public int getFrameCount() {
		return frameCount;
	}
	public void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
	}
	public List getImageList() {
		return imageList;
	}
	public void setImageList(List imageList) {
		this.imageList = imageList;
	}
	public String getDragDirection() {
		return dragDirection;
	}
	public void setDragDirection(String dragDirection) {
		this.dragDirection = dragDirection;
	}
	public String getSelectedColor() {
		return selectedColor;
	}
	public void setSelectedColor(String selectedColor) {
		this.selectedColor = selectedColor;
	}


}
