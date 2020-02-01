package com.ta.genericlib;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverLib implements IAutoConstant{

	public void select(WebElement element, String option) {
		Select sec = new Select(element);
		sec.selectByVisibleText(option);
	}
	
	public void select(WebElement element, int index) {
		Select sec = new Select(element);
		sec.selectByIndex(index);
	}
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver, By locator) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForpresenceOfAllElementsLocatedBy(WebDriver driver, By locator) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void waitForPageTitle(WebDriver driver, String title) {
		WebDriverWait wait=new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.titleIs(title));
	}

	public void waitForElementAndClick(WebDriver driver, WebElement element) throws InterruptedException {
		int count=0;
		while(count<=20) {
			try {
				waitForElementToBeClickable(driver,element);
				break;
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	public int randomNumber() {;
		Random randomNum = new Random();
		return randomNum.nextInt(10000);
	}
	public static String parentWindowID;
	public static String childWindowID;

	Set<String> wh;
	public void switchToChildWindow(WebDriver driver) {
		wh = driver.getWindowHandles();
		Iterator<String> ite = wh.iterator();
		parentWindowID = ite.next();
		childWindowID = ite.next();
		driver.switchTo().window(childWindowID);
 	}
	public static String wh1;
	public static String cw;
	public void switchToChildWindow1(WebDriver driver,String tit) {
		wh1=driver.getWindowHandle();
		Set<String> whs = driver.getWindowHandles();
		Iterator<String> ite = whs.iterator();
		while(ite.hasNext()) {
			cw=ite.next();
			if(cw.equals(wh1))
				continue;
			driver.switchTo().window(cw);
			String atit=driver.getTitle();
			if(atit.equals(tit)) {
				driver.switchTo().window(cw);
			}
		}
		
 	}
	
	public void switchToParantWindow1(WebDriver driver,String tit) {
		driver.switchTo().window(wh1);
 	}
	public void switchToParentWindow(WebDriver driver) {
		driver.switchTo().window(childWindowID).close();
		driver.switchTo().window(parentWindowID);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public Actions moveToElement(WebDriver driver, WebElement element, int x, int y) {
		Actions act=new Actions(driver);
		return act.moveToElement(element, x, y);
	}
	
	public Integer convertStringToInteger(String str) {
		String str2="";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)>='0' && str.charAt(i)<='9')
				str2=str2+str.charAt(i);
			else if(str.charAt(i)>='a' && str.charAt(i)<='z' || str.charAt(i)>='A' && str.charAt(i)<='Z' )
				continue;
			else if(str.charAt(i)=='.')
				break;
			else
				continue;
		}
		Integer it=Integer.parseInt(str2);
		return it;
	}
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
}