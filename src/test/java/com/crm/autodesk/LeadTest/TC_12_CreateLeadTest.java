package com.crm.autodesk.LeadTest;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.autodesk.GenericLib.BaseClass;
import com.crm.autodesk.elementRepository.CreateLeadsPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadsPage;

@Listeners(com.crm.autodesk.GenericLib.Listners.class)

public class TC_12_CreateLeadTest extends BaseClass {

@Test(groups = "SmokeSuite",retryAnalyzer = com.crm.autodesk.GenericLib.RetryAnalyser.class)
	
	public void CreateLeadTest() throws Throwable {
		
		String nameTitle = eLib.getExcelDataTest("Sheet2", 1, 0)+jLib.getRandomNum();
		String firstname = eLib.getExcelDataTest("Sheet2", 1, 1)+jLib.getRandomNum();
		String lastname = eLib.getExcelDataTest("Sheet2", 1, 2)+jLib.getRandomNum();
		String companyName = eLib.getExcelDataTest("Sheet2", 1, 3)+jLib.getRandomNum();
		String phoneNo=eLib.getExcelDataTest("Sheet2", 1, 4)+jLib.getRandomNum();
		String mobileNo = eLib.getExcelDataTest("Sheet2", 1, 5)+jLib.getRandomNum();
		String title = eLib.getExcelDataTest("Sheet2", 1, 6)+jLib.getRandomNum();
		String faxNo = eLib.getExcelDataTest("Sheet2", 1, 7)+jLib.getRandomNum();
		String leadSource = eLib.getExcelDataTest("Sheet2", 1, 8)+jLib.getRandomNum();
		String email = eLib.getExcelDataTest("Sheet2", 1, 9)+jLib.getRandomNum();
		String industryType = eLib.getExcelDataTest("Sheet2", 1, 10)+jLib.getRandomNum();
		String website = eLib.getExcelDataTest("Sheet2", 1, 11)+jLib.getRandomNum();
		String revenue = eLib.getExcelDataTest("Sheet2", 1, 12)+jLib.getRandomNum();
		String leadStatus = eLib.getExcelDataTest("Sheet2", 1, 13)+jLib.getRandomNum();
		String noOfEmployee = eLib.getExcelDataTest("Sheet2", 1, 14)+jLib.getRandomNum();
		String rating = eLib.getExcelDataTest("Sheet2", 1, 15)+jLib.getRandomNum();
		String secondaryEmail = eLib.getExcelDataTest("Sheet2", 1, 16)+jLib.getRandomNum();
		String street = eLib.getExcelDataTest("Sheet2", 1, 17)+jLib.getRandomNum();
		String poBoxNo = eLib.getExcelDataTest("Sheet2", 1, 18)+jLib.getRandomNum();
		String postalCodeNo = eLib.getExcelDataTest("Sheet2", 1, 19)+jLib.getRandomNum();
		String cityName = eLib.getExcelDataTest("Sheet2", 1, 20)+jLib.getRandomNum();
		String countryName = eLib.getExcelDataTest("Sheet2", 1, 21)+jLib.getRandomNum();
		String stateName = eLib.getExcelDataTest("Sheet2", 1, 22)+jLib.getRandomNum();
		String description = eLib.getExcelDataTest("Sheet2", 1, 23)+jLib.getRandomNum();

		
	
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
		String tex = wLib.alertText(driver);
		Assert.assertTrue(tex.contains("Invalid"));
		wLib.acceptAlert(driver);
		System.out.println("Invalid Annual Revenue");
		
		//Assert.assertTrue(false);
		
			
		}
		
}


