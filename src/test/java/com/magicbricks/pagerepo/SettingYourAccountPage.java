package com.magicbricks.pagerepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SettingYourAccountPage
{
	AndroidDriver driver;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/skip")
	private WebElement skipThisStepButton;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/import_title")
	private WebElement settingYourAccountText;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/importedsuccesstext")
	private WebElement loginSuccessMsg;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/do_you_")
	private WebElement importLeadFromMobileText;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/successtext")
	private WebElement successText;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/btn_import_contacts")
	private WebElement importContact;
	
	
	public SettingYourAccountPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSkipThisStepButton(){
		skipThisStepButton.click();
	}
	
	public String settingYourAccountText(){
		return settingYourAccountText.getText();
	}
	
	public String getLoginSuccessMsg(){
		 return loginSuccessMsg.getText().trim();
    }
	
	public String getImportLeadFromMobileText(){
		 return importLeadFromMobileText.getText().trim();
    }
	public String getSuccessText(){
		 return successText.getText().trim();
   }
	public String getSkipTheStep(){
		 return skipThisStepButton.getText().trim();
   }
	public String getImportContactText(){
		 return importContact.getText().trim();
  }
	
	
}
