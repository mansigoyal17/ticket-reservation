package com.tktres.booking;

import org.testng.annotations.Test;

import com.tktres.pageObjects.BaseClass;
import com.tktres.pageObjects.ChooseFlightPage;
import com.tktres.pageObjects.ConfirmationPage;
import com.tktres.pageObjects.FindFlightsPage;
import com.tktres.pageObjects.LandingPage;
import com.tktres.pageObjects.UserDetailsPage;

public class TestCaseBooking extends BaseClass {

	@Test(priority=1)
	public void bookingTest()  {
		
		LandingPage lp = new LandingPage(driver);
		lp.travelWorld();
		logger.info("<---Flight search begin-->");
		FindFlightsPage bp = new FindFlightsPage(driver);
		bp.getWelcomeText();
		bp.getDepartureCity();
		bp.getDestinationCity();
		bp.getFindFlights();
		logger.info("<---Choose Flight--->");
		ChooseFlightPage cf=new ChooseFlightPage(driver);
		cf.getLowPriceFlight();
		logger.info("<---Input User Details--->");
		UserDetailsPage up= new UserDetailsPage(driver);
		up.getUserDetails();
		up.getRememberMe();
		up.getPurchaseFlight();
	}
	
	@Test(priority=2)
	public void confirmationTest() {
		
		ConfirmationPage cp=new ConfirmationPage(driver);
		cp.getConfirmation();
		cp.getConfirmedFlightDetails();
	}
	
}
