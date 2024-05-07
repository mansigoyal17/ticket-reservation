package com.tktres.pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.tktres.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String email = readconfig.getLoginEmail();
	public String password = readconfig.getLoginPassword();
	public String registerUsername = readconfig.getRegisterUsername();
	public String registerPassword = readconfig.getRegisterPassword();
	public String registerConfirmPassword = readconfig.getRegisterConfirmPassword();
	public String registerEmail = readconfig.getregisterEmail();
	public String registerCompany = readconfig.getRegisterCompany();
	public String registerNewEmail = readconfig.getNewUserEmail();
	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws Exception {

		logger = Logger.getLogger("ticketReservation");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(chromeOptions);
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new FirefoxDriver(firefoxOptions);
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new EdgeDriver();
		} else {
			throw new Exception("Incorrect Browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown() {
		System.out.print("\n>>>>>QUITTING<<<<");
		driver.quit();
	} 

}
