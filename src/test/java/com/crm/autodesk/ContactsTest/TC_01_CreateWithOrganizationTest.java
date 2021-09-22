package com.crm.autodesk.ContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLib.ExcelFileUtility;
import com.crm.autodesk.GenericLib.JASONutilities;
import com.crm.autodesk.GenericLib.JavaUtility;
import com.crm.autodesk.GenericLib.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_CreateWithOrganizationTest {
	@Test
	

	public void createcontactwithOrganization() throws Throwable
	{
		WebDriver driver=null;
		JASONutilities jsonLib=new JASONutilities();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelFileUtility eLib=new ExcelFileUtility();
		
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String URL = jsonLib.readDataFromJSON("url");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");
		
		String contactName = eLib.getExcelData("Sheet1", 1, 2);
		String OrgName = eLib.getExcelData("Sheet1", 1, 3);
		
		WebDriverManager.chromedriver().setup();
		
		
		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(URL);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//click on contacts
		driver.findElement(By.linkText("Contacts")).click();
		//click on create contact link
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//create contact
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		//switch to child window
		wLib.switchToWindow(driver,"Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("3")).click();
		
		wLib.switchToWindow(driver,"Marketing");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseOver(driver, ele);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//close the application
		driver.close();
}
		
}

