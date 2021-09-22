package com.crm.autodesk.ContactsTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLib.ExcelFileUtility;
import com.crm.autodesk.GenericLib.IpathConstants;
import com.crm.autodesk.GenericLib.JASONutilities;
import com.crm.autodesk.GenericLib.JavaUtility;
import com.crm.autodesk.GenericLib.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_03_CreateContactAndAddFile {
	@Test
	public void CreateContactAndAddFile() throws Throwable {
		
	WebDriver driver=null;
	JASONutilities jsonLib=new JASONutilities();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	ExcelFileUtility eLib=new ExcelFileUtility();
	
	String BROWSER = jsonLib.readDataFromJSON("browser");
	String URL = jsonLib.readDataFromJSON("url");
	String USERNAME = jsonLib.readDataFromJSON("username");
	String PASSWORD = jsonLib.readDataFromJSON("password");
	
	
	
	String LASTNAME = eLib.getExcelData("Sheet1", 1, 6);
	

	
	WebDriverManager.chromedriver().setup();
	
	//launch the browser
	if(BROWSER.equals("chrome")) 
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("firefox")){
	driver=new FirefoxDriver();	
	}else {
		System.out.println("invalid browser");
	}
	wLib.waitForPageLoad(driver);
	wLib.maximizeWindow(driver);
	driver.get(URL);
	
	//login to application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	//click on Contacts module
	driver.findElement(By.linkText("Contacts")).click();
	//click on Create Contact... button
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	//enter the last name
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	//click on report to plus button
	driver.findElement(By.xpath("//table[@class='small']/tbody/tr[10]/td[4]//img[@title='Select']")).click();
	//switch the frame
	wLib.switchToWindow(driver,"EditView&recordid");
	//select whom to report
	driver.findElement(By.xpath(" //a[text()=' Junaid']")).click();
	//switch back the frame
	wLib.switchToWindow(driver,"Contacts&action");
	
	//send the contact image
	driver.findElement(By.name("imagename")).sendKeys(IpathConstants.ContactImage);
	//move to element
	WebElement ele = driver.findElement(By.name("imagename"));
	wLib.Scrollbar(driver, ele);
	Thread.sleep(3000);
	//click on save button
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	WebElement exp = driver.findElement(By.id("mouseArea_Last Name"));
	String expected=exp.getText();
	
	
	//Again click on Contacts module
	driver.findElement(By.linkText("Contacts")).click();
	//enter last name and click on search button
	driver.findElement(By.name("search_text")).sendKeys(LASTNAME);
	 WebElement elee = driver.findElement(By.id("bas_searchfield"));
	 wLib.select(elee,"Last Name");
	//click on search button
	driver.findElement(By.name("submit")).click();
	List<WebElement> ele1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]"));
	for(WebElement ele2:ele1)
	{
		String actual = ele2.getText();
		
		if(expected.contains(actual))
		{
			System.out.println("passed");
			break;
		}
	}
		//close the application
		WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseOver(driver, ele3);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//driver.close();
		driver.close();

	}
}