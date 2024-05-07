package com.tktres.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tktres.locators.PageObjectsLocators;

public class LandingPage {

	WebDriver ldriver;

	public LandingPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = PageObjectsLocators.HOME_LINK)
	public WebElement homeLink;

	@FindBy(xpath = PageObjectsLocators.TRAVELWORLD_LINK)
	public WebElement travelWorldLink;

	public void home() {

		homeLink.click();
	}

	public void travelWorld() {

		travelWorldLink.click();
	}

}
