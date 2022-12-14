package com.hono.project.test;

import javax.swing.text.Highlighter.Highlight;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hono.pages.LoginPage;
import com.hono.project.pages.AddAudioQuestionPage;
import com.hono.project.pages.AddImageQuestionPage;
import com.hono.project.pages.AddQuestionPage;
import com.hono.project.pages.AddVideoQuestionPage;
import com.hono.project.pages.CampaignPage;
import com.hono.project.pages.CreateSurveyPage;
import com.hono.project.pages.DesignPage;
import com.hono.project.pages.PreviewPage;
import com.hono.project.pages.ThankyouPage;
import com.hono.project.pages.WelcomePage;
import com.hono.test.BaseHonoAutomationTest;

public class CreateSurveyTest extends BaseHonoAutomationTest {

	private WebDriver driver = null;

	private CreateSurveyPage createSurveyPage = null;
	private AddQuestionPage addQuestionPage = null;
	private DesignPage designpage = null;
	private WelcomePage welcomePage = null;
	private ThankyouPage thankyouPage = null;
	private PreviewPage previewPage = null;
	private CampaignPage campaignPage = null;
	private AddImageQuestionPage addImageQuestionPage = null;
	private AddAudioQuestionPage addAudioQuestionPage = null; 
	private AddVideoQuestionPage addVideoQuestionPage = null;

	private static final Logger logger = Logger.getLogger(CreateSurveyTest.class.getName());

	@Parameters({ "siteURL", "browser" })
	@BeforeClass

	public void initHonoLogin(String siteURL, String browser) throws Exception {

		logger.info("Starting of initHonoLogin method in LoginTest");

		this.driver = this.getWebDriver(browser);

		this.loginPage = new LoginPage(driver);

		this.createSurveyPage = new CreateSurveyPage(driver);
		this.addQuestionPage = new AddQuestionPage(driver);
		this.designpage = new DesignPage(driver);
		this.welcomePage = new WelcomePage(driver);
		this.thankyouPage = new ThankyouPage(driver);
		this.previewPage = new PreviewPage(driver);
		this.campaignPage = new CampaignPage(driver);
		this.addImageQuestionPage = new AddImageQuestionPage(driver);
		this.addAudioQuestionPage = new AddAudioQuestionPage(driver);
		this.addVideoQuestionPage = new AddVideoQuestionPage(driver);

		this.goToSite(driver, siteURL);
		this.siteLogin(siteURL, driver);

		logger.info("Ending of initHonoLogin method in LoginTest");
	}

	@Test(priority = 1, description = "Login Test")
	@Parameters({ "validUserName", "validPassword" })
	public void loginTest(String validUserName, String validPassword) throws InterruptedException {

		this.loginPage = new LoginPage(driver);
		this.loginPage.setUserName(validUserName);
		this.loginPage.setPassword(validPassword);
		this.loginPage.clickSignin();
		this.loginPage.clickYes();
		this.loginPage.getHonoHomePageText();

		Thread.sleep(3000);
	}

	@Test(priority = 2, description = "Create Survey Test")
	public void clickOnCreaNewTemplateTest() throws InterruptedException {

		logger.info("Starting of selectCreateNewTemplate method");
		Assert.assertEquals(loginPage.getTextDashboard(), expectedAssertionsProp.getProperty("Dashboard.Text"));
		this.createSurveyPage.clickOnCreateNewTemplate();
		logger.info("Ending of selectCreateNewTemplate method");

	}

	@Test(priority = 3)
	public void verifycreateSurveyText() throws InterruptedException {

		logger.info("Starting of verifyCreateSurveyText");
		/*
		 * String actualTitle = this.createSurveyPage.getCreateSurveyText();
		 * Assert.assertEquals(actualTitle,
		 * expectedAssertionsProp.getProperty("Create.Survey.Text"));
		 */
		Assert.assertEquals(createSurveyPage.getCreateSurveyText(), expectedAssertionsProp.getProperty("Create.Survey.Text"));
		logger.info("Ending  of verifyCreateSurveyText");
	}

	@Test(priority = 4) 
	public void addGeneralInfoTest() throws InterruptedException {

		logger.info("Starting of GeneralInformationTest method");
		createSurveyPage.enterSurveyName(testDataProp.getProperty("surveyName"));
		createSurveyPage.enterDescription(testDataProp.getProperty("description"));
		// this.createSurveyPage.clickOnSelectCategory();
		createSurveyPage.clickOnEmployeeLifecycle();
		createSurveyPage.enterExpiryDate(testDataProp.getProperty("expiryDate"));
		createSurveyPage.clickOnAddLanguag(); 
		createSurveyPage.scrollDown(200);
		createSurveyPage.clickOnTelugu();
		createSurveyPage.clickOnSaveGeneralInfo();
		Thread.sleep(2000);
		logger.info("Ending  of GeneralInformationTest method"); 
	}

	@Test(priority = 5) 
	public void verifySurveyInitializeText() {

		String toastMessage = this.createSurveyPage.getSurveyInitializeText();
		Assert.assertEquals(toastMessage,expectedAssertionsProp.getProperty("Survey.Initialize.Text"));
		//Assert.assertEquals(createSurveyPage.getSurveyInitializeText(),expectedAssertionsProp.getProperty("Survey.Initialize.Text"));

	}

	@Test(priority = 6)
	public void addQuestionTest() {

		logger.info("Starting of QuestionTest method");
	
		addQuestionPage.selectOverallExperience();
		addQuestionPage.clickOnEmployeeEngagement();
		addQuestionPage.clickOnOpinionScale();
		addQuestionPage.enterMinimumValue(testDataProp.getProperty("minimumValue"));
		addQuestionPage.enterMaximumValue(testDataProp.getProperty("maximumValue"));
		addQuestionPage.enterAddQuestions(testDataProp.getProperty("addQuestions"));
		addQuestionPage.scrollDown(200);
		addQuestionPage.clickOnAddDescription();
		addQuestionPage.enterAddDescriptionText(testDataProp.getProperty("addDescriptionText"));
		addQuestionPage.clickOnIsOptional();
		addQuestionPage.clickOnAllowCommentsl();
		addQuestionPage.clickOnTow();
		addQuestionPage.clickOnSaveQuestion();
		logger.info("Ending of QuestionTest method");
	}

	@Test(priority = 7) 
	public void verifyQuestionAddedSuccessfullyText(){
		logger.info("Starting of QuestionAddedSuccessfully method");
		String actualTitle = this.addQuestionPage.getQuestionAddedSuccessfullyText(); 
		Assert.assertEquals(actualTitle, expectedAssertionsProp.getProperty("Question.Added.Successfully.Text"));
		logger.info("Ending of QuestionAddedSuccessfully method"); 
	}

	@Test(priority = 8)
	public void addImageQuestionTest() throws InterruptedException {

		logger.info("Starting of Image QuestionTest method");
		addImageQuestionPage.clickOnAddQuestion();
		Thread.sleep(3000);
		addImageQuestionPage.selectOverallExperience();
		addImageQuestionPage.clickOnEmployeeEngagement();
		addImageQuestionPage.clickOnOpinionScale();
		addImageQuestionPage.enterMinimumValue(testDataProp.getProperty("minimumValue"));
		addImageQuestionPage.enterMaximumValue(testDataProp.getProperty("maximumValue"));
		addImageQuestionPage.clickOnImageButton();
		addImageQuestionPage.uploadImage();
		Thread.sleep(10000);
		addImageQuestionPage.scrollDown(200);
		addImageQuestionPage.clickOnIsOptional();
		addImageQuestionPage.clickOnSaveQuestion();
		logger.info("Ending of Image QuestionTest method");
	}

	@Test(priority = 9) 
	public void addAudioQuestionTest() throws InterruptedException {

		logger.info("Starting of Audio QuestionTest method");
		addAudioQuestionPage.clickOnAddQuestion();
		Thread.sleep(3000);
		addAudioQuestionPage.selectOverallExperience();
		addAudioQuestionPage.clickOnEmployeeEngagement();
		addAudioQuestionPage.clickOnOpinionScale();
		addAudioQuestionPage.enterMinimumValue(testDataProp.getProperty("minimumValue"));
		addAudioQuestionPage.enterMaximumValue(testDataProp.getProperty("maximumValue"));
		addAudioQuestionPage.clickOnAudioButton();
		addAudioQuestionPage.uploadAudio();
		addAudioQuestionPage.scrollDown(200);
		Thread.sleep(10000);
		addAudioQuestionPage.clickOnIsOptional();
		addAudioQuestionPage.clickOnSaveQuestion();
		logger.info("Ending of Audio QuestionTest method");
	}

	@Test(priority = 10) 
	public void addVideoQuestionTest() throws InterruptedException {

		logger.info("Starting of Video QuestionTest method");
		addVideoQuestionPage.clickOnAddQuestion();
		Thread.sleep(3000);
		addVideoQuestionPage.selectOverallExperience();
		addVideoQuestionPage.clickOnEmployeeEngagement();
		addVideoQuestionPage.clickOnOpinionScale();
		addVideoQuestionPage.enterMinimumValue(testDataProp.getProperty("minimumValue"));
		addVideoQuestionPage.enterMaximumValue(testDataProp.getProperty("maximumValue"));
		addVideoQuestionPage.clickOnVideoButton();
		addVideoQuestionPage.uploadVideo();
		addVideoQuestionPage.scrollDown(200);
		Thread.sleep(10000);
		addVideoQuestionPage.clickOnIsOptional();
		addAudioQuestionPage.clickOnSaveQuestion();
		logger.info("Ending of Video QuestionTest method");
	}

	@Test(priority = 11) 
	public void setDesignTest() throws InterruptedException {

		logger.info("Starting of Set Design method");
		designpage.clickOnDesignButton();
		designpage.scrollDown(500);
		designpage.clickOnSaveDesign();
		logger.info("Ending of Set Design method"); 
	}

	@Test(priority = 12) public void verifySurveyDataSavedSuccessfullyText() throws InterruptedException {

		logger.info("Starting of verifySurveyDataSavedSuccessfullyText method");
		
		String actualTitle = this.designpage.getSurveyDataSavedSuccessfullyText();
		Assert.assertEquals(actualTitle,
				expectedAssertionsProp.getProperty("Survey.Data.Saved.Successfully.Text"));

		logger.info("Ending of verifySurveyDataSavedSuccessfullyText method"); 
	}

	@Test(priority = 13) 
	public void welcomeContentTest() throws	InterruptedException {

		logger.info("Starting of Add Welcome tab method");

		try {
			welcomePage.uploadWelcomeLogo();
		} catch (Exception e) {
			System.out.println(e);
		}

		welcomePage.switchToIframe();
		welcomePage.enterWelcomeTitle(testDataProp.getProperty("welcomeTitle"));
		welcomePage.switchToIframe2();
		welcomePage.enterWelcomeDescription(testDataProp.getProperty("welcomeDescription"));
		welcomePage.clickOnSaveWelcomeInfo();

		logger.info("Ending of Add Welcome tab method"); 
	}

	@Test(priority = 14) 
	public void verifySurveyDataSavedSuccessfully2Text() throws InterruptedException {
		
		String actualTitle = this.welcomePage.getSurveyDataSavedSuccessfullyText();
		Assert.assertEquals(actualTitle,
				expectedAssertionsProp.getProperty("Survey.Data.Saved.Successfully.Text")); 
	}

	@Test(priority = 15) 
	public void thankyouContentTest() {

		logger.info("Starting of Add Thankyou Content method");
		thankyouPage.switchToIframe();
		thankyouPage.enterTankyouTitle(testDataProp.getProperty("thankyouTitle"));
		thankyouPage.switchToIframe2();
		thankyouPage.enterTankyouMessage(testDataProp.getProperty("thankyouMessage")); 
		thankyouPage.clickOnSaveTankyouInfo();
		logger.info("Ending of Add Thankyou Content method");

	}

	@Test(priority = 16) 
	public void verifySurveyDataSavedSuccessfully3Text() {
		
		String actualTitle = this.thankyouPage.getSurveyDataSavedSuccessfullyText();
		Assert.assertEquals(actualTitle,
				expectedAssertionsProp.getProperty("Survey.Data.Saved.Successfully.Text")); 
	}

	@Test(priority = 17) 
	public void previewTest() throws InterruptedException {

		logger.info("Starting of Preview method");
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Thread.sleep(10000);
		try {
			previewPage.clickOnPreview(); 
		} catch (Exception e) {
			System.out.println(e);
		}
		Thread.sleep(5000);
		previewPage.clickOnStartPreview();
		Thread.sleep(3000);
		previewPage.select5();
		Thread.sleep(2000);
		previewPage.clickOnNext();
		Thread.sleep(2000);
		previewPage.clickOnNext();
		Thread.sleep(2000);
		previewPage.clickOnNext();
		Thread.sleep(2000);
		previewPage.clickOnSubmit();
		previewPage.clickOnClosePreview();
		logger.info("Ending of Preview method");

	}

	@Test(priority = 18) 
	public void verifySurveyPublishedSuccessfullyText() throws InterruptedException {
		
		String actualTitle = this.previewPage.getSurveyPublishedSuccessfullyText();
		Assert.assertEquals(actualTitle,
				expectedAssertionsProp.getProperty("Survey.Published.Successfully.Text")); 
	}

	@Test(priority = 19) 
	public void campaignTest() throws InterruptedException {

		logger.info("Starting of Campaign method");
		Thread.sleep(3000);
		campaignPage.clickOnPublishSurvey();
		campaignPage.enterCampaignTitle(testDataProp.getProperty("campaignTitle"));
		//campaignPage.clickOnSelectCampaignType(); campaignPage.selectOnlyOnce();
		campaignPage.clickOnModesDropdown(); 
		campaignPage.selectEmail();
		campaignPage.clickOnModesDropdown(); 
		//campaignPage.clickOnTimezone(); campaignPage.clickOnScheduleMode();
		//campaignPage.selectNow();
		campaignPage.enterMailSubject(testDataProp.getProperty("mailSubject"));
		campaignPage.scrollDown(500);
		campaignPage.enterEmailMessage(testDataProp.getProperty("emailMessage"));
		//campaignPage.clickOnSaveTemplate();
		//campaignPage.enterTemplateName(testDataProp.getProperty("templateName"));
		//campaignPage.clickOnSaveTemplatebutton(); 
		campaignPage.clickOnRegion();
		campaignPage.selectNorth(); 
		campaignPage.clickOnDepartment();
		campaignPage.selectProduct(); 
		campaignPage.clickOnGender();
		campaignPage.selectMale(); 
		campaignPage.clickOnTesting();
		campaignPage.selectTestingCheckbox(); 
		campaignPage.clickOnSendSurvey();
		logger.info("Ending of Campaign method");
	}

	@Test(priority = 20) 
	public void verifyNewCampaigncreatedsuccessfullyText() {
		
		String actualTitle = this.campaignPage.getNewCampaigncreatedsuccessfullyText();
		Assert.assertEquals(actualTitle,expectedAssertionsProp.getProperty("New.Campaign.created.successfully.Text")); 
	}

	@AfterClass
	public void quitDriver() {

		//driver.close(); 
		driver.quit(); 
	}
}
