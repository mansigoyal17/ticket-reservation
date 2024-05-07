package com.tktres.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tktres.locators.PageObjectsLocators;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	/*
	 * @FindBy(xpath = PageObjectsLocators.FORM_ID) public static WebElement formId;
	 */

	@FindBy(xpath = PageObjectsLocators.LOGIN_LINK)
	public WebElement loginLink;

	@FindBy(xpath = PageObjectsLocators.LOGIN_EMAIL_ADDRESS_TEXTBOX)
	public WebElement emailTxtbox;

	@FindBy(xpath = PageObjectsLocators.LOGIN_PASSWORD_TEXTBOX)
	public WebElement passwordTxtbox;

	@FindBy(xpath = PageObjectsLocators.REMEMBER_ME_CHECKBOX)
	public WebElement rememberCheckBox;

	@FindBy(xpath = PageObjectsLocators.LOGIN_BUTTON)
	public WebElement loginBtn;

	@FindBy(xpath = PageObjectsLocators.FORGOT_PASSWORD_LINK)
	public WebElement forgotPassLink;

	@FindBy(xpath = PageObjectsLocators.LOGIN_SUCESS_PAGE)
	public WebElement loginSuccessText;
	
	@FindBy(xpath = PageObjectsLocators.LOGIN_FAILURE)
	public WebElement loginFailure;

	public void loginLink() {
		loginLink.click();
	}

	public void loginEmail(String email) {
		emailTxtbox.sendKeys(email);
	}

	public void loginPassword(String password) {
		passwordTxtbox.sendKeys(password);
	}

	public void loginButton() {
		loginBtn.click();
	}

	public void forgotPassword() {
		forgotPassLink.click();
	}

	public void rememberMe() {
		rememberCheckBox.click();
	}

	public void loginSuccess() {

		if (loginSuccessText.isDisplayed()) {
			Assert.assertTrue(true, "Login successful");
		} else {
			Assert.assertTrue(false, "Login failure");
		}
	}
	
	public void  getLoginFailure() {	
		System.out.println("Error: "+loginFailure.getText());
	}

	/*
	 * public static String getFormId() { return
	 * !StringUtils.isBlank(formId.getText()) ? PageObjectsLocators.FORM_ID_1 +
	 * formId.getText() + PageObjectsLocators.FORM_ID_2 : PageObjectsLocators.BLANK;
	 * }
	 */

}
