package com.magicbricks.pagerepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class  FirstWalkThroughScreenPage
{
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/headerSkipText")
	private WebElement skipButton;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/walkthroughNext")
	private WebElement nextButton;
	
	public FirstWalkThroughScreenPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	AndroidDriver driver;
	public void clickOnSkipButton()
	{
		skipButton.click();
	}
	
	public void clickOnNextButton(){
		nextButton.click();
	}
	
	public boolean verifySkipButtonPresent(){
		 return skipButton.isDisplayed();
	}
	
}
