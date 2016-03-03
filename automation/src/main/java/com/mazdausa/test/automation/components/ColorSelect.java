package com.mazdausa.test.automation.components;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class ColorSelect extends BaseComponent 
{

	private int availableColorCount;
	private List availableColorNames;
	private String selectedColorName;
	private String selectedColorHighlight;
	private String selectedColorSwatch;
	private String vehicleImageColor;
	
	public ColorSelect(WebDriver driver) 
	{
		super(driver);

	}	
	
	/* Getter / Setter Methods */
	public int getAvailableColorCount() {
		return availableColorCount;
	}
	public void setAvailableColorCount(int availableColorCount) {
		this.availableColorCount = availableColorCount;
	}
	public List getAvailableColorNames() {
		return availableColorNames;
	}
	public void setAvailableColorNames(List availableColorNames) {
		this.availableColorNames = availableColorNames;
	}
	public String getSelectedColorName() {
		return selectedColorName;
	}
	public void setSelectedColorName(String selectedColorName) {
		this.selectedColorName = selectedColorName;
	}
	public String getSelectedColorHighlight() {
		return selectedColorHighlight;
	}
	public void setSelectedColorHighlight(String selectedColorHighlight) {
		this.selectedColorHighlight = selectedColorHighlight;
	}
	public String getSelectedColorSwatch() {
		return selectedColorSwatch;
	}
	public void setSelectedColorSwatch(String selectedColorSwatch) {
		this.selectedColorSwatch = selectedColorSwatch;
	}
	public String getVehicleImageColor() {
		return vehicleImageColor;
	}
	public void setVehicleImageColor(String vehicleImageColor) {
		this.vehicleImageColor = vehicleImageColor;
	}
	
}
