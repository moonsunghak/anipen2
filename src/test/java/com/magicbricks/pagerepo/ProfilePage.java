package com.magicbricks.pagerepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class ProfilePage
{
	AndroidDriver driver;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/hamberger")
	private WebElement hamBerger;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/profile")
	private WebElement viewProfileLink;
	@FindBy(id="com.timesgroup.magicbricksagentcrm:id/editprofile")
	private WebElement editButton;
	@FindBy(id="com.timesgroup.magicbricksagentcrm:id/tvName")
	private WebElement profileNameTextbox;
	@FindBy(id="com.timesgroup.magicbricksagentcrm:id/save")
	private WebElement saveButton;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/home_company_name")
	private WebElement companyName;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/profile_name")
	private WebElement companyNameOnSideMenu;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/header_title")
	private WebElement companyNameOnProfile;

	public ProfilePage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnHamBergerMenu(){
		hamBerger.click();
	}
	
	public void clickOnViewProfileLink(){
		viewProfileLink.click();
	}
	
	public void clickOnEditButton(){
		editButton.click();
	}
	
	public String getCompanyName(){
		return companyName.getText().trim();
	}
	public String getCompanyNameOnSideMenu(){
		return companyNameOnSideMenu.getText().trim();
	}
	public String getCompanyNameOnProfile(){
		return companyNameOnProfile.getText().trim();
	}
}
