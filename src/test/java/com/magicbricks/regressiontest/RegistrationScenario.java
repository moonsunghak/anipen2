package com.magicbricks.regressiontest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magicbricks.pagerepo.EnterOTPPage;
import com.magicbricks.pagerepo.FirstWalkThroughScreenPage;
import com.magicbricks.pagerepo.LoginPage;
import com.magicbricks.pagerepo.RegistrationPage;
import com.magicbricks.testconfig.TestConfiguration;
import com.magicbricks.utils.GenericUtilLib;

public class RegistrationScenario extends TestConfiguration{
	
	/**
	 * This testcase used to verify all mandatory fields text in registration page 
	 */
	@Test(priority=1)
	public void RegistrationScenarioTestTC_01() throws IOException{
		try {
			FirstWalkThroughScreenPage firstWalkThrough = new FirstWalkThroughScreenPage(driver);
			firstWalkThrough.clickOnSkipButton();
		
			LoginPage login = new LoginPage(driver);
			login.clickOnRegisterButton();
			RegistrationPage registerPage = new RegistrationPage(driver);
			registerPage.clickOnContinueButton();
		   
			Assert.assertTrue(registerPage.verifyNameTextBoxPresent(), "Name text box not present");
	
			Assert.assertTrue(registerPage.verifyEmailTextBoxPresent(), "Email text box not present");
			
			Assert.assertTrue(registerPage.verifyContactNoTextBoxPresent(), "Contact Number text box not present");
			
			Assert.assertTrue(registerPage.verifyPasswordTextBoxPresent(), "Password text box not present");
			
			Assert.assertTrue(registerPage.verifyOperatingCityTextBoxPresent(), "Operating city text box not present");
			
			String signUpTC = registerPage.getSignUpText();
			Assert.assertEquals(signUpTC,"By Signing up you agree to our T&C  and that you have read our Privacy Policy");
			
			String continueButton = registerPage.getContinueText();
			Assert.assertEquals(continueButton,"CONTINUE");

			String mandatoryField = registerPage.getMandatoryFieldMsg();
			Assert.assertEquals(mandatoryField,"Mandatory fields cannot be left blank");
			
		}catch(AssertionError e){
			GenericUtilLib.saveScreenshot(driver,Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail(e.getMessage());
		}
	}
	
	/**
	 * This testcase used to enter all fields in registration and verify success msg
	 */
	@Test(priority=2)
	public void RegistrationScenarioTestTC_02() throws IOException, InterruptedException{
		try{
			RegistrationPage registerPage = new RegistrationPage(driver);
			registerPage.validRegistration();
			registerPage.clickOnContinueButton();
			Thread.sleep(1000);
			EnterOTPPage otpPage= new EnterOTPPage(driver);
			Assert.assertTrue(otpPage.verifyOtpMsgPresent(),"otp msg not present");
			
			String otpTitle = otpPage.getOtpTitleText();
			Assert.assertEquals(otpTitle, "Enter OTP");
			
			Assert.assertTrue(otpPage.verifyVerificationCodeTextBox(),"verification text box not present");
			
			String verifyButton = otpPage.getVerifyButtonText();
			Assert.assertEquals(verifyButton, "VERIFY");
			
			String textView = otpPage.getTextView();
			Assert.assertEquals(textView, "Didn't Receive the SMS?");
			
			String resendOtp = otpPage.getResendOtpText();
			Assert.assertEquals(resendOtp, "RESEND OTP");
			
			String anotherNumber = otpPage.getAnotherNumberText();
			Assert.assertEquals(anotherNumber, "Call Customer Care to Verify");
			
			
		}catch(AssertionError e){
			GenericUtilLib.saveScreenshot(driver,Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail(e.getMessage());
		}
	}

}
 