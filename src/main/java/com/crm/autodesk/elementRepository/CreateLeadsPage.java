package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericLib.WebDriverUtility;

public class CreateLeadsPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public CreateLeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//locate all the elements
	
	@FindBy(name="salutationtype")
	private WebElement nameTitleDropdown;
	
	@FindBy(name="firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="phone")
	private WebElement phoneNoEdt;
	
	
	@FindBy(name="company")
	private WebElement companyEdt;
	
	@FindBy(name="mobile")
	private WebElement mobileNoEdt;
	
	@FindBy(id="designation")
	private WebElement titleEdt;
	
	@FindBy(id="fax")
	private WebElement faxEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(id="email")
	private WebElement emailEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="website")
	private WebElement websiteEdt;
	
	@FindBy(name="annualrevenue")
	private WebElement annualRevenueEdt;
	
	@FindBy(name="leadstatus")
	private WebElement leadStatusDropDown;
	
	@FindBy(id="noofemployees")
	private WebElement noOfEmployeesEdt;
	
	@FindBy(name="rating")
	private WebElement ratingDropDown;
	
	@FindBy(id="secondaryemail")
	private WebElement secondaryEmailEdt;
	
	@FindBy(name="lane")
	private WebElement streetEdt;
	
	@FindBy(id="pobox")
	private WebElement poBoxEdt;
	
	@FindBy(id="code")
	private WebElement postalCodeEdt;
	
	@FindBy(id="city")
	private WebElement cityEdt;
	
	@FindBy(id="country")
	private WebElement countryEdt;
	
	@FindBy(id="state")
	private WebElement stateEdt;
	
	@FindBy(name="description")
	private WebElement descriptionEdt;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;

	//provide getters
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getNameTitleDropdown() {
		return nameTitleDropdown;
	}

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getPhoneNoEdt() {
		return phoneNoEdt;
	}

	public WebElement getCompanyEdt() {
		return companyEdt;
	}

	public WebElement getMobileNoEdt() {
		return mobileNoEdt;
	}

	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getFaxEdt() {
		return faxEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getWebsiteEdt() {
		return websiteEdt;
	}

	public WebElement getAnnualRevenueEdt() {
		return annualRevenueEdt;
	}

	public WebElement getLeadStatusDropDown() {
		return leadStatusDropDown;
	}

	public WebElement getNoOfEmployeesEdt() {
		return noOfEmployeesEdt;
	}

	public WebElement getRatingDropDown() {
		return ratingDropDown;
	}

	public WebElement getSecondaryEmailEdt() {
		return secondaryEmailEdt;
	}

	public WebElement getStreetEdt() {
		return streetEdt;
	}

	public WebElement getPoBoxEdt() {
		return poBoxEdt;
	}

	public WebElement getPostalCodeEdt() {
		return postalCodeEdt;
	}

	public WebElement getCityEdt() {
		return cityEdt;
	}

	public WebElement getCountryEdt() {
		return countryEdt;
	}

	public WebElement getStateEdt() {
		return stateEdt;
	}

	public WebElement getDescriptionEdt() {
		return descriptionEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business logic
	/**
	 * this method will create Leads with all the details
	 */
	public void createLeadWithAllDetails(String nameTitle,String firstname,String lastname,String companyName,String mobileNo,String title,String faxNo,String leadSource,String email,String industryType,String website,String revenue,String leadStatus,String noOfEmployee,String rating,String secondaryEmail,String street,String poBoxNo,String postalCodeNo,String cityName,String countryName,String stateName,String description,String phoneNo)
	{
		nameTitleDropdown.sendKeys(nameTitle);
		//select(nameTitleDropdown, nameTitle);	
		firstNameEdt.sendKeys(firstname);
		lastNameEdt.sendKeys(lastname);
		companyEdt.sendKeys(companyName);
		mobileNoEdt.sendKeys(mobileNo);
		phoneNoEdt.sendKeys(phoneNo);
		titleEdt.sendKeys(title);
		faxEdt.sendKeys(faxNo);
		leadSourceDropDown.sendKeys(leadSource);
		//select(leadSourceDropDown,leadSource);
		emailEdt.sendKeys(email);
		industryDropDown.sendKeys(industryType);
		//select(industryDropDown,industryType);
		websiteEdt.sendKeys(website);
		annualRevenueEdt.sendKeys(revenue);
		leadStatusDropDown.sendKeys(leadStatus);
		//select(leadStatusDropDown,leadStatus);
		noOfEmployeesEdt.sendKeys(noOfEmployee);
		ratingDropDown.sendKeys(rating);
		//select(ratingDropDown,rating);
		secondaryEmailEdt.sendKeys(secondaryEmail);
		streetEdt.sendKeys(street);
		poBoxEdt.sendKeys(poBoxNo);
		postalCodeEdt.sendKeys(postalCodeNo);
		cityEdt.sendKeys(cityName);
		countryEdt.sendKeys(countryName);
		stateEdt.sendKeys(stateName);
		descriptionEdt.sendKeys(description);
		saveBtn.click();
		
	}

	public void createLeadWithAllDetails(Object[][] companyName, Object[][] industryType) {
			
		//companyEdt.sendKeys(companyName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
