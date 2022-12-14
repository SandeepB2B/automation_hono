package com.hono.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hono.pages.BaseHonoAutomationPage;

public class WelcomePage extends BaseHonoAutomationPage {

	@FindBy(xpath = "//i[@class=\"fa fa-camera welcomeIconBtn cameraIcon ng-star-inserted\"]")
	private WebElement welcomeLogo;

	@FindBy(xpath = "//iframe[@class='tox-edit-area__iframe']/../../../../../../preceding-sibling::div/editor/div/div/div/div/iframe")
	private WebElement txtIframe;

	// @FindBy(xpath =
	// "//iframe[@class='tox-edit-area__iframe']/../../../../../../following-sibling::div/editor/div/div/div/div/iframe")
	@FindBy(xpath = "//div[@id='welcome-description']//iframe")
	private WebElement iframe;

	// @FindBy(xpath = "//iframe[@id='tiny-angular_119056287381668764941820_ifr']")
	// @FindBy(xpath = "//body[@data-mce-placeholder='Welcome title here...']")
	@FindBy(xpath = "//body[@aria-placeholder=\"Welcome title here...\"]")
	private WebElement welcomeTitle;

	// @FindBy(xpath = "//iframe[@id='tiny-angular_953094152391668764941987_ifr']")
	@FindBy(xpath = "//body[@aria-placeholder='Welcome description here...']")
	private WebElement welcomeDescription;

	// @FindBy(xpath = "//div[@class='col-lg-12 save_btm mt-3']//button[text()='
	// Save ']")
	@FindBy(xpath = "//div[@class='col-lg-12 save_btm mt-3']//button[text()=' Update ']")
	private WebElement saveWelcomeInfo;

	@FindBy(xpath = "//div[@aria-label='Survey Data Saved Successfully']")
	private WebElement getSurveyDataSavedSuccessfull;

	public WelcomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void uploadWelcomeLogo() throws InterruptedException {
		welcomeLogo.sendKeys("C:\\B2BNew\\automation-hono\\src\\test\\resources\\data\\Welcome.jpg");
	}
	
	
	public void switchToIframe() {
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]")));
	}
	public void enterWelcomeTitle(String WelcomeTitle) {
		this.welcomeTitle.sendKeys(WelcomeTitle);
	}

	
	
	
	public void switchToIframe2() {
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@frameborder='0'])[2]")));
		
	}
	public void enterWelcomeDescription(String WelcomeDescription) {
		this.welcomeDescription.sendKeys(WelcomeDescription);
	}

	
	
	public void clickOnSaveWelcomeInfo() {
		//this.saveWelcomeInfo.click();
		driver.switchTo().defaultContent();
		this.clickOnWebElement(saveWelcomeInfo);
		
	}

	public String getSurveyDataSavedSuccessfullyText() {
		return getSurveyDataSavedSuccessfull.getText();
	}

}
