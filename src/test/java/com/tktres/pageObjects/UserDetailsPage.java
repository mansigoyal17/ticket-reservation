package com.tktres.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tktres.locators.PageObjectsLocators;
import com.tktres.utilities.UtilitiesClass;

public class UserDetailsPage {

	WebDriver ldriver;
	UtilitiesClass uc = new UtilitiesClass();

	public UserDetailsPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = PageObjectsLocators.USER_NAME_TEXTBOX)
	public WebElement userNametxtBox;
	
	@FindBy(xpath = PageObjectsLocators.USER_ADDRESS_TEXTBOX)
	public WebElement userAddresstxtBox;
	
	@FindBy(xpath = PageObjectsLocators.USER_CITY_TEXTBOX)
	public WebElement userCitytxtBox;
	
	@FindBy(xpath = PageObjectsLocators.USER_STATE_TEXTBOX)
	public WebElement userStatetxtBox;
	
	@FindBy(xpath = PageObjectsLocators.USER_ZIP_CODE_TEXTBOX)
	public WebElement userZiptxtBox;
	
	@FindBy(xpath = PageObjectsLocators.USER_CARD_TYPE_DROPDOWN)
	public WebElement userCardTypeDropdown;
	
	@FindBy(xpath = PageObjectsLocators.USER_CC_NUMBER_TEXTBOX)
	public WebElement userCCtxtBox;
	
	@FindBy(xpath = PageObjectsLocators.USER_CC_MONTH_TEXTBOX)
	public WebElement userCCMonthtxtBox;
	
	@FindBy(xpath = PageObjectsLocators.USER_CC_YEAR_TEXTBOX)
	public WebElement userCCYeartxtBox;
	
	@FindBy(xpath = PageObjectsLocators.USER_CC_NAME_TEXTBOX)
	public WebElement userNameOnCCtxtBox;
	
	@FindBy(xpath = PageObjectsLocators.USER_REMEMBER_ME_CHECKBOX)
	public WebElement userRememberMeCheckbox;
	
	@FindBy(xpath = PageObjectsLocators.USER_PURCHASE_FLIGHT_BUTTON)
	public WebElement userPurcFlightbtn;
	
	public void getUserDetails() {
		userNametxtBox.sendKeys("Mansi");
		userAddresstxtBox.sendKeys("123 Street");
		userCitytxtBox.sendKeys("Toronto");
		userStatetxtBox.sendKeys("ON");
		userZiptxtBox.sendKeys("M5A 0C3");
		
		Select cardType = new Select(userCardTypeDropdown);
		List<WebElement> cardList = cardType.getOptions();
		System.out.println("Different Card Types available are : ");
		for (WebElement card : cardList) {
			System.out.println(card.getText());
		}
		cardType.selectByValue("dinersclub");
		WebElement selectedOption = cardType.getFirstSelectedOption();
		System.out.println(selectedOption.getText() + " is selected as card type");
		
		userCCtxtBox.sendKeys("123456789");
		userCCMonthtxtBox.clear();
		userCCMonthtxtBox.sendKeys("05");
		userCCYeartxtBox.clear();
		userCCYeartxtBox.sendKeys("2028");
		userNameOnCCtxtBox.sendKeys("Mansi Goyal");
	}
	
	public void getRememberMe() {
		userRememberMeCheckbox.click();
	}
	
	public void getPurchaseFlight() {
		userPurcFlightbtn.click();
	}

}
