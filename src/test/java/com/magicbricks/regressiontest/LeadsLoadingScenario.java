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

public class LeadsLoadingScenario extends TestConfiguration{	
	
	/**
	 * This testcase used to verify leads are loaded once user logged into application
	 */
	
	public static void verifyLeadsLoadedTestTC_01() throws IOException, InterruptedException{
		try{
		
			SettingYourAccountPage setYAcc = new SettingYourAccountPage(driver);
			setYAcc.clickOnSkipThisStepButton();
		
			LeadLoadingPage leadLoadingPage = new LeadLoadingPage(driver);
			/**verify lead loading element present*/
			Assert.assertTrue(leadLoadingPage.verifyLeadLodingPresent(),"Lead loading button not available on web page");
		
			int recentLeadsCount= Integer.parseInt(leadLoadingPage.getLeadLoadingCount());
			leadLoadingPage.clickOnRecentLeadsButton();
			if(recentLeadsCount >= 1){
			int recentLeadsTitleCount= Integer.parseInt(leadLoadingPage.getLeadLoadingTitle().substring(14).split("\\)")[0]);
			/**verify lead loading count simillar once clicked on leadloading button*/
			Assert.assertEquals(recentLeadsCount, recentLeadsTitleCount);
			
			/**Verify lead loading element present*/
			Assert.assertTrue(leadLoadingPage.verifyLeadLodingInfoPresent(), "Lead loading elemnent not available on web page");
		 }
		}
		catch(AssertionError e){
			GenericUtilLib.saveScreenshot(driver,Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail(e.getMessage());
		}
	}
}