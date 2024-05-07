package com.tktres.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilitiesClass {
	
	public void explicitWait(WebDriver driver, WebElement element,long timeoutSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}

}
