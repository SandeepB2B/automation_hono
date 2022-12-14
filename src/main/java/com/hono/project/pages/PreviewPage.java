package com.hono.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hono.pages.BaseHonoAutomationPage;

public class PreviewPage extends BaseHonoAutomationPage{


	//@FindBy(xpath = "//div[@id='preview-button']")
	@FindBy(xpath = "//button[@style='float: right; background-color: rgb(255, 255, 255); color: rgb(0, 0, 0); font-size: 16px; font-family: \"Abril Fatface\";']")
	private WebElement preview;

	//@FindBy(xpath = "//label[contains(text(),'Telugu')]/parent::div")
	@FindBy(xpath = "(//input[@name='exampleRadios'])[2]")
	private WebElement telugu;

	//@FindBy(xpath = "//button[@class='btn btn-info btn-block btn-flat mt-2']")
	@FindBy(xpath = "//button[contains(text(),'Start')]")
	private WebElement start;

	@FindBy(xpath = "//div[contains(text(),'5')]")
	private WebElement select5;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	private WebElement next;

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement submit;

	@FindBy(xpath = "//i[@class='fa fa-times']")
	private WebElement close;

	@FindBy(xpath = "//div[@id='publish-button']")
	private WebElement publish;

	@FindBy(xpath = "//div[@aria-label='Survey published successfully!']")
	private WebElement getSurveyPublishedSuccessfull;


	public PreviewPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}


	public void clickOnPreview() {
		this.clickOnWebElement(preview);
		//this.preview.click();
	}

	public void clickOnTeluguRadioButton() {
		this.clickOnWebElement(telugu);
		//this.telugu.click();
	}

	public void clickOnStartPreview() {
		this.clickOnWebElement(start);
		//this.start.click();
	}

	public void select5() {
		//this.select5.click();
		this.clickOnWebElement(select5);
	}

	public void clickOnNext() {
		//this.next.click();
		this.clickOnWebElement(next);
	}

	public void clickOnSubmit() {
		//this.submit.click();
		this.clickOnWebElement(submit);
	}

	public void clickOnClosePreview() {
		//this.close.click();
		this.clickOnWebElement(close);
	}

	public void clickOnPublishSurvey() {
		this.clickOnWebElement(publish);
		//this.publish.click();
	}

	public String getSurveyPublishedSuccessfullyText() {
		return getSurveyPublishedSuccessfull.getText();
	}


}
