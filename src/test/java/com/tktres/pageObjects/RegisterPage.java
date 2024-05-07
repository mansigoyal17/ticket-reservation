package com.tktres.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tktres.locators.PageObjectsLocators;

public class RegisterPage {
	
	WebDriver ldriver;

	public RegisterPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = PageObjectsLocators.REGISTER_LINK)
	public WebElement registerLink;
	
	@FindBy(xpath = PageObjectsLocators.REGISTER_NAME_TEXTBOX)
	public WebElement nameTxtbox;

	@FindBy(xpath = PageObjectsLocators.REGISTER_COMPANY_TEXTBOX)
	public WebElement companyTxtbox;
	
	@FindBy(xpath = PageObjectsLocators.REGISTER_EMAIL_TEXTBOX)
	public WebElement emailTxtbox;
	
	@FindBy(xpath = PageObjectsLocators.REGISTER_PASSWORD_TEXTBOX)
	public WebElement passwordTxtbox;

	@FindBy(xpath = PageObjectsLocators.REGISTER_CONFRIM_PASSWORD_TEXTBOX)
	public WebElement confirmPassTxtbox;
	
	@FindBy(xpath = PageObjectsLocators.REGISTER_BUTTON)
	public WebElement registerBtn;
	
	@FindBy(xpath = PageObjectsLocators.REGISTER_EXISTING_EMAIL)
	public WebElement registerEmailExists;
	
	@FindBy(xpath = PageObjectsLocators.REGISTER_PASSWORD_MISMATCH)
	public WebElement registerPassMismatch;
	
	@FindBy(xpath = PageObjectsLocators.REGISTER_PASSWORD_LENGTH)
	public WebElement registerPassLength;
	
	
	public void regsiterLink() {
		registerLink.click();
	}
	
	public void regsiterUsername(String uname) {
		nameTxtbox.sendKeys(uname);
	}
	
	public void regsiterEmail(String email) {
		emailTxtbox.sendKeys(email);
	}
	
	public void regsiterCompany(String company) {
		companyTxtbox.sendKeys(company);
	}
	
	public void regsiterPassword(String password) {
		passwordTxtbox.sendKeys(password);
	}
	
	public void regsiterConfirmPassword(String confirmPassword) {
		confirmPassTxtbox.sendKeys(confirmPassword);
	}
	
	public void registerButton() {
		registerBtn.click();
	}
	
	public void getNewEmail(String registerNewEmail) {
		emailTxtbox.sendKeys(registerNewEmail);
	}
	
	public void getNewRegisterPassword() {
		passwordTxtbox.sendKeys("abc123456");
		confirmPassTxtbox.sendKeys("abc123456");
	}
	
	public String getPassLengthError() {
		return registerPassLength.getText();
	}
	
	public void registerSuccess() {
		
		String expectedUrl="https://blazedemo.com/home";
		String currentUrl= ldriver.getCurrentUrl();

		if(expectedUrl.equalsIgnoreCase(currentUrl)) {
			Assert.assertTrue(true, "Password Reset Successful");
			System.out.println("Registration Successful");
		}else {
			Assert.assertTrue(false, "Password Reset Failure");
			System.out.println("Registration Failed");
		}
	}
	
}
