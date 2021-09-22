package com.crm.autodesk.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.autodesk.GenericLib.WebDriverUtility;

public class CreateLeadInfo {
	
	
	public CreateLeadInfo(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//locator web elements
	 @FindBy(xpath="//table[@class='small']/tbody/tr[1]/td[4][@class='dvtCellInfo']")
	 private WebElement leadNo;
	 
	 @FindBy(id="dtlview_Email")
	 private WebElement email1;
	 
	 @FindBy(id="dtlview_Secondary Email")
	 private WebElement secondaryemail1;
	
	 //provide Getters
	public WebElement getLeadNo() {
		return leadNo;
	}
	public String getLeadNumAct()
	{
		 return leadNo.getText();
		 	
	}
	public String getemail()
	{
		return email1.getText();
	}
	public String getsecondaryemail()
	{
		return secondaryemail1.getText();
	}
	WebDriverUtility wLib=new WebDriverUtility();

	
	public void logout(WebDriver driver)
	{
	//close the application
	WebElement ele3 = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	wLib.mouseOver(driver, ele3);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	
	

}
