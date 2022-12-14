package com.hono.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hono.pages.BaseHonoAutomationPage;
import org.openqa.selenium.interactions.Actions;

public class CreateSurveyPage extends BaseHonoAutomationPage {

	public CreateSurveyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='create-new-template']")
	private WebElement createnewtemplate;

	@FindBy(xpath = "//h1[contains(text(),'Create Survey')]")
	private WebElement createSurvey;

	@FindBy(xpath = "//input[@placeholder='Enter Survey Name']")
	private WebElement surveyName;

	@FindBy(xpath = "//input[@placeholder='Enter Description']")
	private WebElement description;

	@FindBy(xpath = "//select[@class='custom-select ng-pristine ng-valid ng-touched']")
	private WebElement selectCategory;

	@FindBy(xpath = "//option[contains(text(),'Employee Lifecycle')]")
	private WebElement employeeLifecycle;

	@FindBy(xpath = "//input[@id='expiryDate']")
	private WebElement expiryDate;

	
	@FindBy(xpath ="// div[@id='survey-add-language']//input[@type='checkbox']")
	//@FindBy(id = "survey-add-language")
	private WebElement addLanguage;

	@FindBy(xpath = "//option[contains(text(),'Telugu')]")
	private WebElement telugu;

	@FindBy(xpath = "(//button[@style='background-color: rgb(255, 255, 255); color: rgb(0, 0, 0); font-size: 16px; font-family: \"Abril Fatface\";'])[6]")
	// @FindBy(xpath = "//button[@class='btn btn-info btn-block btn-flat
	// ng-star-inserted']")
	private WebElement saveGeneralInfo;

	//@FindBy(xpath = "//div[@class='ng-tns-c39-3 toast-title ng-star-inserted']")
	@FindBy(xpath = "//div[@aria-label=\"Survey Initialize\"]")
	private WebElement surveyInitialize;

	public void clickOnCreateNewTemplate() {
		this.createnewtemplate.click();
	}

	public String getCreateSurveyText() {
		return createSurvey.getText();
	}

	public void enterSurveyName(String SurveyName) {
		this.surveyName.sendKeys(SurveyName);
	}

	public void enterDescription(String Description) {
		this.description.sendKeys(Description);
	}

	public void clickOnSelectCategory() {
		this.selectCategory.click();
	}

	public void clickOnEmployeeLifecycle() {
		this.employeeLifecycle.click();
	}

	public void enterExpiryDate(String ExpiryDate) {
		this.expiryDate.sendKeys(ExpiryDate);
	}

	/*
	 * public void clickOnAddLanguage() { //boolean checkbox =
	 * this.addLanguage.isSelected(); this.clickOnElement(addLanguage);
	 * //this..click(); //System.out.println(checkbox);
	 * 
	 * }
	 */
	
	public void clickOnAddLanguag() {
		this.clickOnWebElement(addLanguage);
	}
	
	public void clickOnTelugu() {
		this.telugu.click();
	}

	public void clickOnSaveGeneralInfo() {
		this.clickOnWebElement(saveGeneralInfo);
		//this.saveGeneralInfo.click();
	}

	
	public String getSurveyInitializeText() { 
		return surveyInitialize.getText();
	}
	 

	/*
	 * public String getSurveyInitializeText() { return getText(surveyInitialize); }
	 */

	
	
	
	public void clickOutside() {
		// logger.info("Starting of clickOutside method");

		Actions action = new Actions(driver);
		action.moveByOffset(0, 0).click().build().perform();

		// logger.info("Ending of clickOutside method");
	}

}
