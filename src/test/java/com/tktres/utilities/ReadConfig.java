package com.tktres.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {

		String url = pro.getProperty("baseURL");
		return url;

	}

	public String getLoginEmail() {

		String username = pro.getProperty("loginEmail");
		return username;
	}

	public String getLoginPassword() {

		String password = pro.getProperty("loginPassword");
		return password;
	}

	public String getRegisterUsername() {

		String registerUsername = pro.getProperty("registerId");
		return registerUsername;
	}

	public String getRegisterPassword() {

		String registerPassword = pro.getProperty("registerPass");
		return registerPassword;
	}

	public String getRegisterConfirmPassword() {

		String registerConfirmPassword = pro.getProperty("registerConfrimPass");
		return registerConfirmPassword;
	}

	public String getRegisterCompany() {

		String registerCompany = pro.getProperty("registerCompany");
		return registerCompany;
	}

	public String getregisterEmail() {

		String registerEmail = pro.getProperty("registerEmail");
		return registerEmail;
	}
	
	public String getNewUserEmail() {

		String username = pro.getProperty("registernewemail");
		return username;
	}

	public String getChromePath() {

		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFireFoxPath() {

		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getEdgePath() {

		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}

}
