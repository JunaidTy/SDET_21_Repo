package com.crm.autodesk.ContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLib.ExcelFileUtility;
import com.crm.autodesk.GenericLib.JASONutilities;
import com.crm.autodesk.GenericLib.JavaUtility;
import com.crm.autodesk.GenericLib.WebDriverUtility;

public class TC_02_CreateOrganizationWithIndustry {
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
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		WebElement ele = driver.findElement(By.name("industry"));
		
		Select s=new Select(ele);
		s.selectByVisibleText("Education");
		
		
		
	}
}
