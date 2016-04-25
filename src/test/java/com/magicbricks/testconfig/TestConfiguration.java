package com.magicbricks.testconfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.magicbricks.utils.GenericUtilLib;

import io.appium.java_client.android.AndroidDriver;
public class TestConfiguration 
{
	@BeforeSuite
	public void preSuite() throws IOException
	{
		/* Loading configuration file*/
		config = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//config.properties");
		config.load(fs);
	}
	
	public static AndroidDriver driver;
	public static Properties config,elementConfig;
	@BeforeClass
	public void preClass() throws Exception 
	{
		if (config.getProperty("appTest").equals("Device"))
		{
			File app = new File(System.getProperty("user.dir")+config.getProperty("appPath"));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("automationName", config.getProperty("automationName"));
			capabilities.setCapability("device",config.getProperty("device"));
			capabilities.setCapability("deviceName", config.getProperty("deviceName"));
			capabilities.setCapability("platformVersion", config.getProperty("platformVersion"));
			capabilities.setCapability("platformName", config.getProperty("platformName"));
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("autoDismissAlerts", true);
			capabilities.setCapability("app", app.getAbsolutePath());
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capabilities);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	
	@AfterClass
	public void postClass(){
		driver.quit();
	}
	
	
}
