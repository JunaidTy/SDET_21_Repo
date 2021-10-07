package com.crm.autodesk.LeadTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericLib.BaseClass;
import com.crm.autodesk.GenericLib.ExcelFileUtility;
import com.crm.autodesk.elementRepository.CreateLeadsPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadsPage;

public class DataProvider extends BaseClass{
	@Test(dataProvider ="ExcelDataProvider" )
	
	public void dataProvider() throws Throwable, Throwable {
		Object[][] companyName = eLib.getExcelData1("Sheet1");
		Object[][] industryType = eLib.getExcelData1("Sheet1");
		

		//Navigate to Lead Page
		HomePage hp=new HomePage(driver);
		hp.clickOnLeads();
		
		//Navigate to Create Leads page
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadImg();
	    
		//Create Leads
		
		/*public String [][]getData() 
		{
			
			
			ExcelFileUtility el=new ExcelFileUtility();
			String path="ExcelDataProvider";
			el.getExcelDataTest1(path, 1, 1);
			el.getExcelDataTest1(path, 1, 2);
			el.getExcelDataTest1(path, 1, 3);
			el.getExcelDataTest1(path, 1, 4);
					 
			}*/
			
		CreateLeadsPage clp=new CreateLeadsPage(driver);
		clp.createLeadWithAllDetails(companyName,industryType);
		
		
		
	}}


