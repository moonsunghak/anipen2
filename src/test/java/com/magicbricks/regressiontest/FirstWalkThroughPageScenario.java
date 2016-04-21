package com.magicbricks.regressiontest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.magicbricks.pagerepo.FirstWalkThroughScreenPage;
import com.magicbricks.pagerepo.LoginPage;
import com.magicbricks.testconfig.TestConfiguration;
import com.magicbricks.utils.GenericUtilLib;

public class FirstWalkThroughPageScenario extends TestConfiguration
{
	/**
	 * This testcase used to click on skip button(firstWalkThrough page) followed its verifies login page
	 */
	@Test
	public void firstWalkThroughPageTestTC_01() throws IOException{
		try{
			FirstWalkThroughScreenPage firstWalkThrough = new FirstWalkThroughScreenPage(driver);
			
			firstWalkThrough.clickOnSkipButton();
			
			LoginPage login = new LoginPage(driver);
			
			Assert.assertTrue(login.verifySmartDiaryLogoPresent(), "Smart diary logo not present");
			
			String loginTitle = login.getLoginTitleText();
			Assert.assertEquals(loginTitle,"Login using Smart Diary or Magicbricks account");
			
			Assert.assertTrue(login.verifyUserNameTextBoxPresent(), "Username text box not present");
			
			Assert.assertTrue(login.verifyPasswordTextBoxPresent(), "Password text box  not present");
			
			String loginButton = login.getLoginButtonText();
			Assert.assertEquals(loginButton,"LOGIN");
			
			String registerButton = login.getRegisterText();
			Assert.assertEquals(registerButton,"REGISTER");
			
			String forgotPassword = login.getForgotPasswordText();
			Assert.assertEquals(forgotPassword,"FORGOT PASSWORD?");
			
			
		}catch(AssertionError e){
			GenericUtilLib.saveScreenshot(driver,Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail(e.getMessage());
		}
	}
	
}
