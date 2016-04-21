package com.magicbricks.pagerepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.magicbricks.testconfig.TestConfiguration;
import com.magicbricks.utils.GenericUtilLib;

import io.appium.java_client.android.AndroidDriver;

public class RegistrationPage 
{
	AndroidDriver  driver;

	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/btn_continue")
	private WebElement continueButton;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/input_reg_name")
	private WebElement nameField;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/input_reg_email")
	private WebElement emailField;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/input_reg_mobile")
	private WebElement contactNumber;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/input_reg_password")
	private WebElement password;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/input_reg_city")
	private WebElement operatingCity;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/snackbar_text")
	private WebElement mandatoryFieldMsg;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/sign_up_tc")
	private WebElement signUpTc;
	
	
	public RegistrationPage(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnContinueButton(){
		continueButton.click();
	}
	
	public void validRegistration() throws InterruptedException{
		nameField.sendKeys(GenericUtilLib.generateRandomString(5));
		emailField.sendKeys(GenericUtilLib.generateEmail(10));
		contactNumber.sendKeys(GenericUtilLib.generateRandomNumber(10));
		password.sendKeys(GenericUtilLib.generateRandomAlphaNumeric(6));
		driver.hideKeyboard();
		operatingCity.sendKeys("Bangalore");
		driver.hideKeyboard();
		driver.hideKeyboard();
	}
	
	public String getMandatoryFieldMsg(){
		return mandatoryFieldMsg.getText();
	}
	
	 public boolean verifyNameTextBoxPresent(){
		   	return nameField.isDisplayed();
	  }
	 public boolean verifyEmailTextBoxPresent(){
		   	return emailField.isDisplayed();
	  }
	 public boolean verifyContactNoTextBoxPresent(){
		   	return contactNumber.isDisplayed();
	  }
	 public boolean verifyPasswordTextBoxPresent(){
		   	return password.isDisplayed();
	  }
	 public boolean verifyOperatingCityTextBoxPresent(){
		   	return operatingCity.isDisplayed();
	  }
	 
	  public String getContinueText(){
		   	return continueButton.getText().trim();
	  }
	  
	  public String getSignUpText(){
		   	return signUpTc.getText().trim();
	  }
	
}
