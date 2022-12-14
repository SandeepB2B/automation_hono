package com.hono.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hono.pages.BaseHonoAutomationPage;

public class ThankyouPage extends BaseHonoAutomationPage {


	@FindBy(xpath = "//i[@class='fa fa-camera welcomeIconBtn cameraIcon ng-star-inserted']")
	private WebElement thankyouLogo;

	@FindBy(xpath = "//div[@id='welcome-description']//iframe")
	private WebElement iframe;

	@FindBy(xpath = "//body[@data-mce-placeholder='Thank you title here...']")
	private WebElement thankyouTitle;

	@FindBy(xpath = "//body[@data-mce-placeholder='Thank you message goes here...']")
	private WebElement thankyouMessage;

	//@FindBy(xpath = "(//button[@style='background-color: rgb(255, 255, 255); color: rgb(0, 0, 0); font-size: 16px; font-family: \"Abril Fatface\";'])[1]")
	@FindBy(xpath = "//div[@class='col-lg-12 save_btm1 mt-3']//button[text()=' Update ']")
	private WebElement saveThankyouInfo;

	@FindBy(xpath = "//div[@aria-label='Survey Data Saved Successfully']")
	private WebElement getSurveyDataSavedSuccessfull;


	public ThankyouPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}


	public void clickOnTankyouLogo() {
		this.thankyouLogo.click();
	}

	public void uploadThankyouLogo() throws InterruptedException {
		thankyouLogo.sendKeys("C:\\B2BNew\\automation-hono\\src\\test\\resources\\data\\Thankyou.png");
	}


	public void switchToIframe() {
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]")));
	}

	public void enterTankyouTitle(String TankyouTitle) {
		this.thankyouTitle.sendKeys(TankyouTitle);
	}

	public void switchToIframe2() {

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder='0'])[2]")));
	}

	public void enterTankyouMessage(String TankyouMessage) {
		this.thankyouMessage.sendKeys(TankyouMessage);
	}

	public void clickOnSaveTankyouInfo() {
		driver.switchTo().defaultContent();
		this.saveThankyouInfo.click();
	}

	public String getSurveyDataSavedSuccessfullyText() {
		return getSurveyDataSavedSuccessfull.getText();
	}

}
