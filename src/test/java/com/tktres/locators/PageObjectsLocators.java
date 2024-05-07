package com.tktres.locators;

public class PageObjectsLocators {
	
	//CONSTANTS
	public static final String FORM_ID_1="//form[@id='";
	public static final String FORM_ID_2="']";
	public static final String BLANK="";

	
	//LandingPage
	public static final String HOME_LINK="//a[normalize-space()='home']";
	public static final String TRAVELWORLD_LINK="//a[normalize-space()='Travel The World']";
	
	public static final String FORM_ID="//form[@id='form_id']";


	//LoginPage
	public static final String LOGIN_LINK="//a[normalize-space()='Login']";
	public static final String LOGIN_EMAIL_ADDRESS_TEXTBOX="//input[@id='email']";
	public static final String LOGIN_PASSWORD_TEXTBOX="//input[@id='password']";
	public static final String LOGIN_BUTTON="//button[normalize-space()='Login']";
	public static final String REMEMBER_ME_CHECKBOX="//input[@name='remember']";
	public static final String FORGOT_PASSWORD_LINK="//a[normalize-space()='Forgot Your Password?']";
	public static final String LOGIN_SUCESS_PAGE="//div[@class='message']";
	
	//LoginPageValidations
	public static final String LOGIN_FAILURE="//span[@class='help-block']//strong[normalize-space()='These credentials do not match our records.']";


	
	//RegisterPage
	public static final String REGISTER_LINK="//a[normalize-space()='Register']";
	public static final String REGISTER_NAME_TEXTBOX="//input[@id='name']";
	public static final String REGISTER_COMPANY_TEXTBOX="//input[@id='company']";
	public static final String REGISTER_EMAIL_TEXTBOX="//input[@id='email']";
	public static final String REGISTER_PASSWORD_TEXTBOX="//input[@id='password']";
	public static final String REGISTER_CONFRIM_PASSWORD_TEXTBOX="//input[@id='password-confirm']";
	public static final String REGISTER_BUTTON="//button[normalize-space()='Register']";
	
	//RegisterPageValidations
	public static final String REGISTER_EXISTING_EMAIL="//strong[normalize-space()='The email has already been taken.']";
	public static final String REGISTER_PASSWORD_MISMATCH="//span[@class='help-block']//strong[normalize-space()='The password confirmation does not match.']";
	public static final String REGISTER_PASSWORD_LENGTH="//strong[normalize-space()='The password must be at least 6 characters.']";

	//ForgotPasswordPage
	public static final String FORGOT_PASS_EMAIL_ADDR_TEXTBOX="//input[@id='email']";
	public static final String FORGOT_PASS_RESET_BUTTON="//button[normalize-space()='Send Password Reset Link']";
	
	
	//BookingPage
	public static final String BOOKING_WELCOME="//div[@class='jumbotron']//h1[normalize-space()='Welcome to the Simple Travel Agency!']";
	public static final String BOOKING_DEPARTURE_TEXT="//h2[normalize-space()='Choose your departure city:']";
	public static final String BOOKING_DEPARTURE_DROPDOWN="//select[@name='fromPort']";
	public static final String BOOKING_DESTINATION_TEXT="//h2[normalize-space()='Choose your destination city:']";
	public static final String BOOKING_DESTINATION_DROPDOWN="//select[@name='toPort']";
	public static final String BOOKING_FIND_FLIGHTS_BUTTON="//input[@value='Find Flights']";
	
	//ChooseFlightpage
	public static final String BOOKING_CHOOSE_FLIGHT_BUTTON ="//tbody/tr[1]/td[1]/input[1]";
	public static final String BOOKING_FLIGHT_TABLE ="//table[@class='table']";
	public static final String BOOKING_CHOOSE_FLIGHT_BUTTON_GENERIC ="//table[@class='table']//input[@type='submit']";
	
	//UserDetailsPage
	//public static final String USER_NAME_TEXTBOX = "//div[@class='controls']//input[@id='inputName']";
	public static final String USER_NAME_TEXTBOX = "//div[@class='controls']//input[@id='inputName']";
	public static final String USER_ADDRESS_TEXTBOX = "//div[@class='controls']//input[@id='address']";
	public static final String USER_CITY_TEXTBOX = "//div[@class='controls']//input[@id='city']";
	public static final String USER_STATE_TEXTBOX = "//div[@class='controls']//input[@id='state']";
	public static final String USER_ZIP_CODE_TEXTBOX = "//div[@class='controls']//input[@id='zipCode']";
	public static final String USER_CARD_TYPE_DROPDOWN = "//div[@class='controls']//select[@id='cardType']";
	public static final String USER_CC_NUMBER_TEXTBOX = "//div[@class='controls']//input[@id='creditCardNumber']";
	public static final String USER_CC_MONTH_TEXTBOX = "//div[@class='controls']//input[@id='creditCardMonth']";
	public static final String USER_CC_YEAR_TEXTBOX = "//div[@class='controls']//input[@id='creditCardYear']";
	public static final String USER_CC_NAME_TEXTBOX = "//div[@class='controls']//input[@id='nameOnCard']";
	public static final String USER_REMEMBER_ME_CHECKBOX = "//div[@class='controls']//input[@id='rememberMe']";
	public static final String USER_PURCHASE_FLIGHT_BUTTON = "//input[@value='Purchase Flight']";

	//ConfirmationPage
	public static final String CONFRIM_TEXT= "//h1[normalize-space()='Thank you for your purchase today!']";
	public static final String CONFRIM_TABLE= "//table[@class='table']";




	




	
}
