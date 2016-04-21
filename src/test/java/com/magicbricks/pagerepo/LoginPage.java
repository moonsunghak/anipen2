package com.magicbricks.pagerepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.magicbricks.testconfig.TestConfiguration;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage 
{
	AndroidDriver  driver;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/input_email_login")
	private WebElement usernameTextbox;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/input_password_login")
	private WebElement passwordTextbox;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/btn_sign_in")
	private WebElement loginButton;
	@FindBy(className="android.widget.FrameLayout")
	private WebElement alertName;
	@FindBy(id="com.timesgroup.magicbricksagentcrm:id/tryagain")
	private WebElement tryLoginButton;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/snackbar_text")
	private WebElement invalidLogin;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/imv_sign_nt")
	private WebElement smartDiaryLogo;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/btn_sign_up")
	private WebElement registerButton;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/title_text_ob")
	private WebElement loginTitle;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/tv_forgot_password")
	private WebElement forgotPassword;
	

	public LoginPage(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validUserName(){
		usernameTextbox.clear();
		usernameTextbox.sendKeys(TestConfiguration.config.getProperty("userName"));
		driver.hideKeyboard();
		loginButton.click();
	}
	
	public void validLogin() throws InterruptedException{
		usernameTextbox.clear();
		usernameTextbox.sendKeys(TestConfiguration.config.getProperty("userName"));
		passwordTextbox.clear();
		passwordTextbox.sendKeys(TestConfiguration.config.getProperty("password"));
		driver.hideKeyboard();
		loginButton.click();
	}
	
	public void invalidLogin() throws InterruptedException{
		usernameTextbox.sendKeys(TestConfiguration.config.getProperty("userName1"));
	//	driver.hideKeyboard();
		passwordTextbox.sendKeys(TestConfiguration.config.getProperty("password1"));
		Thread.sleep(1000);
	    driver.hideKeyboard();
		loginButton.click();
	}
	
   public String getInvalidLoginText(){
	   	return invalidLogin.getText().trim();
   }
   
   public boolean verifySmartDiaryLogoPresent(){
   		return smartDiaryLogo.isDisplayed();
   }
   public boolean verifyUserNameTextBoxPresent(){
	   	return usernameTextbox.isDisplayed();
   }
   
   public boolean verifyPasswordTextBoxPresent(){
	   	return passwordTextbox.isDisplayed();
  }
   public String getLoginButtonText(){
	   	return loginButton.getText().trim();
  }
   public String getRegisterText(){
	   	return registerButton.getText().trim();
  }
   public void clickOnRegisterButton(){
		registerButton.click();
	}
   public String getLoginTitleText(){
   		return 	loginTitle.getText().trim();
   }
   
   public String getForgotPasswordText(){
	   return forgotPassword.getText().trim();
   }
	
}
