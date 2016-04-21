package com.magicbricks.regressiontest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.magicbricks.pagerepo.FirstWalkThroughScreenPage;
import com.magicbricks.pagerepo.LoginPage;
import com.magicbricks.pagerepo.SecondWalkThroughScreenPage;
import com.magicbricks.pagerepo.ThirdWalkThroughScreenPage;
import com.magicbricks.testconfig.TestConfiguration;
import com.magicbricks.utils.GenericUtilLib;

public class SecondWalkThroughPageScenario extends TestConfiguration
{
	/**
	 * This testcase used to click on next button(firstWalkThrough page) followed its verifies login page
	 */
    @Test(priority=1)
	public void secondWalkThroughPageTestTC_01() throws IOException, InterruptedException{
		try{
			FirstWalkThroughScreenPage firstWalkThrough = new FirstWalkThroughScreenPage(driver);
			firstWalkThrough.clickOnNextButton();
			
			SecondWalkThroughScreenPage secondWalkThrough = new SecondWalkThroughScreenPage(driver);
			String takeControl = secondWalkThrough.getTakeControlCallsText();
			Assert.assertEquals(takeControl,"Take control of your calls");
			
			secondWalkThrough.clickOnNextButton();
			
			ThirdWalkThroughScreenPage thirdWalkThrough = new ThirdWalkThroughScreenPage(driver);
			thirdWalkThrough.clickOnGetStartedButton();
			
			LoginPage login = new LoginPage(driver);
			String loginTitle = login.getLoginTitleText();
			Assert.assertEquals(loginTitle,"Login using Smart Diary or Magicbricks account1");
			
		}catch(AssertionError e){
			GenericUtilLib.saveScreenshot(driver,Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail(e.getMessage());
		}
		
	}
    /**
     * Skip the testcase
     */
    @Test(priority=2)
    public void secondWalkThroughPageTestTC_02(){
    	System.out.println("Im in skip exception");
    	throw new SkipException("Skipping this exception");
    }
	
}
