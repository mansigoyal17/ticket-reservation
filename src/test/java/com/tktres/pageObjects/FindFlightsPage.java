package com.tktres.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.tktres.locators.PageObjectsLocators;
import com.tktres.utilities.UtilitiesClass;

public class FindFlightsPage {

	WebDriver ldriver;

	public FindFlightsPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	UtilitiesClass uc = new UtilitiesClass();

	@FindBy(xpath = PageObjectsLocators.BOOKING_WELCOME)
	public WebElement bookingWelcomeText;

	@FindBy(xpath = PageObjectsLocators.BOOKING_DEPARTURE_TEXT)
	public WebElement bookingDepartureCityText;

	@FindBy(xpath = PageObjectsLocators.BOOKING_DEPARTURE_DROPDOWN)
	public WebElement bookingDepartureCityDropdown;

	@FindBy(xpath = PageObjectsLocators.BOOKING_DESTINATION_TEXT)
	public WebElement bookingDestinationCityText;

	@FindBy(xpath = PageObjectsLocators.BOOKING_DESTINATION_DROPDOWN)
	public WebElement bookingDestinationCityDropdown;
	
	@FindBy(xpath = PageObjectsLocators.BOOKING_FIND_FLIGHTS_BUTTON)
	public WebElement bookingFindFlightBtn;
	
	public void getWelcomeText() {
		uc.explicitWait(ldriver, bookingWelcomeText, 3);
		if (bookingWelcomeText.isDisplayed()) {
			Assert.assertTrue(true, "User is on Booking Page");
			System.out.println("User is on Booking Page");
		} else {
			Assert.assertTrue(false, "User is not on Booking Page");
			System.out.println("User is not on Booking Page");
		}
	}

	public void getDepartureCity() {
		uc.explicitWait(ldriver, bookingDepartureCityDropdown, 3);
		Select depCity = new Select(bookingDepartureCityDropdown);
		List<WebElement> depCityList = depCity.getOptions();
		System.out.println("Departure city list : ");
		for (WebElement city : depCityList) {
			System.out.println(city.getText());
		}
		Select select = new Select(bookingDepartureCityDropdown);
		select.selectByVisibleText("Portland");
		WebElement selectedOption = select.getFirstSelectedOption();
		System.out.println(selectedOption.getText() + " is selected as departure city");
	}

	public void getDestinationCity() {
		uc.explicitWait(ldriver, bookingDestinationCityDropdown, 3);
		Select destCity = new Select(bookingDestinationCityDropdown);
		List<WebElement> destCityList = destCity.getOptions();
		System.out.println("Destination city list : ");
		for (WebElement city : destCityList) {
			System.out.println(city.getText());
		}
		Select select = new Select(bookingDestinationCityDropdown);
		select.selectByValue("London");
		WebElement selectedOption = select.getFirstSelectedOption();
		System.out.println(selectedOption.getText() + " is selected as destination city");
	}
	
	public void getFindFlights() {
		uc.explicitWait(ldriver, bookingFindFlightBtn, 2);
		bookingFindFlightBtn.click();
	}

}
