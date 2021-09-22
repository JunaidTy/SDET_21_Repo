package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement userNameEdt;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="Email")
	private WebElement emailLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLnk;

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	
	//business logic
	
	public void clickOnOrganizations()
	{
		organizationLnk.click();
	}
	public void clickOnContacts()
	{
		contactsLnk.click();
	}
	public void clickOnUsername()
	{
		userNameEdt.click();
	}
	
	public void clickOnLeads()
	{
		leadsLnk.click();
	}

	public void clickOnOpportunities()
	{
		opportunitiesLnk.click();
	}
	
	public void clickOnProducts()
	{
		productsLnk.click();
	}
	
	
	
	
	
	
	
	

}
