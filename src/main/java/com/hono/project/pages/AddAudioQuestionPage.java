package com.hono.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hono.pages.BaseHonoAutomationPage;

public class AddAudioQuestionPage extends BaseHonoAutomationPage{

	@FindBy(xpath = "//h4[contains(text(),'Add Question')]")
	private WebElement addQuestion;

	// @FindBy(xpath = "(//select[@class='custom-select ng-pristine ng-valid
	// ng-touched'])[1]")
	@FindBy(xpath = "//div[@class='col-lg-12 type_questuo']")
	private WebElement type;

	@FindBy(xpath = "//option[contains(text(),'Employee Engagement Parameter')]")
	private WebElement employeeEngagementParameter;

	// @FindBy(xpath = "//select[@class='custom-select ng-valid ng-touched
	// ng-dirty']")
	@FindBy(xpath = "//select[@formcontrolname='parameter']")
	private WebElement selectEngagementparameter;

	// @FindBy(xpath = "//option[contains(text(),'Overall Experience')]")
	/*
	 * @FindBy(xpath =
	 * "//select[@class='custom-select ng-pristine ng-valid ng-touched']") private
	 * WebElement overallExperience;
	 */

	// @FindBy(xpath ="(//select[@class='custom-select ng-pristine ng-valid
	// ng-touched'])[2]")
	@FindBy(xpath = "//select[@formcontrolname='subParameter']")
	private WebElement selectSubparameter;

	@FindBy(xpath = "(//option[contains(text(),'Employee Engagement ')])[2]")
	private WebElement employeeEngagement;

	@FindBy(xpath = "(//select[@class='custom-select ng-pristine ng-valid ng-touched'])")
	private WebElement scale;

	// @FindBy(xpath = "//option[contains(text(),'Opinion Scale')]")
	@FindBy(xpath = "//select[@formcontrolname='scale']")
	private WebElement opinionScale;

	@FindBy(xpath = "//input[@formcontrolname='opinion_scale_min']")
	// @FindBy(xpath = "//div[@id='question-opinion-minimum-value']")
	private WebElement minimumValue;

	// @FindBy(xpath =
	// "//div[@id='question-opinion-maximum-value']//input[@class=\"form-control
	// seacrh-input ng-pristine ng-valid ng-touched\"]")
	// @FindBy(xpath = "//div[@id='question-opinion-maximum-value']")
	@FindBy(xpath = "//input[@formcontrolname=\"opinion_scale_max\"]")
	private WebElement maximumValue;
	
	
	
	@FindBy(xpath = "//span[contains(text(),'Audio')]")
	private WebElement audiobtn;
	
	
	@FindBy(xpath = "//input[@id='exampleInputFile']")
	private WebElement uploadAudio;
	
	


	// @FindBy(xpath = "(//input[@class='form-check-input ng-valid ng-dirty
	// ng-touched'])[1]")
	@FindBy(xpath = "//input[@formcontrolname='showDescription']")
	private WebElement addDescription;

	// @FindBy(xpath = "//textarea[@class='form-control ng-touched ng-pristine
	// ng-valid ng-star-inserted']")
	// @FindBy(xpath = "//textarea[@placeholder=\"How was your last month in the
	// organization?\"]")
	@FindBy(xpath = "//textarea[@formcontrolname='question_desc']")
	private WebElement addDescriptionText;

	// @FindBy(xpath = "(//input[@class='form-check-input ng-valid ng-dirty
	// ng-touched'])[2]")
	@FindBy(xpath = "//input[@formcontrolname='isOptional']")
	private WebElement isOptional;

	@FindBy(xpath = "//input[@formcontrolname='allowComments']")
	private WebElement allowComments;

	@FindBy(xpath = "//option[contains(text(),'<=2')]")
	private WebElement tow;

	@FindBy(xpath = "(//button[@class='btn btn-info btn-block btn-flat'])[5]")
	private WebElement saveQuestion;

	@FindBy(xpath = "//div[@class='ng-tns-c39-3 toast-title ng-star-inserted']")
	private WebElement questionAddedSuccessfully;
	
	
	
	public AddAudioQuestionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnAddQuestion() {
		this.clickOnWebElement(addQuestion);
		// this.addQuestion.click();
	}

	public void clickOnType() {
		this.clickOnWebElement(type);
		// this.type.click();
	}

	public void clickOnEmployeeEngagementParameter() {
		this.clickOnWebElement(employeeEngagementParameter);
		// this.employeeEngagementParameter.click();
	}

	public void clickOnSelectEngagementparameter() {
		this.clickOnWebElement(selectEngagementparameter);
		// this.selectEngagementparameter.click();
	}

	public void selectOverallExperience() {

		Select sel = new Select(driver.findElement(By.xpath("//select[@formcontrolname='parameter']")));

		sel.selectByVisibleText("Overall Experience");

	}

	public void clickOnselectSubparameter() {
		this.clickOnWebElement(selectSubparameter);
		// this.selectSubparameter.click();
	}

	public void clickOnEmployeeEngagement() {
		// this.clickOnWebElement(employeeEngagement);
		this.employeeEngagement.click();
	}

	public void clickOnScale() {
		this.clickOnWebElement(scale);
		// this.scale.click();
	}

	public void clickOnOpinionScale() {

		Select scale = new Select(driver.findElement(By.xpath("//select[@formcontrolname='scale']")));

		scale.selectByVisibleText("Opinion Scale");

		// this.opinionScale.click();
	}

	public void enterMinimumValue(String MinimumValue) {
		this.minimumValue.sendKeys(MinimumValue);
	}

	public void enterMaximumValue(String MaximumValue) {
		this.maximumValue.sendKeys(MaximumValue);
	}
	
	
	public void clickOnAudioButton() {
		this.clickOnWebElement(audiobtn);
		
	}
	
	public void uploadAudio() throws InterruptedException {
		uploadAudio.sendKeys("C:\\B2BNew\\automation-hono\\src\\test\\resources\\data\\Audio question.ogg");
	}
	


	public void clickOnAddDescription() {
		this.clickOnWebElement(addDescription);
		// this.addDescription.click();
	}

	public void enterAddDescriptionText(String AddDescriptionText) {
		this.addDescriptionText.sendKeys(AddDescriptionText);
	}

	public void clickOnIsOptional() {
		this.clickOnWebElement(isOptional);
		// this.isOptional.click();
	}

	public void clickOnAllowCommentsl() {
		this.clickOnWebElement(allowComments);
		// this.allowComments.click();
	}

	public void clickOnTow() {
		this.tow.click();
	}

	public void clickOnSaveQuestion() {
		this.clickOnWebElement(saveQuestion);
		// this.saveQuestion.click();
	}

	public String getQuestionAddedSuccessfullyText() {
		return questionAddedSuccessfully.getText();
	}
}
