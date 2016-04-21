package com.magicbricks.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.magicbricks.testconfig.TestConfiguration;
import com.thoughtworks.selenium.webdriven.commands.DragAndDrop;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class GenericUtilLib
{
	//Read data from Excel
	public static String getExcelData(String filePath, String sheetName,
			int rowIndex, int cellIndex) 
	{
		String data = null;
		try
		{
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st =  wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	//Write data to Excel
	public static void setExcelData(String filePath, String sheetName,
			int rowIndex, int cellIndex, String data) 
	{
		try
		{
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st =  wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.createCell(cellIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Select DDl by index
	public static void selectDDLByIndex(WebElement element, int index)
	{
		Select sct = new Select(element);
		sct.selectByIndex(index);
	}
	//Select DDl by Value
	public static void selectDDLByValue(WebElement element, String value)
	{
		Select sct = new Select(element);
		sct.selectByValue(value);
	}
	//Select DDl by visible text
	public static void selectDDLByVisibleText(WebElement element, String text)
	{
		Select sct = new Select(element);
		sct.selectByVisibleText(text);
	}
	//DeSelect DDl by visible text
	public static void deSelectDDLByVisibleText(WebElement element, String text)
	{
		Select sct = new Select(element);
		sct.deselectByVisibleText(text);
	}
	//DeSelect DDl by index
	public static void deSelectDDLByIndex(WebElement element, int index)
	{
		Select sct = new Select(element);
		sct.deselectByIndex(index);
	}
	//DeSelect DDl by Value
	public static void deSelectDDLByValue(WebElement element, String value)
	{
		Select sct = new Select(element);
		sct.deselectByValue(value);
	}
	//DeSelect All Option
	public static void deSelectAll(WebElement element)
	{
		Select sct = new Select(element);
		sct.deselectAll();
	}
	//To verify DDl is multiple or not
	public static boolean checkDDLisMultiple(WebElement element)
	{
		Select sct = new Select(element);
		boolean status = sct.isMultiple();
		return status;
	}
	//To click on Ok Button on Alert
	public static void acceptAlert(AndroidDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	//To click on cancel Button on Alert
	public static void dismissAlert(AndroidDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	//To get alert Message
	public static String getAlertMsg(AndroidDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		String alert_msg = alt.getText();
		return alert_msg;
	}
	//To enter text on alert Prompt
	public static void enterTextOnAlert(AndroidDriver driver, String text)
	{
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(text);
	}
	//tO PERFORM mouse over
	public static void mouseOver(AndroidDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	//To perform double click
	public static void doubleClick(AndroidDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	//To perform drag and dropj  
	public static void dragAndDrop(AndroidDriver driver, WebElement src, WebElement dest)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
	
	public enum locatorTypes {
		xpath, css, id, name, link, className
	}
	//Find element
	public static WebElement webElementIdentifier(AndroidDriver driver,String objectLocator) {
		
		locatorTypes locator = locatorTypes.valueOf(objectLocator.substring(objectLocator.lastIndexOf("$") + 1));
		String elementLocator = objectLocator.substring(0,objectLocator.lastIndexOf("$"));
		WebElement element = null;

		switch (locator) {
		case link:
			element = driver.findElement(By.linkText(elementLocator));
			break;
		case xpath:
			element = driver.findElement(By.xpath(elementLocator));
			break;
		case css:
			element = driver.findElement(By.cssSelector(elementLocator));
			break;
		case id:
			element = driver.findElement(By.id(elementLocator));
			break;
		case name:
			element = driver.findElement(By.name(elementLocator));
			break;
		case className:
			element = driver.findElement(By.className(elementLocator));
			break;
		}
		return element;
	}
	
   //check element loaded
	 public static void isElementLoaded(AndroidDriver driver,String objectLocator,int timeout) {
		    WebDriverWait wait = new WebDriverWait(driver, timeout);
		    wait.until(ExpectedConditions.textToBePresentInElement(webElementIdentifier(driver, objectLocator), "SKIP THE STEP"));
	}
	
	//save screenshot
	 public static void saveScreenshot(AndroidDriver driver,String methodName) throws IOException{
		 SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy_hh_mm_ss");
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		 FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshot//"+methodName+format.format(new Date())+".png"));
	 }
	 
	 //element present
	 public static boolean isElementPresent(AndroidDriver driver,String objectLocator){
		 WebElement element= webElementIdentifier(driver, objectLocator);
			if(element.isDisplayed()){
				return true;
			}else{
				return false;
			}
		}
	 
	 //Random String generation
	 public static String generateRandomString(int length) {
		 char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		 StringBuilder sb = new StringBuilder();
		 Random random = new Random();
		 for (int i = 0; i < 10; i++) {
		     char c = chars[random.nextInt(chars.length)];
		     sb.append(c);
		 }
		 String output = sb.toString();
		 return output;
		 }
	 
	 //Random Email id generation
	 public static String generateEmail(int length) {
		    String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		            "1234567890";   //numbers

		    String email="";
		    Random random = new Random();
		    String temp=RandomStringUtils.random(length,allowedChars);
		    email=temp.substring(0,temp.length()-4)+"@test.org";
		    return email;
		}
	 /* Random Alphanumeric characters generation
	  * 
	  */
	 public static String generateRandomAlphaNumeric(int length){
		    return RandomStringUtils.randomAlphanumeric(length);
		}
	 /*Random Numbers generation
	  * 
	  */
	 public static String generateRandomNumber(int length){
		    return RandomStringUtils.randomNumeric(length);
		}
	 /* selectOptionWithText 
	  * 
	  */
	 public static void autocompleteTextBook(AndroidDriver driver,WebElement element,String textToSelect,int x, int y){
		 try{
			 Thread.sleep(1000);
			 element.sendKeys(textToSelect);
			 TouchAction action = new TouchAction((MobileDriver)driver);
			 action.tap(x, y).perform();						
		 }
		 catch(Exception e){
			 System.out.println("No elements present in the dropdown");
		 }
	 }
}
