package com.tktres.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tktres.locators.PageObjectsLocators;
import com.tktres.utilities.UtilitiesClass;

public class ChooseFlightPage {

	WebDriver ldriver;
	UtilitiesClass uc = new UtilitiesClass();

	public ChooseFlightPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = PageObjectsLocators.BOOKING_CHOOSE_FLIGHT_BUTTON)
	public WebElement bookingChooseFlightBtn;

	@FindBy(xpath = PageObjectsLocators.BOOKING_FLIGHT_TABLE)
	public WebElement bookingChooseFlightTable;

	public void getFlight() {
		uc.explicitWait(ldriver, bookingChooseFlightBtn, 2);
		bookingChooseFlightBtn.click();
	}

	public void getLowPriceFlight() {

		List<WebElement> headers = bookingChooseFlightTable.findElement(By.tagName("thead"))
				.findElements(By.tagName("th"));
		int priceColumnIndex = -1;
		for (int i = 0; i < headers.size(); i++) {
			if (headers.get(i).getText().equalsIgnoreCase("Price")) {
				priceColumnIndex = i;
				break;
			}
		}

		if (priceColumnIndex != -1) {
			List<WebElement> rows = bookingChooseFlightTable.findElements(By.tagName("tr"));
			double lowestPrice = Double.MAX_VALUE;
			WebElement lowestPriceRow = null;
			for (int i = 1; i < rows.size(); i++) { 
				WebElement row = rows.get(i);
				List<WebElement> cells = row.findElements(By.tagName("td"));
				String priceText = cells.get(priceColumnIndex).getText().replace("$", "").trim();
				double price = Double.parseDouble(priceText);
				if (price < lowestPrice) {
					lowestPrice = price;
					lowestPriceRow = row;
				}
			}
			if (lowestPriceRow != null) {
                System.out.println("\nDetails of the row with lowest price:");
                for (int i = 1; i < headers.size(); i++) {
                    System.out.print(headers.get(i).getText() + "\t");
                }
                System.out.println("\n");
                List<WebElement> cells = lowestPriceRow.findElements(By.tagName("td"));
                for (int i = 1; i < cells.size(); i++) {
                    System.out.print(cells.get(i).getText() + "\t");
                }
                System.out.println("\n");
				lowestPriceRow.findElement(By.xpath(PageObjectsLocators.BOOKING_CHOOSE_FLIGHT_BUTTON_GENERIC)).click();
			}
		}

	}

}
