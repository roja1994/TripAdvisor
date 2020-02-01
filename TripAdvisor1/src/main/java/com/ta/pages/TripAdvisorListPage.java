package com.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ta.genericlib.WebDriverLib;

public class TripAdvisorListPage {
	public WebDriver driver;
	WebDriverLib wdl = new WebDriverLib();
	
	public TripAdvisorListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public TripAdvisorReviewPage clickOnTrip(String name) throws InterruptedException {
		WebElement clubName = driver.findElement(By.xpath("(//span[contains(text(),'"+name+"')])[2]"));
		wdl.waitForElementAndClick(driver, clubName);
		clubName.click();
		String tit = driver.getTitle();
		System.out.println(tit);
		wdl.switchToChildWindow1(driver,tit);
		return new TripAdvisorReviewPage(driver);
	}
}
