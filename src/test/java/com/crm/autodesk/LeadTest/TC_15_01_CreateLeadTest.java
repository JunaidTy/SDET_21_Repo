package com.crm.autodesk.LeadTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLib.BaseClass;
import com.crm.autodesk.elementRepository.CreateLeadInfo;
import com.crm.autodesk.elementRepository.CreateLeadsPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadsPage;

public class TC_15_01_CreateLeadTest extends BaseClass{
@Test(groups = "RegressionSuite")
	
	public void CreateLeadTest() throws Throwable {
		
		String nameTitle = eLib.getExcelDataTest1("Sheet1", 1, 0)+jLib.getRandomNum();
		String firstname = eLib.getExcelDataTest1("Sheet1", 1, 1)+jLib.getRandomNum();
		String lastname = eLib.getExcelDataTest1("Sheet1", 1, 2)+jLib.getRandomNum();
		String companyName = eLib.getExcelDataTest1("Sheet1", 1, 3)+jLib.getRandomNum();
		String phoneNo=eLib.getExcelDataTest1("Sheet1", 1, 4)+jLib.getRandomNum();
		String mobileNo = eLib.getExcelDataTest1("Sheet1", 1, 5)+jLib.getRandomNum();
		String title = eLib.getExcelDataTest1("Sheet1", 1, 6)+jLib.getRandomNum();
		String faxNo = eLib.getExcelDataTest1("Sheet1", 1, 7)+jLib.getRandomNum();
		String leadSource = eLib.getExcelDataTest1("Sheet1", 1, 8)+jLib.getRandomNum();
		String email = eLib.getExcelDataTest1("Sheet1", 1, 9);
		String industryType = eLib.getExcelDataTest1("Sheet1", 1, 10)+jLib.getRandomNum();
		String website = eLib.getExcelDataTest1("Sheet1", 1, 11)+jLib.getRandomNum();
		String revenue = eLib.getExcelDataTest1("Sheet1", 1, 12)+jLib.getRandomNum();
		String leadStatus = eLib.getExcelDataTest1("Sheet1", 1, 13)+jLib.getRandomNum();
		String noOfEmployee = eLib.getExcelDataTest1("Sheet1", 1, 14)+jLib.getRandomNum();
		String rating = eLib.getExcelDataTest1("Sheet1", 1, 15)+jLib.getRandomNum();
		String secondaryEmail = eLib.getExcelDataTest1("Sheet1", 1, 16);
		String street = eLib.getExcelDataTest1("Sheet1", 1, 17)+jLib.getRandomNum();
		String poBoxNo = eLib.getExcelDataTest1("Sheet1", 1, 18)+jLib.getRandomNum();
		String postalCodeNo = eLib.getExcelDataTest1("Sheet1", 1, 19)+jLib.getRandomNum();
		String cityName = eLib.getExcelDataTest1("Sheet1", 1, 20)+jLib.getRandomNum();
		String countryName = eLib.getExcelDataTest1("Sheet1", 1, 21)+jLib.getRandomNum();
		String stateName = eLib.getExcelDataTest1("Sheet1", 1, 22)+jLib.getRandomNum();
		String description = eLib.getExcelDataTest1("Sheet1", 1, 23)+jLib.getRandomNum();

		
		//Navigate to Lead Page
		HomePage hp=new HomePage(driver);
		hp.clickOnLeads();
		
		//Navigate to Create Leads page
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadImg();
		
		//Create Leads
		CreateLeadsPage clp=new CreateLeadsPage(driver);
		clp.createLeadWithAllDetails(nameTitle, firstname, lastname, companyName, mobileNo, title, faxNo, leadSource, email, industryType, website, revenue, leadStatus, noOfEmployee, rating, secondaryEmail, street, poBoxNo, postalCodeNo, cityName, countryName, stateName, description, phoneNo);
		
		//verification
		CreateLeadInfo cli=new CreateLeadInfo(driver);
		//WebElement email1 = driver.findElement(By.id("dtlview_Email"));
		//WebElement secondaryemail1 = driver.findElement(By.id("dtlview_Secondary Email"));
		String email1=cli.toString();
		String secondaryemail1=cli.toString();
		Assert.assertTrue(email1.equals(secondaryemail1));
		System.out.println("It is a BUG!!, Both Email and Secondary Email should not be same as per Requirement");
		

	}
}

