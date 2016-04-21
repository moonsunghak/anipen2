package com.magicbricks.pagerepo;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.magicbricks.utils.GenericUtilLib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LeadLoadingPage
{
	AndroidDriver driver;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/recentleadscount")
	private WebElement recentLeadsButton;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/close_import")
	private WebElement closeImportButton;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/import_title")
	private WebElement leadLoadingTitle;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/root_lead_info")
	private WebElement leadLoadingInfo;
	
	
	public LeadLoadingPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnRecentLeadsButton(){
		recentLeadsButton.click();
	}
	public void clickOnCloseImportButton(){
		closeImportButton.click();
	}
	
	public boolean verifyLeadLodingPresent(){
		return recentLeadsButton.isDisplayed();
	}
	
	public String getLeadLoadingCount(){
		return recentLeadsButton.getText().trim();
	}
	
	public String getLeadLoadingTitle(){
		return leadLoadingTitle.getText().trim();
	}
	public boolean verifyLeadLodingInfoPresent(){
		return leadLoadingInfo.isDisplayed();
	}
}
