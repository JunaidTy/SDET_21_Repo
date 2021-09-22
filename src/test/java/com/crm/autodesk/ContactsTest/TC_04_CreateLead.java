package com.crm.autodesk.ContactsTest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericLib.BaseClass;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadsPage;

public class TC_04_CreateLead extends BaseClass 
{
	@DataProvider
	public Object[][] getData() throws Throwable, Throwable
	{
		return eLib.getExcelData("Sheet1");
	}
	@Test(dataProvider = "Sheet1")
	public void createLead (String Industry,String Company ) 
	{

			//Navigate to Lead Page
			HomePage hp=new HomePage(driver);
			hp.clickOnLeads();
			
			//Navigate to Create Leads page
			LeadsPage lp=new LeadsPage(driver);
			lp.clickOnCreateLeadImg();
			
		}

}
