package com.magicbricks.pagerepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class  ThirdWalkThroughScreenPage
{
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/walkthroughGetStarted")
	private WebElement getStartedButton;
		
	public ThirdWalkThroughScreenPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	AndroidDriver driver;
	
	
	public void clickOnGetStartedButton(){
		getStartedButton.click();
	}
	
    
    
}
