package com.tktres.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tktres.locators.PageObjectsLocators;

public class ForgotPasswordPage {
	
	WebDriver ldriver;

	public ForgotPasswordPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = PageObjectsLocators.FORGOT_PASS_EMAIL_ADDR_TEXTBOX)
	public WebElement fpEmailTxtBox;
	
	@FindBy(xpath = PageObjectsLocators.FORGOT_PASS_RESET_BUTTON)
	public WebElement fpResetBtn;
	
	public void getEmailAddress(String email) {
		fpEmailTxtBox.sendKeys(email);
	}
	
	public void getPassResetButton() {
		fpResetBtn.click();
	}
	
}
