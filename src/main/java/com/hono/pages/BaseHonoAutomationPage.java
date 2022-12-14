package com.hono.pages;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class BaseHonoAutomationPage {

	protected WebDriver driver = null;

	private static final Logger logger = Logger.getLogger(BaseHonoAutomationPage.class.getName());
	public static String TEST_FILE_PATH = null;

	public BaseHonoAutomationPage(WebDriver driver) {

		this.driver = driver;

		if (TEST_FILE_PATH == null) {
			TEST_FILE_PATH = getTestFilePath();

			logger.debug("In Constructor " + TEST_FILE_PATH);

			PageFactory.initElements(driver, this);
		}

	}

	protected void selectDropdown(String id, String value) {
		logger.info("Starting of selectDropdown method");
		Select conditions = new Select(driver.findElement(By.id(id)));
		conditions.selectByValue(value);
		logger.info("Ending of selectDropdown method");

	}

	public String getTestFilePath() {
		String path = "src/main/resources";
		File file = new File(path);
		return file.getAbsolutePath();
	}

	public void selectDropdown(String Array) {

	}

	public void scrollDown(int scroll) {
		logger.info("Starting of scrollDown method");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + scroll + ")");
		logger.info("Ending of scrollDown method");
	}


	public void clickOnWebElement(WebElement webelement) {
		logger.info("Starting of clickOnWebElement method"); JavascriptExecutor
		jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("arguments[0].click();", webelement);
		logger.info("Ending of clickOnWebElement method"); }


	public String getUniqueValue(String value) {

		Random rand = new Random();
		// Generate random integers in range 0 to 999
		int rand_int1 = rand.nextInt(10000);
		return value + "_" + rand_int1;
	}



	public void highlight(WebDriver driver, WebElement elm ) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;   
		js.executeScript("arguments[0].style.border='4px groove red'", elm);  
		Thread.sleep(1000);  
		js.executeScript("arguments[0].style.border=''", elm); 
	}


	/*
	 * protected WebElement findElement(WebElement webelement, WEB_ACTIONS
	 * webActions) {
	 * 
	 * Wait<WebDriver> wait = new
	 * FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
	 * .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
	 * .ignoring(StaleElementReferenceException.class); switch (webActions) { case
	 * CLICK: wait.until(ExpectedConditions.elementToBeClickable(webelement));
	 * break; case VISIBILE:
	 * wait.until(ExpectedConditions.visibilityOf(webelement)); break; default:
	 * wait.until(ExpectedConditions.visibilityOf(webelement)); } return webelement;
	 * }
	 * 
	 * protected List<WebElement> findElements(WebElement webelement, WEB_ACTIONS
	 * mobileActions) {
	 * 
	 * Wait<WebDriver> wait = new
	 * FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
	 * .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
	 * .ignoring(StaleElementReferenceException.class); switch (mobileActions) {
	 * case CLICK: wait.until(ExpectedConditions.elementToBeClickable(webelement));
	 * break; case VISIBILE:
	 * wait.until(ExpectedConditions.visibilityOf(webelement)); break; default:
	 * wait.until(ExpectedConditions.visibilityOf(webelement));
	 * 
	 * } return (List<WebElement>) webelement; }
	 * 
	 * protected void clickOnWebElementUsingJS(WebElement webelement) {
	 * findElement(webelement, WEB_ACTIONS.CLICK); ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].click();", webelement); }
	 * 
	 * protected void clickOnWebElement1(WebElement webelement) {
	 * findElement(webelement, WEB_ACTIONS.CLICK).click(); }
	 * 
	 * protected String getText(WebElement webelement) { return
	 * findElement(webelement, WEB_ACTIONS.VISIBILE).getText(); }
	 * 
	 * public enum WEB_ACTIONS { CLICK, VISIBILE, TEXT }
	 */
}
