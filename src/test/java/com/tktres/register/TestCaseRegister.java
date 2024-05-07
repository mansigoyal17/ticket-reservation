package com.tktres.register;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tktres.pageObjects.BaseClass;
import com.tktres.pageObjects.LandingPage;
import com.tktres.pageObjects.RegisterPage;
import com.tktres.utilities.UtilitiesClass;

public class TestCaseRegister extends BaseClass {

	@Test
	public void registerTest() {
		try {
			logger.info("<---Test Case 2--->");
			LandingPage lp = new LandingPage(driver);
			lp.home();
			RegisterPage rp = new RegisterPage(driver);
			logger.info("<---SignUp--->");
			UtilitiesClass uc = new UtilitiesClass();
			uc.explicitWait(driver, rp.registerLink, 6);
			rp.regsiterLink();
			uc.explicitWait(driver, rp.nameTxtbox, 3);
			rp.nameTxtbox.clear();
			rp.regsiterUsername(registerUsername);
			uc.explicitWait(driver, rp.companyTxtbox, 3);
			rp.companyTxtbox.clear();
			rp.regsiterCompany(registerCompany);
			uc.explicitWait(driver, rp.emailTxtbox, 3);
			rp.emailTxtbox.clear();
			rp.regsiterEmail(registerEmail);
			uc.explicitWait(driver, rp.passwordTxtbox, 3);
			rp.passwordTxtbox.clear();
			rp.regsiterPassword(registerPassword);
			uc.explicitWait(driver, rp.confirmPassTxtbox, 3);
			rp.confirmPassTxtbox.clear();
			rp.regsiterConfirmPassword(registerConfirmPassword);
			rp.registerButton();

			try {
				uc.explicitWait(driver, rp.registerEmailExists, 5);
				if (rp.registerEmailExists != null) {
					System.out.println("Error: " + rp.registerEmailExists.getText());
					rp.emailTxtbox.clear();
					rp.getNewEmail(registerNewEmail);
					rp.regsiterPassword(registerPassword);
					rp.regsiterConfirmPassword(registerConfirmPassword);
					rp.registerButton();
				}
			} catch (org.openqa.selenium.TimeoutException e) {
				System.out.println("Email does not exist");
			}

			try {
				uc.explicitWait(driver, rp.registerPassMismatch, 5);
				if (rp.registerPassMismatch != null) {
					System.out.println("Error: " + rp.registerPassMismatch.getText());
					rp.getNewRegisterPassword();
					rp.registerButton();
				}
			} catch (org.openqa.selenium.TimeoutException e) {
				System.out.println("No password mismatch");
			}

			try {
				uc.explicitWait(driver, rp.registerPassLength, 5);
				if (rp.registerPassLength != null) {
					System.out.println("Error message:" + rp.getPassLengthError());
					rp.getNewRegisterPassword();
					rp.registerButton();
				}
			} catch (org.openqa.selenium.TimeoutException e) {
				System.out.println("No password length issue");
			}

			/*
			 * if (rp.registerEmailExists.isDisplayed()) { rp.emailTxtbox.clear();
			 * rp.getNewEmail(registerNewEmail); rp.regsiterPassword(registerPassword);
			 * rp.regsiterConfirmPassword(registerConfirmPassword); rp.registerButton(); }
			 * else if (rp.registerPassMismatch.isDisplayed()) {
			 * rp.regsiterPassword(registerPassword);
			 * rp.regsiterConfirmPassword(registerConfirmPassword); rp.registerButton(); }
			 * else if (rp.registerPassLength.isDisplayed()) {
			 * System.out.println("Error message:" + rp.getPassLengthError()); } else {
			 * rp.registerSuccess(); }
			 */

			rp.registerSuccess();

		} catch (NoSuchElementException e) {
			System.out.println("Exception: " + e.getMessage());

		}
	}
}
