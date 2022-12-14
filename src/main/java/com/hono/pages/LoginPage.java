package com.hono.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseHonoAutomationPage {

	/*
	 * @FindBy(xpath = "//input[@placeholder='Enter Email or User Id']") private
	 * WebElement email;
	 */

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-block']")
	private WebElement Signin;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElement yes;

	@FindBy(xpath = "//a[contains(text(),'Forgot Password ?')]")
	private WebElement forgotPassword;

	@FindBy(xpath = "//input[@placeholder='Enter Email']")
	private WebElement email2;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submit;

	@FindBy(xpath = "//a[contains(text(),'Back To Login')]")
	private WebElement backToLogin;

	@FindBy(xpath = "//h1[text()='Dashboard']")
	private WebElement lblDashboard;

	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

	public LoginPage(WebDriver driver) {

		super(driver);

		PageFactory.initElements(driver, this);
	}

	public void setUserName(String strUserName) throws InterruptedException {
		logger.info("Starting of setUserName method");

		/*
		 * this.email.sendKeys(Keys.CONTROL + "a"); this.email.sendKeys(Keys.DELETE);
		 * 
		 * 
		 */
		
		
		highlight(driver, driver.findElement(By.xpath("//input[@placeholder='Enter Email or User Id']")));

	

		/*
		 * this.email.click(); this.email.clear();
		 */
		this.email.sendKeys(strUserName);

		logger.info("Ending of setUserName method");
	}

	public void setPassword(String strPassword) {
		logger.info("Starting of setPassword method");

		/*
		 * this.password.sendKeys(Keys.CONTROL + "a");
		 * this.password.sendKeys(Keys.DELETE);
		 */

		this.password.click();
		this.password.clear();
		this.password.sendKeys(strPassword);

		logger.info("Ending of setPassword method");
	}

	public void clickSignin() throws InterruptedException {
		logger.info("Starting of clickSignin method");

		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.moveToElement(Signin).click().build().perform();

		logger.info("Ending of clickSignin method");
	}

	public void clickYes() throws InterruptedException {
		logger.info("Starting of clickYes method");

		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.moveToElement(yes).click().build().perform();

		logger.info("Ending of clickYes method");
	}

	public String getHonoHomePageText() throws InterruptedException {

		Thread.sleep(3000);
		logger.info("Starting of getHonoHomePageTitle method");
		logger.info("Ending of getHonoHomePageTitle method");

		WebElement homePageText = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]"));

		return homePageText.getText();
	}

	public String getErrorToastText() throws InterruptedException {

		Thread.sleep(3000);
		logger.info("Starting of getErrorToast method");
		logger.info("Ending of getErrorToast method");

		WebElement errorToastText = driver.findElement(By.xpath("//div[contains(text(),'Invalid Credentials')]"));

		return errorToastText.getText();
	}

	public void clickOnForgotPassword() {
		this.forgotPassword.click();
	}

	public void enterEmail(String Email) {
		this.email2.sendKeys(Email);
	}

	public void clickOnSubmit() {
		this.submit.click();
	}

	public String getUserNotFoundToastText() throws InterruptedException {

		Thread.sleep(3000);
		logger.info("Starting of getUserNotFoundToast method");
		logger.info("Ending of getUserNotFoundToast method");

		WebElement userNotFoundToastText = driver.findElement(By.xpath("//div[contains(text(),'user not found')]"));

		return userNotFoundToastText.getText();
	}

	public void clickOnBackToLogin() {
		this.backToLogin.click();
	}

	public synchronized String getTextDashboard() {
		logger.info("Starting of getTextAreYouSure method");
		logger.info("Ending of getTextAreYouSure method");

		return lblDashboard.getText();
	}
}
