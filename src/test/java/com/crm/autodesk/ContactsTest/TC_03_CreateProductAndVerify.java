package com.crm.autodesk.ContactsTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLib.ExcelFileUtility;
import com.crm.autodesk.GenericLib.JASONutilities;
import com.crm.autodesk.GenericLib.JavaUtility;
import com.crm.autodesk.GenericLib.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_03_CreateProductAndVerify {
	WebDriver driver;
	@Test
	
	public void createProductAndVerify() throws Throwable
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
		
		
		String productname = eLib.getExcelData("Sheet1", 1, 4);
		
		String productcode= eLib.getExcelData("Sheet1", 1, 5);
		
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
		
		//click on  product module
		driver.findElement(By.linkText("Products")).click();
		
		//click on create product button
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//fill necessary details
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.name("productcode")).sendKeys(productcode);
		//click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//copy the product no
		WebElement exp = driver.findElement(By.xpath("//td[contains(text(),'PR')]"));
		String expected=exp.getText();
		
		//click on product module again
		driver.findElement(By.linkText("Products")).click();
		//type part no and click on search button
		driver.findElement(By.name("search_text")).sendKeys(productcode);
		 WebElement ele = driver.findElement(By.id("bas_searchfield"));
		 wLib.select(ele,"Part Number");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		
		List<WebElement> ele1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));
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
		//close the browser
		driver.close();
		
		
		
	}
}
