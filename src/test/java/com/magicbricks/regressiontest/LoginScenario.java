package com.magicbricks.regressiontest;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.magicbricks.pagerepo.FirstWalkThroughScreenPage;
import com.magicbricks.pagerepo.LeadLoadingPage;
import com.magicbricks.pagerepo.LoginPage;
import com.magicbricks.pagerepo.SettingYourAccountPage;
import com.magicbricks.testconfig.TestConfiguration;
import com.magicbricks.utils.GenericUtilLib;

public class LoginScenario extends TestConfiguration
{
	/**
	 * This testcase used to login with invalid credentials
	 */
	@Test(priority=1)
	public void loginTestTC_01() throws IOException, InterruptedException
	{ 
		try{
			FirstWalkThroughScreenPage firstWalkThrough = new FirstWalkThroughScreenPage(driver);
			firstWalkThrough.clickOnSkipButton();
			
			LoginPage login = new LoginPage(driver);
			login.invalidLogin();
			
			String actual =  login.getInvalidLoginText();
			Assert.assertEquals(actual,"Incorrect Login Details");
			
		}catch(AssertionError e){
			GenericUtilLib.saveScreenshot(driver,Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail(e.getMessage());
		}
	}
	
	/**
	 * This testcase used to login with valid credentials
	 */
	@Test(priority=2)
	public void loginTestTC_02() throws IOException, InterruptedException
	{ 
		try{
			LoginPage login = new LoginPage(driver);
			login.validUserName();
			Thread.sleep(25000);
			SettingYourAccountPage setAcc = new SettingYourAccountPage(driver);
			String settingYourAcc = setAcc.settingYourAccountText();
			Assert.assertEquals(settingYourAcc,"Setting Your Account");
			
			String successMsg = setAcc.getSuccessText();
			Assert.assertEquals(successMsg,"Congratulations");
			
			String importData = setAcc.getLoginSuccessMsg();
			Assert.assertEquals(importData,"You have successfully imported your data from Magicbricks account.");
			
			String importLead = setAcc.getImportLeadFromMobileText();
			Assert.assertEquals(importLead,"Do you also want to import Leads from your mobile phone?");
			
			String importContact = setAcc.getImportContactText();
			Assert.assertEquals(importContact,"IMPORT LEADS FROM PHONE BOOK");
			
			String skipTheStep = setAcc.getSkipTheStep();
			Assert.assertEquals(skipTheStep,"SKIP THIS STEP");
			
		}catch(AssertionError e){
			GenericUtilLib.saveScreenshot(driver,Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail(e.getMessage());
		}
	
	}

	/**
	 * This testcase used to verify leads are loaded once user logged into application
	 */
	@Test(priority=3)
	public void leadLoadingTC_01() throws IOException, InterruptedException{
		LeadsLoadingScenario.verifyLeadsLoadedTestTC_01();
	}
	
	/**
	 * This testcase used to verify username on leading page and  profile page 
	 */
	@Test(priority=4)
	public void profilePageTC_01() throws InterruptedException, IOException{
		LeadLoadingPage leadingPage=new LeadLoadingPage(driver);
		leadingPage.clickOnCloseImportButton();
		ProfilePageScenario.profilePageTestTC_01();
	}
	
	
	
}
