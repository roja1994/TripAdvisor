package com.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.genericlib.WebDriverLib;

public class TripAdvisorReviewPage {
	public WebDriver driver;
	WebDriverLib wdl = new WebDriverLib();
	
	@FindBy(xpath = "//a[text()='Write a review']")
	private WebElement reviewBTN;
	
	public TripAdvisorReviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public TripAdvisorWriteReviewPage clickOnReviewBTN() throws InterruptedException {
		wdl.waitForElementAndClick(driver, reviewBTN);
		reviewBTN.click();
		String tit = driver.getTitle();
		wdl.switchToChildWindow1(driver, tit);
		return new TripAdvisorWriteReviewPage(driver);
	}
}
