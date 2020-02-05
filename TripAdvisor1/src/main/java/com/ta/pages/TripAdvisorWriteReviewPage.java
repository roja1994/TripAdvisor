package com.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ta.genericlib.WebDriverLib;

public class TripAdvisorWriteReviewPage {
	WebDriver driver;
	WebDriverLib wdl = new WebDriverLib();
	
	@FindBy(id = "bubble_rating")
	private WebElement bubbleRating;
	
	@FindBy(id = "ReviewText")
	private WebElement textArea;
	
	@FindBy(xpath = "//div[text()='Hotel Ratings']")
	private WebElement homeRating;
	
	@FindBy(id = "qid11_bubbles")
	private WebElement roomRating;
	
	@FindBy(id = "qid12_bubbles")
	private WebElement serviceRating;
	
	@FindBy(id = "qid14_bubbles")
	private WebElement cleanlinessRating;
	
	@FindBy(id = "qid13_bubbles")
	private WebElement valueRating;
	
	@FindBy(id = "qid190_bubbles")
	private WebElement sleepQualityRating;
	
	@FindBy(xpath = "(//span[contains(@id,'_bubbles')])[1]")
	private WebElement rating1;
	
	@FindBy(xpath = "(//span[contains(@id,'_bubbles')])[2]")
	private WebElement rating2;
	
	@FindBy(xpath = "(//span[contains(@id,'_bubbles')])[3]")
	private WebElement rating3;
	
	@FindBy(id = "SUBMIT")
	private WebElement submitYourReview;
	
	@FindBy(id = "ReviewTitle")
	private WebElement reviewTitle;
	
	@FindBy(xpath = "//div[text()='What sort of trip was this?']/../div[2]/div[1]")
	private WebElement tripType;
	
	@FindBy(xpath = "//span[text()='shoeshine services']/../../div[1]/div[1]")
	private WebElement shoeshineServices;
	
	@FindBy(name = "trip_date_month_year")
	private WebElement selectMonth;
	
	@FindBy(xpath = "//div[contains(text(),'clean hotel')]/../div[1]/div[1]")
	private WebElement cleanHotel;
	
	@FindBy(xpath = "//div[contains(text(),'modern hotel')]/../div[1]/div[1]")
	private WebElement modernHotel;
	
	@FindBy(xpath = "//div[contains(text(),'interesting theme')]/../div[1]/div[1]")
	private WebElement interstingTheme;
	
	@FindBy(xpath = "//div[contains(text(),'location good')]/../div[1]/div[1]")
	private WebElement goodLocation;
	
	@FindBy(xpath = "//span[contains(text(),'safe')]")
	private WebElement safe;
	
	@FindBy(xpath = "//div[@class='jfy_cloud tag ']")
	private WebElement budget;
	
	@FindBy(id = "ROOM_TIP")
	private WebElement roomtip;
	
	@FindBy(id = "noFraud")
	private WebElement submitCB;

	
	
	public TripAdvisorWriteReviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void rating(WebElement ele) {
		for(int i = 10; i<=50 ; i=i+10) {
			if(i<=40) {
				wdl.moveToElement(driver, ele, i, 10).perform();
				try {
					Thread.sleep(1000);
				}catch(Exception e) {
					e.printStackTrace();
				}	
			}
			else {
				wdl.moveToElement(driver, ele, i , 10).click().perform();
			}
		}
		
	}
	
		
	public void clickOnUserRating(String tit, String info) throws InterruptedException {
		wdl.waitForElementToBeClickable(driver, bubbleRating);
		rating(bubbleRating);
		reviewTitle.sendKeys(tit);
		textArea.sendKeys(info);
		tripType.click();
		wdl.select(selectMonth, 2);
//		shoeshineServices.click();
//		cleanHotel.click();
//		modernHotel.click();
//		interstingTheme.click();
//		goodLocation.click();
//		safe.click();
		if(homeRating.isDisplayed()) {
//			if(serviceRating.isDisplayed())
//				rating(serviceRating);
//			if(valueRating.isDisplayed())
//				rating(valueRating);
//			
//			if(cleanlinessRating.isDisplayed())
//				rating(cleanlinessRating);
//			
//			if(sleepQualityRating.isDisplayed())
//			rating(sleepQualityRating);
//			
			if(rating1.isDisplayed())
				rating(rating1);
			if(rating2.isDisplayed())
				rating(rating2);	
			if(rating3.isDisplayed())
				rating(rating3);
		}
		

		budget.click();
		roomtip.sendKeys("No Need to give");
		submitCB.click();
		submitYourReview.click();
	}

}
