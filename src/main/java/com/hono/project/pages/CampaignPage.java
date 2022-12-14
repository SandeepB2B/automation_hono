package com.hono.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hono.pages.BaseHonoAutomationPage;

public class CampaignPage extends BaseHonoAutomationPage{


	@FindBy(xpath = "//h1[contains(text(),'Campaign')]")
	private WebElement campaign;

	@FindBy(xpath = "//input[@placeholder='Enter Your Campaign Title']")
	private WebElement campaignTitle;	

	@FindBy(xpath = "//select[@class='custom-select ng-pristine ng-valid ng-touched']")
	private WebElement selectCampaignType;	

	@FindBy(xpath = "//option[contains(text(),'Only Once')]")
	private WebElement onlyOnce;	

	@FindBy(xpath = "//div[@class=\"multiselect-dropdown\"]")
	private WebElement modes;	

	@FindBy(xpath = "//input[@aria-label=\"EMAIL\"]")
	private WebElement email;		

	@FindBy(xpath = "//select[@formcontrolname=\"timeZone\"]")
	private WebElement timezone;	


	@FindBy(xpath = "//select[@formcontrolname=\"scheduleMode\"]")
	private WebElement scheduleMode;

	@FindBy(xpath = "//option[contains(text(),'Now')]")
	private WebElement now;


	@FindBy(xpath = "//input[@placeholder='Enter Subject']")
	private WebElement mailSubject;


	//@FindBy(xpath = "//iframe[@id='tiny-angular_905712206141669617491781_ifr']")
	@FindBy(xpath = "//iframe[@class='tox-edit-area__iframe']")
	private WebElement iframe;

	//@FindBy(xpath = "//iframe[@id='tiny-angular_71863442331668833110171_ifr']")
	//@FindBy(xpath = "//iframe[@class='tox-edit-area__iframe']")
	@FindBy(xpath = "//body[@data-mce-placeholder='Type here...']")
	private WebElement emailMessage;

	@FindBy(xpath = "//label[contains(text(),' Save Template ')]")
	private WebElement saveTemplate;

	@FindBy(xpath = "//input[@placeholder='Enter template name']")
	private WebElement templateName;

	@FindBy(xpath = "(//button[@class='btn btn-info btn-flat'])[3]")
	private WebElement saveTemplateButton;	

	@FindBy(xpath = "//a[contains(text(),'Region')]")
	private WebElement region;	

	@FindBy(xpath = "//input[@value=\"North\"]")
	private WebElement north;	

	@FindBy(xpath = "//a[contains(text(),'department')]")
	private WebElement department;	

	@FindBy(xpath = "//input[@value=\"Product\"]")
	private WebElement product;	

	@FindBy(xpath = "//a[contains(text(),'gender')]")
	private WebElement gender;	

	@FindBy(xpath = "//input[@value=\"Male\"]")
	private WebElement male;	

	@FindBy(xpath = "//a[contains(text(),'testing')]")
	private WebElement testing;

	@FindBy(xpath = "//label[contains(text(),'testing')]")
	private WebElement testingCheckbox;

	@FindBy(xpath = "(//button[@class=\"btn btn-info btn-flat\"])[3]")
	private WebElement sendSurvey;

	@FindBy(xpath = "//div[@aria-label=\"New Campaign created successfully\"]")
	private WebElement getNewCampaigncreatedsuccessfully;

	//@FindBy(xpath = "//div[@id='publish-button']")
	@FindBy(xpath = "(//button[@class='btn btn-info btn-block btn-flat'])[3]")
	private WebElement publish;

	public CampaignPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);	
	}

	public String getCampaignText() {
		return campaign.getText();
	}

	public void enterCampaignTitle(String CampaignTitle) {
		this.campaignTitle.sendKeys(CampaignTitle);
	}

	public void clickOnSelectCampaignType() {
		this.selectCampaignType.click();
	}

	public void selectOnlyOnce() {
		this.onlyOnce.click();
	}

	public void clickOnModesDropdown() {
		this.modes.click();
	}

	public void selectEmail() {
		//this.email.click();
		this.clickOnWebElement(email);
	}

	public void clickOnTimezone() {
		this.timezone.click();
	}

	public void clickOnScheduleMode() {
		this.scheduleMode.click();
	}

	public void selectNow() {
		this.now.click();
	}

	public void enterMailSubject(String MailSubject) {
		this.mailSubject.sendKeys(MailSubject);
	}


	public void switchToIframe() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='tiny-angular_905712206141669617491781_ifr']"))); }


	/*
	 * public void enterEmailMessage(String EmailMessage) {
	 * this.emailMessage.sendKeys(EmailMessage); }
	 */

	public void enterEmailMessage(String EmailMessage) {


		try {
			driver.switchTo().frame(iframe);
			Thread.sleep(3000);
			this.emailMessage.sendKeys(EmailMessage);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();

		} catch (Exception e) {
		}

	}

	public void clickOnSaveTemplate() {
		this.clickOnWebElement(saveTemplate);
		//this.saveTemplate.click();
	}

	public void enterTemplateName(String EnterTemplateName) {
		this.templateName.sendKeys(EnterTemplateName);
	}

	public void clickOnSaveTemplatebutton() {
		//this.saveTemplateButton.click();
		this.clickOnWebElement(saveTemplateButton);
	}

	public void clickOnRegion() {
		this.clickOnWebElement(region);
		//this.region.click();
	}

	public void selectNorth() {
		this.clickOnWebElement(north);
		//this.north.click();
	}

	public void clickOnDepartment() {
		this.department.click();
		this.clickOnWebElement(department);
	}

	public void selectProduct() {
		//this.product.click();
		this.clickOnWebElement(product);
	}

	public void clickOnGender() {
		this.clickOnWebElement(gender);
		//this.gender.click();
	}

	public void selectMale() {
		//this.male.click();
		this.clickOnWebElement(male);
	}

	public void clickOnTesting() {
		//this.testing.click();
		this.clickOnWebElement(testing);
	}

	public void selectTestingCheckbox() {
		//this.testingCheckbox.click();
		this.clickOnWebElement(testingCheckbox);
	}

	public void clickOnSendSurvey() {
		//this.sendSurvey.click();
		this.clickOnWebElement(sendSurvey);
	}

	public String getNewCampaigncreatedsuccessfullyText() {
		return getNewCampaigncreatedsuccessfully.getText();
	}

	public void clickOnPublishSurvey() {
		this.clickOnWebElement(publish);
		//this.publish.click();
	}

}