package com.magicbricks.regressiontest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.magicbricks.pagerepo.FirstWalkThroughScreenPage;
import com.magicbricks.pagerepo.LoginPage;
import com.magicbricks.pagerepo.ProfilePage;
import com.magicbricks.pagerepo.SettingYourAccountPage;
import com.magicbricks.testconfig.TestConfiguration;
import com.magicbricks.utils.GenericUtilLib;

public class ProfilePageScenario extends TestConfiguration {
	/**
	 * This testcase used to verify username on leading page and  profile page 
	 */
	public static void profilePageTestTC_01() throws InterruptedException, IOException {
		try {
			
			ProfilePage profilePage = new ProfilePage(driver);
			
			String companyName = profilePage.getCompanyName();
			
			profilePage.clickOnHamBergerMenu();
			
			String companyNameOnSideMenu = profilePage.getCompanyNameOnSideMenu();
			Assert.assertEquals(companyNameOnSideMenu, companyName);
			
			profilePage.clickOnViewProfileLink();
			
			String companyNameOnProfile = profilePage.getCompanyNameOnProfile();
			Assert.assertEquals(companyNameOnProfile, companyName);

		} catch (AssertionError e) {
			GenericUtilLib.saveScreenshot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail(e.getMessage());
		}

	}

}
