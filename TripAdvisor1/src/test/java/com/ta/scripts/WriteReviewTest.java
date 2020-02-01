package com.ta.scripts;
import java.io.IOException;

import org.testng.annotations.Test;

import com.ta.genericlib.BaseTest;
import com.ta.genericlib.FileLibUtils;
import com.ta.pages.TripAdvisorHomePage;
import com.ta.pages.TripAdvisorListPage;
import com.ta.pages.TripAdvisorReviewPage;
import com.ta.pages.TripAdvisorWriteReviewPage;

public class WriteReviewTest extends BaseTest{
	FileLibUtils flu = new FileLibUtils();
	@Test
	public void writeReview() throws IOException, InterruptedException {
		String name = flu.getDataFromPropertyFile("name");
		String textinfo = flu.getDataFromPropertyFile("text");
		String titinfo = flu.getDataFromPropertyFile("tit");
		TripAdvisorHomePage hp = new TripAdvisorHomePage(driver);
		TripAdvisorListPage talp = hp.enterTripName(name);
		TripAdvisorReviewPage tarp = talp.clickOnTrip(name);
		TripAdvisorWriteReviewPage tawrp = tarp.clickOnReviewBTN();
		tawrp.clickOnUserRating(titinfo, textinfo);	
	}
}
