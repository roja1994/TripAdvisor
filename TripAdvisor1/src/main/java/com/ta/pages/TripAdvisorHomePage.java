package com.ta.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.ta.genericlib.WebDriverLib;

public class TripAdvisorHomePage {
	WebDriver driver;
	WebDriverLib wdl = new WebDriverLib();
	@FindBy(xpath = "(//input[@class='_3qLQ-U8m'])[2]")
	private WebElement searchTB1;
	
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement searchTB;
	
	@FindBy(xpath = "//input[@placeholder='Search Tripadvisor']")
	private WebElement innerSearchTB;
	
	public TripAdvisorHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public TripAdvisorListPage enterTripName(String str) {
		wdl.waitForPageLoad(driver);
		try {
//		wdl.waitForElementAndClick(driver, searchTB);
		searchTB.click();
		innerSearchTB.sendKeys(str, Keys.ENTER);
		}catch (Exception e) {
			searchTB1.sendKeys(str, Keys.ENTER);
		}
		return new TripAdvisorListPage(driver);
	}
	
}
