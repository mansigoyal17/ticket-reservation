package com.tktres.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tktres.locators.PageObjectsLocators;
import com.tktres.utilities.UtilitiesClass;

public class ConfirmationPage {
	
	WebDriver ldriver;
	UtilitiesClass uc = new UtilitiesClass();

	public ConfirmationPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = PageObjectsLocators.CONFRIM_TEXT)
	public WebElement confirmText;
	
	@FindBy(xpath = PageObjectsLocators.CONFRIM_TABLE)
	public WebElement confirmTable;
	
	public void getConfirmation() {
		uc.explicitWait(ldriver, confirmText, 3);
		if(confirmText.isDisplayed()) {
			Assert.assertTrue(true, "Booking confirmed");
			System.out.println("Booking confirmed");
		}else {
			Assert.assertTrue(false, "Booking failed");
			System.out.println("Booking failed");
		}
	}
	
	public void getConfirmedFlightDetails() {

        // Get all rows of the table
        List<WebElement> rows = confirmTable.findElements(By.tagName("tr"));

        // Iterate through the rows
        for (WebElement row : rows) {
            // Get all cells of the current row
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Process cell data
            for (WebElement cell : cells) {
                // Print cell text
                System.out.print(cell.getText() + "\t");
            }
            // Move to the next line for the next row
            System.out.println();
        }
	}

}
