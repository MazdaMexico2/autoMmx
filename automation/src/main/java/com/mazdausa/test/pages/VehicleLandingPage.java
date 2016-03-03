package com.mazdausa.test.pages;

import com.mazdausa.test.automation.components.*;
import com.mazdausa.test.automation.panels.Panel;

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

	private Panel vehicleNav;
	private Panel overviewPanel;
	private Panel rotatePanel;
	private Panel accoladesPanel;
	private Panel galleryPanel;
	private Panel skyactivPanel;
	private Panel interiorDesignPanel;
	private Panel cargoSeatingPanel;
	private Panel comparisonPanel;
	private Panel allWheelPanel;
	private Panel kodoPanel;
	private Panel btvPanel;
		

	public String getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}

	public Panel getVehicleNav() {
		return vehicleNav;
	}

	public void setTertiaryNav(Panel tertiaryNav) {
		this.vehicleNav = tertiaryNav;
	}

	public Panel getOverviewPanel() {
		return overviewPanel;
	}

	public void setOverviewPanel(Panel overviewPanel) {
		this.overviewPanel = overviewPanel;
	}

	public Panel getRotatePanel() {
		return rotatePanel;
	}

	public void setRotatePanel(Panel rotatePanel) {
		this.rotatePanel = rotatePanel;
	}

	public Panel getAccoladesPanel() {
		return accoladesPanel;
	}

	public void setAccoladesPanel(Panel accoladesPanel) {
		this.accoladesPanel = accoladesPanel;
	}

	public Panel getGalleryPanel() {
		return galleryPanel;
	}

	public void setGalleryPanel(Panel galleryPanel) {
		this.galleryPanel = galleryPanel;
	}

	public Panel getSkyactivPanel() {
		return skyactivPanel;
	}

	public void setSkyactivPanel(Panel skyactivPanel) {
		this.skyactivPanel = skyactivPanel;
	}

	public Panel getInteriorDesignPanel() {
		return interiorDesignPanel;
	}

	public void setInteriorDesignPanel(Panel interiorDesignPanel) {
		this.interiorDesignPanel = interiorDesignPanel;
	}

	public Panel getCargoSeatingPanel() {
		return cargoSeatingPanel;
	}

	public void setCargoSeatingPanel(Panel cargoSeatingPanel) {
		this.cargoSeatingPanel = cargoSeatingPanel;
	}

	public Panel getComparisonPanel() {
		return comparisonPanel;
	}

	public void setComparisonPanel(Panel comparisonPanel) {
		this.comparisonPanel = comparisonPanel;
	}

	public Panel getAllWheelPanel() {
		return allWheelPanel;
	}

	public void setAllWheelPanel(Panel allWheelPanel) {
		this.allWheelPanel = allWheelPanel;
	}

	public Panel getKodoPanel() {
		return kodoPanel;
	}

	public void setKodoPanel(Panel kodoPanel) {
		this.kodoPanel = kodoPanel;
	}

	public Panel getBtvPanel() {
		return btvPanel;
	}

	public void setBtvPanel(Panel btvPanel) {
		this.btvPanel = btvPanel;
	}
	
	
}
