package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//locate all elements
	
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadImg;
	
	@FindBy(name="search_text")
	private WebElement searchLeadEdt;
	
	@FindBy(id="bas_searchfield")
	private WebElement inDropdown;
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchNowBtn;

	//provide getters 
	public WebElement getCreateLeadImg() {
		return createLeadImg;
	}

	public WebElement getSearchLeadEdt() {
		return searchLeadEdt;
	}

	public WebElement getInDropdown() {
		return inDropdown;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//business logic
	
	public void clickOnCreateLeadImg()
	{
		createLeadImg.click();
	}
	
	
	
	

}
