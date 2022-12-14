package com.hono.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hono.pages.BaseHonoAutomationPage;

public class DesignPage extends BaseHonoAutomationPage {

	
	
	//@FindBy(xpath = "//a[@id='custom-tabs-four-profile-tab']")
	//@FindBy(xpath = "//div[@class='col-lg-3 right_tabstypeform right-canvas']//a[text()='Design']")	
	@FindBy(xpath = "//a[text()='Design']")
	private WebElement design;
	
	// Welcome & Thankyou section
	
	@FindBy(xpath = "//input[@class='form-check-input design_cutom']")
	private WebElement showUserName;
	
	@FindBy(xpath = "//select[@class='custom-select design_cutom ng-pristine ng-valid ng-touched']")
	private WebElement layout;
	
	@FindBy(xpath = "//option[contains(text(),'Top')]")
	private WebElement top;
	
	@FindBy(xpath = "//input[@class='slider design_cutom ng-pristine ng-valid ng-touched']")
	private WebElement imageSize;
	
	
	
	// Question section
	
	@FindBy(xpath = "(//i[@class='fa fa-bold'])[1]")
	private WebElement boldQuestion;
	
	@FindBy(xpath = "(//i[@class='fa fa-underline'])[1]")
	private WebElement underLineQuestion;
	
	@FindBy(xpath = "(//i[@class='fa fa-italic'])[1]")
	private WebElement italicQuestion;
	
	@FindBy(xpath = "//select[@formcontrolname='q_font_size']")
	private WebElement fontSize;	
	
	@FindBy(xpath = "(//option[@value='24'])[1]")
	private WebElement fontSize24;
	
	@FindBy(xpath = "//select[@class='custom-select design_cutom ng-valid ng-star-inserted ng-touched ng-dirty']")
	private WebElement fontFamily;
	
	@FindBy(xpath = "(//option[contains(text(),'Acme')])[1]")
	private WebElement selectQFontFamily;
	
	
	// Answer section
	
	@FindBy(xpath = "(//i[@class='fa fa-bold'])[2]")
	private WebElement boldAnswer;
	
	@FindBy(xpath = "(//i[@class='fa fa-underline'])[2]")
	private WebElement underLineAnswer;
	
	@FindBy(xpath = "(//i[@class='fa fa-italic'])[2]")
	private WebElement italicAnswer;
	
	@FindBy(xpath = "//select[@formcontrolname='a_font_size']")
	private WebElement aFontSize;
	
	@FindBy(xpath = "(//option[@value='22'])[2]")
	private WebElement aFontSize22;
	
	@FindBy(xpath = "(//select[@class='custom-select design_cutom ng-pristine ng-valid ng-star-inserted ng-touched'])[1]")
	private WebElement aFontFamily;
	
	@FindBy(xpath = "(//option[contains(text(),'Acme')])[2]")
	private WebElement selectAFontFamily;
	
	
	// Button section
	
	@FindBy(xpath = "(//i[@class='fa fa-bold'])[3]")
	private WebElement boldButton;
	
	@FindBy(xpath = "(//i[@class='fa fa-underline'])[3]")
	private WebElement underLineButton;
	
	@FindBy(xpath = "(//i[@class='fa fa-italic'])[3]")
	private WebElement italicButton;
	
	@FindBy(xpath = "//select[@formcontrolname='btn_font_size']")
	private WebElement bFontSize;
	
	@FindBy(xpath = "(//option[@value='16'])[3]")
	private WebElement bFontSize16;
	
	@FindBy(xpath = "(//select[@class='custom-select design_cutom ng-pristine ng-valid ng-star-inserted ng-touched'])[2]")
	private WebElement bFontFamily;
	
	@FindBy(xpath = "(//option[contains(text(),'Acme')])[3]")
	private WebElement selectBFontFamily;
	
	
	//Add Background section
	
	@FindBy(xpath = "//input[@id='backgrounImage']")
	private WebElement browse;
	
	@FindBy(xpath = "//input[@formcontrolname='backgroundOpacity']")
	private WebElement opacity;
	
	
	// Choose Template section
	
	@FindBy(xpath = "(//input[@name='templateType'])[1]")
	private WebElement chooseTemplateOneOnOne;
	
	
	//Choose Answer Pattern
	
	@FindBy(xpath = "(//input[@name='answer_Pattern'])[2]")
	private WebElement chooseAnswerPattern;
	
	// Alignment
	
	@FindBy(xpath = "//i[@class='fa fa-align-center']")
	private WebElement Alignment;
	
	//@FindBy(xpath = "(//button[@class='btn btn-info btn-block btn-flat'])[6]/parent::div/parent::div")
	@FindBy(xpath = "//div[@class='col-lg-12 questions_ntn']//button[text()=' Save ']")
	private WebElement saveDesign;
	
	@FindBy(xpath = "//div[@aria-label='Survey Data Saved Successfully']")
	private WebElement getSurveyDataSavedSuccessfull;
		
	
	
	//////////////////////////////////////////

	public DesignPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDesignButton() {
		this.clickOnWebElement(design);
		//this.design.click();
	}
	
	// Welcome & Thankyou section
	
	public void clickOnShowUserNameCheckbox() {
		this.showUserName.click();
	}
	
	public void clickOnLayoutDropdown() {
		this.layout.click();
	}	
	
	public void selectTop() {
		this.top.click();
	}	
	
	public void clickOnImageSize() {
		this.imageSize.click();
	}
	
	
	// Question section
	public void clickOnBoldOnQuestion() {
		this.boldQuestion.click();
	}
	
	public void clickOnUnderLineQuestion() {
		this.underLineQuestion.click();
	}
	
	public void clickOnItalicQuestion() {
		this.italicQuestion.click();
	}
	
	public void clickOnFontSizeQuestion() {
		this.fontSize.click();
	}
	
	public void selectFontSizeQuestion() {
		this.fontSize24.click();
	}
	
	public void clickOnFontFamilyQuestion() {
		this.fontFamily.click();
	}
	
	public void selectQFontFamily() {
		this.selectQFontFamily.click();
	}
	
	
	// Answer section
	
	public void clickOnBoldAnswer() {
		this.boldAnswer.click();
	}
	
	public void clickOnUnderLineAnswer() {
		this.underLineAnswer.click();
	}
	
	public void clickOnItalicAnswer() {
		this.italicAnswer.click();
	}
	
	public void clickOnAFontSize() {
		this.aFontSize.click();
	}
	
	public void selectAFontSize() {
		this.aFontSize22.click();
	}
	
	public void clickOnAFontFamily() {
		this.aFontFamily.click();
	}
	
	public void selectAFontFamily() {
		this.selectAFontFamily.click();
	}	
	
	
	// Button section
	
	public void clickOnBoldButton() {
		this.boldButton.click();
	}
	
	public void clickOnUnderLineButton() {
		this.underLineButton.click();
	}
	
	public void clickOnItalicButton() {
		this.italicButton.click();
	}
	
	public void clickOnBFontSize() {
		this.bFontSize.click();
	}
	
	public void selectBFontSize() {
		this.bFontSize16.click();
	}
	
	public void clickOnBFontFamily() {
		this.bFontFamily.click();
	}
	
	public void selectBFontFamily() {
		this.selectBFontFamily.click();
	}	
	
	
	//Add Background section
	
	public void clickOnBrowseAddBackground() {
		this.browse.click();
	}
	
	public void clickOnOpacity() {
		this.opacity.click();
	}
	
	
	// Choose Template section
	
	public void selectTemplateOneOnOne() {
		this.chooseTemplateOneOnOne.click();
	}
	
	//Choose Answer Pattern
	
	public void selectAnswerPatternHorizontal() {
		this.chooseAnswerPattern.click();
	}
	
	// Alignment
	
	public void setAlignment() {
		this.Alignment.click();
	}
	
	
	public void clickOnSaveDesign() {
		//this.saveDesign.click();
		this.clickOnWebElement(saveDesign);
	}
	
	public String getSurveyDataSavedSuccessfullyText() {
		return getSurveyDataSavedSuccessfull.getText();
	}
	
	
}
