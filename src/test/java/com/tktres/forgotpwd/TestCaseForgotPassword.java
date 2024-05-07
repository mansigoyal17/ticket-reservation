package com.tktres.forgotpwd;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tktres.pageObjects.BaseClass;
import com.tktres.pageObjects.ForgotPasswordPage;
import com.tktres.pageObjects.LandingPage;
import com.tktres.pageObjects.LoginPage;
import com.tktres.utilities.UtilitiesClass;

public class TestCaseForgotPassword extends BaseClass {
	
	@Test
	public void forgotPasswordTest() /* throws IOException, InterruptedException */ {
		/* try { */
		
			LandingPage lp = new LandingPage(driver);
			lp.home();
			LoginPage lop = new LoginPage(driver);
			lop.loginLink();
			UtilitiesClass uc = new UtilitiesClass();
			uc.explicitWait(driver, lop.forgotPassLink,5);
			lop.forgotPassword();
			ForgotPasswordPage fp = new ForgotPasswordPage(driver);
			uc.explicitWait(driver, fp.fpEmailTxtBox,5);
			fp.getEmailAddress(email);
			fp.getPassResetButton();

			String expectedErrorMessage1 = "Please include an '@' in the email address. '" + email
					+ "' is missing an '@'.";
			String expectedErrorMessage2 = "Please fill out this field.";
			String actualErrorMessage1 = fp.fpEmailTxtBox.getAttribute("validationMessage");
			if (actualErrorMessage1.contains(expectedErrorMessage1)) {
				System.out.println("Error message: " + actualErrorMessage1);
			} else if (actualErrorMessage1.contains(expectedErrorMessage2)) {
				System.out.println("Email field is empty: " + actualErrorMessage1);
			} else {
				System.out.println("Validation error message is incorrect.");
			}
			
			String expectedUrl="https://blazedemo.com/password/email";
			String currentUrl= driver.getCurrentUrl();

			if(expectedUrl.equalsIgnoreCase(currentUrl)) {
				Assert.assertTrue(true, "Password Reset Successful");
				System.out.println("Successful");
			}else {
				Assert.assertTrue(false, "Password Reset Failure");
				System.out.println("Failure");
			}
			
		}/*catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}*/

}
