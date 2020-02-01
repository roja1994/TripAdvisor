package com.ta.genericlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConstant{
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	FileLibUtils flu = new FileLibUtils();
	public WebDriver driver;
	//@Parameters({"browser"})
	@BeforeClass(groups = {"SmokeTesting","regTesting"})
	public void openBrowser() throws IOException {
		String browser = flu.getDataFromPropertyFile("BROWSER");
		String url = flu.getDataFromPropertyFile("URL");
		if(browser.equals("chrome")){
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	
	
    @AfterClass
	public void closeApplication() {
		driver.quit();
	}
}
