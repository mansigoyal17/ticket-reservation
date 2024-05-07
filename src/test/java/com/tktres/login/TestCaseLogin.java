package com.tktres.login;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tktres.pageObjects.BaseClass;
import com.tktres.pageObjects.LandingPage;
import com.tktres.pageObjects.LoginPage;
import com.tktres.utilities.UtilitiesClass;

public class TestCaseLogin extends BaseClass {

	@Test
	public void loginTest() /* throws IOException, InterruptedException */ {
		/*try {*/

			logger.info("<---Test Case 1--->");
			LandingPage lp = new LandingPage(driver);
			lp.home();
			LoginPage lop = new LoginPage(driver);
			logger.info("<---SignUp--->");
			lop.loginLink();
			UtilitiesClass uc = new UtilitiesClass();
			uc.explicitWait(driver, lop.emailTxtbox,5);			
			lop.emailTxtbox.clear();
			lop.loginEmail(email);
			uc.explicitWait(driver, lop.passwordTxtbox,5);			
			lop.passwordTxtbox.clear();
			lop.loginPassword(password);
			lop.rememberMe();
			lop.loginButton();
			
			uc.explicitWait(driver, lop.loginFailure, 5);
			lop.getLoginFailure();

			String expectedErrorMessage1 = "Please include an '@' in the email address. '" + email
					+ "' is missing an '@'.";
			String expectedErrorMessage2 = "Please fill out this field.";
			String expectedErrorMessage3 = "These credentials do not match our records.";
			String actualErrorMessage1 = lop.emailTxtbox.getAttribute("validationMessage");
			String actualErrorMessage2 = lop.passwordTxtbox.getAttribute("validationMessage");
			String actualErrorMessage3 = lop.emailTxtbox.getAttribute("validationMessage");
			if (actualErrorMessage1.contains(expectedErrorMessage1)) {
				System.out.println("Error message: " + actualErrorMessage1);
			} else if (actualErrorMessage1.contains(expectedErrorMessage2)) {
				System.out.println("Email field is empty: " + actualErrorMessage1);
			} else if (actualErrorMessage2.contains(expectedErrorMessage2)) {
				System.out.println("Password field is empty: " + actualErrorMessage2);
			}else if (actualErrorMessage3.contains(expectedErrorMessage3)) {
				System.out.println("Error message: " + actualErrorMessage2);
			}else {
				System.out.println("Validation error message is incorrect.");
			}
			
			uc.explicitWait(driver, lop.loginSuccessText,5);			
			lop.loginSuccess();
			

		} /*catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());

		}*/
}
