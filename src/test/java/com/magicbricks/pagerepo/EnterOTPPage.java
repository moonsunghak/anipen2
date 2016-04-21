package com.magicbricks.pagerepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class EnterOTPPage
{
	AndroidDriver driver;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/linearLayout")
	private WebElement otpMsg;
	@FindBy(className="android.widget.TextView")
	private WebElement otpTitle;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/input_enter_otp")
	private WebElement verificationCodeTextBox;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/btn_verify")
	private WebElement verifyButton;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/textView5")
	private WebElement textView;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/btn_resend_otp")
	private WebElement resendOtp;
	@FindBy(id="com.timesgroup.smartdiarybymagicbricks:id/btn_use_another_number")
	private WebElement anotherNumberButton;
	
	
	
	public EnterOTPPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOtpMsgPresent(){
		return otpMsg.isDisplayed();
	}

	public String getOtpTitleText(){
		return otpTitle.getText().trim();
	}
	
	public boolean verifyVerificationCodeTextBox(){
		return verificationCodeTextBox.isDisplayed();
	}
	
	public String getVerifyButtonText(){
		return verifyButton.getText().trim();
	}
	
	public String getTextView(){
		return textView.getText().trim();
	}
	public String getResendOtpText(){
		return resendOtp.getText().trim();
	}
	public String getAnotherNumberText(){
		return anotherNumberButton.getText().trim();
	}
	
}
