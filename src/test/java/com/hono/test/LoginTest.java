package com.hono.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hono.pages.LoginPage;




public class LoginTest extends BaseHonoAutomationTest{

	private WebDriver driver = null;

	private static final Logger logger = Logger.getLogger(LoginTest.class.getName());
	
	
	@Parameters({"siteURL","browser"})
	@BeforeClass
	
	public void initHonoLogin(String siteURL,String browser) throws Exception {

		logger.info("Starting of initHonoLogin method in LoginTest");

		this.driver = this.getWebDriver(browser);

		this.loginPage = new LoginPage(driver);
		
		this.goToSite(driver, siteURL);

		this.siteLogin(siteURL,driver);

		logger.info("Ending of initHonoLogin method in LoginTest");
	}
	
	
	@Test(priority = 1, description = "Login Test")
	@Parameters({"validUserName", "validPassword", "invalidUserName", "invalidPassword"})
	public void loginTest(String validUserName, String validPassword, String invalidUserName, String invalidPassword) throws InterruptedException {

		
		this.loginPage = new LoginPage(driver);
		
		// login with invalid mail id, valid password
		
		this.loginPage.setUserName(invalidUserName);
		this.loginPage.setPassword(validPassword);
		this.loginPage.clickSignin();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		this.loginPage.getErrorToastText();
		Thread.sleep(5000);
		
		
		/*
		 * // login with valid mail id, invalid password
		 * this.loginPage.setUserName(validUserName);
		 * this.loginPage.setPassword(invalidPassword); this.loginPage.clickSignin();
		 * driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 * this.loginPage.getErrorToastText(); Thread.sleep(5000);
		 * 
		 * // login with invalid mail id, invalid password
		 * this.loginPage.setUserName(invalidUserName);
		 * this.loginPage.setPassword(invalidPassword); this.loginPage.clickSignin();
		 * driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 * this.loginPage.getErrorToastText(); Thread.sleep(5000);
		 */
		
		// Forgot Password?
		
		this.loginPage.clickOnForgotPassword();
		this.loginPage.enterEmail(invalidUserName);
		this.loginPage.clickOnSubmit();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		this.loginPage.getUserNotFoundToastText();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		this.loginPage.clickOnBackToLogin();
		
		
		// Login with invalid credentials
		
		this.loginPage.setUserName(validUserName);
		this.loginPage.setPassword(validPassword); 
		this.loginPage.clickSignin();
		this.loginPage.clickYes(); 
		this.loginPage.getHonoHomePageText();

	}
	
	 @AfterClass
	    
	    public void quitDriver() {
	    	
	    	driver.quit();
	    }
	
}
