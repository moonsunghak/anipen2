package com.magicbricks.pagerepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class  SecondWalkThroughScreenPage
{
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/walkthroughNext")
	private WebElement nextButton;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/walkthroughMessageFirstLine")
	private WebElement takeControlCallsText;
	
	
		
	public SecondWalkThroughScreenPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	AndroidDriver driver;
	
	public void clickOnNextButton(){
		nextButton.click();
	}
	
    public String getTakeControlCallsText(){
    	return takeControlCallsText.getText();
    }
    
    
}
